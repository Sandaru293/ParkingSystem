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
import javafx.stage.Stage;
import lk.ijse.VehicleParkingSystem.model.Delivery;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static lk.ijse.VehicleParkingSystem.stages.StageList.*;
import static lk.ijse.VehicleParkingSystem.stages.StageList.deliveryFormStage;

public class DeliveryFormController implements Initializable {

    @FXML
    private TableView<Delivery> tblDelivery;

    @FXML
    private TableColumn<DeliveryController, String> clmVehNumber1;
    @FXML
    private TableColumn<DeliveryController, String> clmVehType1;
    @FXML
    private TableColumn<DeliveryController, String> clmName1;
    @FXML
    private TableColumn<DeliveryController, String> clmLeftTime;

    public void btnAddVehicleOnAction(ActionEvent actionEvent) throws IOException {
        setUi("VehicleForm");
    }

    public void btnAddDriverOnAction(ActionEvent actionEvent) throws IOException {
        setUi("DriverForm");
    }
    void setUi(String location) throws IOException {
        Scene scene =
                new Scene(FXMLLoader.load(this.getClass().getResource("../view/"+ location + ".fxml"))) ;
        Stage primaryStage =new Stage();
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        parkingFormStage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/ParkingForm.fxml"))));
        parkingFormStage.show();
        deliveryFormStage.close();
    }

    public void getAllDeliveryDetails(){
        try {
            ObservableList<Delivery> list = DeliveryController.getAllDeliverys();
            tblDelivery.getItems().clear();
            tblDelivery.setItems(list);

            clmVehNumber1.setCellValueFactory(new PropertyValueFactory<DeliveryController, String>("vehNumber"));
            clmVehType1.setCellValueFactory(new PropertyValueFactory<DeliveryController, String>("vehType"));
            clmName1.setCellValueFactory(new PropertyValueFactory<DeliveryController, String>("name"));
            clmLeftTime.setCellValueFactory(new PropertyValueFactory<DeliveryController, String>("leftTime"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        getAllDeliveryDetails();
    }


}
