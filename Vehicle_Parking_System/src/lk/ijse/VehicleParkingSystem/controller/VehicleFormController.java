package lk.ijse.VehicleParkingSystem.controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import lk.ijse.VehicleParkingSystem.model.Vehicle;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class VehicleFormController implements Initializable {
    public TextField txtVehNumber;
    public TextField txtVehType;
    public TextField txtMaxWeight;
    public TextField txtNoPassenger;
    public ComboBox cmbVehNumber;
    public ComboBox cmbVehType;

    public void btnAddVehicleOnAction(ActionEvent actionEvent) throws ClassNotFoundException, SQLException {
        Vehicle v1 = new Vehicle(
                txtVehNumber.getText(),
                txtVehType.getText(),
                Integer.parseInt(txtMaxWeight.getText()),
                Integer.parseInt(txtNoPassenger.getText())
        );
        try {

            if (new VehicleController().addVehicle(v1))
                new Alert(Alert.AlertType.CONFIRMATION, "Saved").show();
            else
                new Alert(Alert.AlertType.WARNING, "Try Again").show();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadAllVehicles();
        setCmbVehNumber();
    }

    public void cmbVehTypeOnAction(ActionEvent actionEvent) {
        try {
            Vehicle v1 = VehicleController.searchVehicle(cmbVehType.getSelectionModel().getSelectedItem().toString());
            if (v1 != null) {
                txtVehNumber.setText(v1.getVehType());
            } else {
                new Alert(Alert.AlertType.WARNING, "Empty Result").show();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void cmbVehNumberOnAction(ActionEvent actionEvent) {
        try {
            Vehicle v1 = VehicleController.searchVehicle(cmbVehNumber.getSelectionModel().getSelectedItem().toString());
            if (v1 != null) {
                txtVehType.setText(v1.getVehType());
            } else {
                new Alert(Alert.AlertType.WARNING, "Empty Result").show();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void loadAllVehicles() {
        try {
            ArrayList<Vehicle> vehicles = VehicleController.getAllVehicles();
            for (Vehicle v : vehicles) {
                // txtVehType.get   //addItem(v.getVehType());//getItems().add(c.getCouId());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void setCmbVehNumber() {
        try {
            ArrayList<Vehicle> vehicles = VehicleController.getAllVehicles();
            cmbVehNumber.getItems().clear();
            for (Vehicle v : vehicles) {
                cmbVehNumber.getItems().add(v.getVehNumber());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}







