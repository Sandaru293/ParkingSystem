package lk.ijse.VehicleParkingSystem.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import lk.ijse.VehicleParkingSystem.stages.StageList;

import java.io.IOException;

public class LoginFormController extends StageList {
    public TextField txtUserName;
    public PasswordField password;

    public void btnLoginOnAction(ActionEvent actionEvent) throws IOException {
        if (txtUserName.getText().length()>0 && password.getText().length()>0){
            if (txtUserName.getText().equals("qwe") && password.getText().equals("1234")){
                dashBoardFormStage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/DashBoardForm.fxml"))));
                dashBoardFormStage.show();
                loginFormStage.close();
            }else{
                new Alert(Alert.AlertType.WARNING,"Worng Name or Paassword", ButtonType.OK).show();
            }
        }else {
            new Alert(Alert.AlertType.CONFIRMATION,"Field Can not Be Empty",ButtonType.OK).show();
        }
    }
}
