package client;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    TextArea textArea;

    @FXML
    TextField msgField, loginField;

    @FXML
    HBox msgPanel, authPanel, infoPanel, btnPanel;

    @FXML
    PasswordField passField;

    @FXML
    ListView<String> clientsList;

    private Stage regStage;
    RegController regController;

    private Network network;
    private String nickname;

    public void setAuthenticated(boolean authenticated) {
        authPanel.setVisible(!authenticated);
        authPanel.setManaged(!authenticated);
        btnPanel.setVisible(!authenticated);
        btnPanel.setManaged(!authenticated);
        msgPanel.setVisible(authenticated);
        msgPanel.setManaged(authenticated);
        infoPanel.setVisible(authenticated);
        infoPanel.setManaged(authenticated);
        if (!authenticated) {
            nickname = "";
        }

        regStage = createRegWindow();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setAuthenticated(false);
        createNetwork();
        network.connect();
        passField.requestFocus();

        clientsList.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2) {
                    msgField.clear();
                    msgField.setText("/w " + clientsList.getSelectionModel().getSelectedItem() + " ");
                    msgField.requestFocus();
                    msgField.positionCaret(msgField.getText().length() - 1);
                }
            }
        );
    }

    public void sendAuth() {
        network.sendAuth(loginField.getText(), passField.getText());
        loginField.clear();
        passField.clear();
    }

    public void sendMsg() {
        if (network.sendMsg(msgField.getText())) {
            msgField.clear();
            msgField.requestFocus();
        }
    }

    public void tryToReg(String login, String password, String nickname) {
        network.sendReg(login, password, nickname);
        regStage.hide();
    }

    public void sendExit() {
        network.sendMsg("/end");
    }

    public void showAlert(String msg) {
        Platform.runLater(() -> {
            Alert alert = new Alert(Alert.AlertType.WARNING, msg, ButtonType.OK);
            alert.showAndWait();
        });
    }

    public void createNetwork() {
        network = new Network();
        network.setCallOnException(args -> showAlert(args[0]));

        network.setCallOnCloseConnection(args -> setAuthenticated(false));

        network.setCallOnAuthenticated(args -> {
            setAuthenticated(true);
            nickname = args[0];
        });

        network.setCallOnMsgReceived(args -> {
            String msg = args[0];
            if (msg.startsWith("/clients ")) {
                String[] tokens = msg.split("\\s");
                Platform.runLater(() -> {
                    clientsList.getItems().clear();
                    for (int i = 1; i < tokens.length; i++) {
                        if (!nickname.equals(tokens[i])) {
                            clientsList.getItems().add(tokens[i]);
                        }
                    }
                });
            } else if (msg.startsWith("/exception ")) {
                showAlert(msg.substring(11));
            } else {
                textArea.appendText(msg + "\n");
            }
        });
    }

    public void showRegWindow(ActionEvent actionEvent) {
        regStage.show();
    }

    private Stage createRegWindow() {
        Stage stage = new Stage();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/reg.fxml"));
            Parent root = fxmlLoader.load();

            stage.setTitle("Chat reg window");
            stage.setScene(new Scene(root, 350, 250));
            stage.initModality(Modality.APPLICATION_MODAL);

            regController = fxmlLoader.getController();
            regController.setController(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return stage;
    }
}