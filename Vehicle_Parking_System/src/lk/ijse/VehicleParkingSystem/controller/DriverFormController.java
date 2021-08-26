package lk.ijse.VehicleParkingSystem.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import lk.ijse.VehicleParkingSystem.model.Driver;

import java.sql.SQLException;

public class DriverFormController{
    public TextField txtName;
    public TextField txtNic;
    public TextField txtLicenseNo;
    public TextField txtAddress;
    public TextField txtContact;

    public void btnAddDriverOnAction(ActionEvent actionEvent) {
        Driver d1 = new Driver(
                txtName.getText(),
                txtNic.getText(),
                txtAddress.getText(),
                txtAddress.getText(),
                Integer.parseInt(txtContact.getText())
        );
        try {

            if (new DriverController().addDriver(d1))
                new Alert(Alert.AlertType.CONFIRMATION, "Saved").show();
            else
                new Alert(Alert.AlertType.WARNING, "Try Again").show();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}
