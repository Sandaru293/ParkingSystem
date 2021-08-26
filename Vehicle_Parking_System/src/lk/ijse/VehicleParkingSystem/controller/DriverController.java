package lk.ijse.VehicleParkingSystem.controller;

import lk.ijse.VehicleParkingSystem.db.DBConnection;
import lk.ijse.VehicleParkingSystem.model.Driver;

import java.sql.*;
import java.util.ArrayList;

public class DriverController {
    public boolean addDriver(Driver d) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/VehicleParkingSystem", "root", "mysql");
        String query = "INSERT INTO Driver VALUES (?,?,?,?,?)";
        PreparedStatement stm = con.prepareStatement(query);
        stm.setObject(1,d.getName());
        stm.setObject(2,d.getNic());
        stm.setObject(3,d.getLicenseNo());
        stm.setObject(4,d.getAddress());
        stm.setObject(5,d.getContact());
        return stm.executeUpdate() > 0;
    }

    public static Driver searchDriver(String name) throws ClassNotFoundException, SQLException {
        PreparedStatement stm = DBConnection.getInstance().getConnection().prepareStatement("Select * From Driver where name=?");
        stm.setObject(1, name);
        ResultSet rst = stm.executeQuery();
        if(rst.next()){
            Driver driver=new Driver(rst.getString("name"), rst.getString("nic"), rst.getString("licenseNo"),rst.getString("address"), rst.getInt("contact"));
            return driver;
        }
        return null;
    }

    public static ArrayList<Driver> getAllDrivers() throws ClassNotFoundException, SQLException{
        ResultSet rst = DBConnection.getInstance().getConnection().createStatement().executeQuery("Select * From Driver");
        ArrayList <Driver>driverList=new ArrayList<>();
        while(rst.next()){
            Driver driver=new Driver(rst.getString("name"), rst.getString("nic"), rst.getString("licenseNo"),rst.getString("address"), rst.getInt("contact"));
            driverList.add(driver);
        }
        return driverList;
    }

}
