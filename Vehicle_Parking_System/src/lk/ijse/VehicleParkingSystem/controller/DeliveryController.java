package lk.ijse.VehicleParkingSystem.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.VehicleParkingSystem.db.DBConnection;
import lk.ijse.VehicleParkingSystem.model.Delivery;
import lk.ijse.VehicleParkingSystem.model.Parking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeliveryController {
    public boolean addDelivery(Delivery d) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("INSERT INTO Delivery VALUES (?,?,?,?)");
        stm.setObject(1,d.getVehNumber());
        stm.setObject(2,d.getVehType());
        stm.setObject(3,d.getName());
        stm.setObject(4,d.getLeftTime());
        return stm.executeUpdate() > 0;
    }

    public static ObservableList<Delivery> getAllDeliverys() throws ClassNotFoundException, SQLException{
        ResultSet rst = DBConnection.getInstance().getConnection().createStatement().executeQuery("Select * From Delivery");
        ObservableList<Delivery> list = FXCollections.observableArrayList();
        while (rst.next()){
            list.add(new Delivery(rst.getString("vehNumber"),rst.getString("vehType"),
                    rst.getString("name"),rst.getString("leftTime")));
        }
        return list;
    }
}
