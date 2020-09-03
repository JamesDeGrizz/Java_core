package client;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NicknameChangerController {
    @FXML
    TextField nickField;

    private Controller controller;

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void clickOKButton(ActionEvent actionEvent) {
        changeNickname(nickField.getText().trim());
        nickField.clear();
    }

    public void clickCancelBtn(ActionEvent actionEvent) {
        Platform.runLater(() -> {
            ((Stage) nickField.getScene().getWindow()).close();
        });
    }

    private void changeNickname(String newNickname) {
        controller.sendNewNick(newNickname);
    }
}
