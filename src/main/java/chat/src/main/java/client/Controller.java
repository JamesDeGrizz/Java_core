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

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ResourceBundle;

public class Controller implements Initializable {

	@FXML
	MenuBar menubar;

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

	private Stage nickChangerStage;
	NicknameChangerController nickChangeController;

	private Network network;
	private String nickname;
	private String login;

	public void setAuthenticated(boolean authenticated) {
		authPanel.setVisible(!authenticated);
		authPanel.setManaged(!authenticated);
		btnPanel.setVisible(!authenticated);
		btnPanel.setManaged(!authenticated);
		menubar.setVisible(authenticated);
		menubar.setManaged(authenticated);
		msgPanel.setVisible(authenticated);
		msgPanel.setManaged(authenticated);
		infoPanel.setVisible(authenticated);
		infoPanel.setManaged(authenticated);
		if (!authenticated) {
			nickname = "";
			login = "";
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		setAuthenticated(false);
		createNetwork();
		network.connect();
		passField.requestFocus();
		regStage = createRegWindow();
		nickChangerStage = createNicknameChanger();

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

	private Stage createNicknameChanger() {
		Stage stage = new Stage();
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/nickChanger.fxml"));
			Parent root = fxmlLoader.load();

			stage.setTitle("Напишите свой новый ник");
			stage.setScene(new Scene(root, 350, 250));
			stage.initModality(Modality.APPLICATION_MODAL);

			nickChangeController = fxmlLoader.getController();
			nickChangeController.setController(this);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return stage;
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

	public void sendNewNick(String newNick) {
		network.sendChangeNick(nickname, newNick);
		nickname = newNick;
		nickChangerStage.hide();
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
			login = args[1];
			loadOrCreateHistoryFile();
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
				addToHistory(msg);
			}
		});
	}

	public void showRegWindow(ActionEvent actionEvent) {
		regStage.show();
	}

	public void showNickChangerWindow(ActionEvent actionEvent) {
		nickChangerStage.show();
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

	public void closeApp(ActionEvent actionEvent) {
		this.sendExit();
		Platform.exit();
		System.exit(0);
	}

	private void loadOrCreateHistoryFile() {
		File history = new File("history_" + login + ".txt");

		try {
			if (history.exists()) {
				FileReader reader = new FileReader(history);

				BufferedReader br = new BufferedReader(reader);
				long lineNumber = Files.lines(Paths.get(history.getName())).count();
				long currentLineNumber = 0;
				while (currentLineNumber < (lineNumber - 100)) {
					br.readLine();
					++currentLineNumber;
				}

				String fileLine;
				StringBuilder bld = new StringBuilder();
				while ((fileLine = br.readLine()) != null) {
					bld.append(fileLine);
					if (!fileLine.endsWith("\n")) {
						bld.append("\n");
					}
				}

				textArea.appendText(bld.toString());
				br.close();
				reader.close();
			} else {
				history.createNewFile();
			}
		} catch (FileNotFoundException e) {
			e.getMessage();
			e.printStackTrace();
		} catch (IOException e) {
			e.getMessage();
			e.printStackTrace();
		}
	}

	private void addToHistory(String text) {
		File history = new File("history_" + login + ".txt");

		try {
			if (history.exists()) {
				FileOutputStream out = new FileOutputStream(history, true);
				out.write(text.getBytes());

				if (!text.endsWith("\n")) {
					out.write("\n".getBytes());
				}

				out.close();
			}
		} catch (FileNotFoundException e) {
			e.getMessage();
			e.printStackTrace();
		} catch (IOException e) {
			e.getMessage();
			e.printStackTrace();
		}
	}
}