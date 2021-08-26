package lk.ijse.VehicleParkingSystem.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import lk.ijse.VehicleParkingSystem.model.Delivery;
import lk.ijse.VehicleParkingSystem.model.Driver;
import lk.ijse.VehicleParkingSystem.model.Parking;
import lk.ijse.VehicleParkingSystem.model.Vehicle;
import lk.ijse.VehicleParkingSystem.utils.CrudUtil;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import static lk.ijse.VehicleParkingSystem.stages.StageList.dashBoardFormStage;
import static lk.ijse.VehicleParkingSystem.stages.StageList.parkingFormStage;

public class DashBoardFromController implements Initializable {
    public TextField txtVehType;
    public Label lblTime;
    public Label lblDate;
    public ComboBox cmbVehNumber;
    public ComboBox cmbName;
    public TextField txtNic;
    public Label lblParkSlot;
    public TextField txtParkSlot;

    public void btnManageOnAction(ActionEvent actionEvent) throws IOException {
        parkingFormStage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/ParkingForm.fxml"))));
        parkingFormStage.show();
        dashBoardFormStage.close();
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

    private void loadAllDrivers() {
        try {
            ArrayList<Driver> drivers = DriverController.getAllDrivers();
            for (Driver d : drivers) {
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

    public void setCmbName() {
        try {
            ArrayList<Driver> drivers = DriverController.getAllDrivers();
            cmbName.getItems().clear();
            for (Driver d : drivers) {
                cmbName.getItems().add(d.getName());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setCmbVehNumber();
        loadAllVehicles();
        setCmbName();
        loadAllDrivers();
        generateDate();
        generateTime();
        generateParkingNumber();
    }

    private void generateDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date da = new Date();
        String date = sdf.format(da);
        lblDate.setText(date);
    }

    private void generateTime(){
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm aa");
        Date da = new Date();
        String date = sdf.format(da);
        lblTime.setText(date);
    }


    public void cmbNameOnAction(ActionEvent actionEvent) {
        try {
            Driver d1 = DriverController.searchDriver(cmbName.getSelectionModel().getSelectedItem().toString());
            if (d1 != null) {
                txtNic.setText(d1.getNic());
            } else {
                new Alert(Alert.AlertType.WARNING, "Empty Result").show();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void btnParkingOnAction(ActionEvent actionEvent) {
        Parking p1 = new Parking(
                cmbVehNumber.getSelectionModel().getSelectedItem().toString(),
                txtVehType.getText(),
                lblParkSlot.getText(),
                lblTime.getText()
        );
        try {
            if (new ParkingController().addParking(p1)){
                new Alert(Alert.AlertType.CONFIRMATION, "Saved").show();
            } else{
                new Alert(Alert.AlertType.WARNING, "Try Again").show();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void btnDiliveryOnAction(ActionEvent actionEvent) {
        Delivery d1 = new Delivery(
                cmbVehNumber.getSelectionModel().getSelectedItem().toString(),
                txtVehType.getText(),
                cmbName.getSelectionModel().getSelectedItem().toString(),
                lblTime.getText()
        );
        try {

            if (new DeliveryController().addDelivery(d1))
                new Alert(Alert.AlertType.CONFIRMATION, "Saved").show();
            else
                new Alert(Alert.AlertType.WARNING, "Try Again").show();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
//    tempId += 1;
//            if (tempId < 99) {
//        return "D0" + tempId;
//    } else {
//        return "D" + tempId;
//    }

    private String generateParkingNumber()  {

        ResultSet rst = null;
        try {
            rst = CrudUtil.execute("SELECT parkSlot FROM Parking ORDER BY parkSlot DESC LIMIT 1");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            if (rst.next()) {
                int parkSlot = 0;
                try {
                    parkSlot = Integer.parseInt(rst.getString(1));
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                parkSlot += 1;
                    if (parkSlot < 99) {
                        return "" + parkSlot;
                    } else {
                        return "" + parkSlot;
                    }
                }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return "1";
        }


}
//asdsdasdasdasdasdasdasdasdasdas