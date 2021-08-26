package lk.ijse.VehicleParkingSystem.controller;

import lk.ijse.VehicleParkingSystem.db.DBConnection;
import lk.ijse.VehicleParkingSystem.model.Vehicle;
import lk.ijse.VehicleParkingSystem.utils.CrudUtil;

import java.sql.*;
import java.util.ArrayList;

public class VehicleController {
    public boolean addVehicle(Vehicle v) throws ClassNotFoundException, SQLException {
        return CrudUtil.execute("INSERT INTO Vehicle VALUES (?,?,?,?)",v.getVehNumber(),v.getVehType(),v.getMaxWeight(),v.getNoPassenger());
//        Connection connection = DBConnection.getInstance().getConnection();
//        PreparedStatement stm = connection.prepareStatement("INSERT INTO Vehicle VALUES (?,?,?,?)");
//        stm.setObject(1,v.getVehNumber());
//        stm.setObject(2,v.getVehType());
//        stm.setObject(3,v.getMaxWeight());
//        stm.setObject(4,v.getNoPassenger());
//        return stm.executeUpdate() > 0;
    }

    public static Vehicle searchVehicle(String vehNumber) throws ClassNotFoundException, SQLException {
        PreparedStatement stm = DBConnection.getInstance().getConnection().prepareStatement("Select * From Vehicle where vehNumber=?");
        stm.setObject(1, vehNumber);
        ResultSet rst = stm.executeQuery();
        if(rst.next()){
            Vehicle vehicle=new Vehicle(rst.getString("vehNumber"), rst.getString("vehType"), rst.getInt("maxWeight"), rst.getInt("noPassenger"));
            return vehicle;
        }
        return null;
    }

    public static ArrayList<Vehicle> getAllVehicles() throws ClassNotFoundException, SQLException{
        ResultSet rst = DBConnection.getInstance().getConnection().createStatement().executeQuery("Select * From Vehicle");
        ArrayList <Vehicle>vehicleList=new ArrayList<>();
        while(rst.next()){
            Vehicle vehicle=new Vehicle(rst.getString("vehNumber"),rst.getString("vehType"),rst.getInt("maxWeight"),rst.getInt("noPassenger"));
            vehicleList.add(vehicle);
        }
        return vehicleList;
    }
}

