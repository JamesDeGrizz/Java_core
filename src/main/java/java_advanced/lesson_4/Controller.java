package java_advanced.lesson_4;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
   @FXML
    private TextArea textArea;

    @FXML
    private TextField textField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        textField.setOnKeyPressed( e -> {
            if (e.getCode() == KeyCode.ENTER) {
                sendMessage();
            }
        });
    }

    public void menuItemExitAction(ActionEvent actionEvent) {
        actionEvent.consume();
        Platform.exit();
    }

    public void sendButtonClicked(ActionEvent actionEvent) {
        actionEvent.consume();
        sendMessage();
    }

    private void sendMessage() {
        String text = textField.getText();
        textField.clear();
        if (text != null && !text.isEmpty()) {
            textArea.appendText(text + '\n');
        }
    }
}
