package lk.ijse.VehicleParkingSystem.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.VehicleParkingSystem.model.Parking;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static lk.ijse.VehicleParkingSystem.stages.StageList.*;

public class ParkingFormController implements Initializable {
    @FXML
    private TableView<Parking> tblParking;
    @FXML
    private TableColumn<ParkingController, String> clmVehNumber;
    @FXML
    private TableColumn<ParkingController, String> clmVehType;
    @FXML
    private TableColumn<ParkingController, String> clmParkSlot;
    @FXML
    private TableColumn<ParkingController, String> clmParkTime;

    public void btnOnDeliveryOnAction(ActionEvent actionEvent) throws IOException {
        //setUi("DeliveryForm");
        deliveryFormStage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/DeliveryForm.fxml"))));
        deliveryFormStage.show();
        parkingFormStage.close();
    }

    public void btnVehicleFormOnAction(ActionEvent actionEvent) throws IOException {
        //setUi("VehicleForm");

        vehicleFormStage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/VehicleForm.fxml"))));
        vehicleFormStage.show();
        //parkingFormStage.close();
    }

    public void btnDriverFormOnAction(ActionEvent actionEvent) throws IOException {
        //setUi("DriverForm");
        vehicleFormStage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/DriverForm.fxml"))));
        vehicleFormStage.show();
        //parkingFormStage.close();
    }

    public void btnLogOutOnAction(ActionEvent actionEvent) {
        parkingFormStage.close();
        loginFormStage.close();
    }

    public void getAllParkingDetails(){
        try {
            ObservableList<Parking> list = ParkingController.getAllParkings();
            tblParking.getItems().clear();
            tblParking.setItems(list);

            clmVehNumber.setCellValueFactory(new PropertyValueFactory<ParkingController, String>("vehNumber"));
            clmVehType.setCellValueFactory(new PropertyValueFactory<ParkingController, String>("vehType"));
            clmParkSlot.setCellValueFactory(new PropertyValueFactory<ParkingController, String>("parkSlot"));
            clmParkTime.setCellValueFactory(new PropertyValueFactory<ParkingController, String>("parkTime"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        getAllParkingDetails();
    }

}
