package lk.ijse.VehicleParkingSystem.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.VehicleParkingSystem.db.DBConnection;
import lk.ijse.VehicleParkingSystem.model.Parking;
import lk.ijse.VehicleParkingSystem.utils.CrudUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ParkingController {
    public boolean addParking(Parking p) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("INSERT INTO Parking VALUES (?,?,?,?)");
        stm.setObject(1,p.getVehNumber());
        stm.setObject(2,p.getVehType());
        stm.setObject(3,p.getParkSlot());
        stm.setObject(4,p.getParkTime());
        return stm.executeUpdate() > 0;
    }
    public static ObservableList<Parking> getAllParkings() throws ClassNotFoundException, SQLException{

        ResultSet rst = DBConnection.getInstance().getConnection().createStatement().executeQuery("Select * From Parking");
        ObservableList<Parking> list = FXCollections.observableArrayList();
        while (rst.next()){
            list.add(new Parking(rst.getString("vehNumber"),rst.getString("vehType"),
                    rst.getString("parkSlot"),rst.getString("parkTime")));
        }
        return list;
    }
//    private Integer generateParkingNumber() throws SQLException, ClassNotFoundException {
//       ResultSet set = CrudUtil.execute("SELECT parkSlot FROM Parking ORDER BY parkSlot DESC LIMIT 1");
//        if (set.next()){
//            Integer parkSlot = set.getInt(3);
//            parkSlot += 1;
//            if (parkSlot < 14){
//                return parkSlot;
//            }
//        }
//        return 1;
//    }


//    public static ArrayList<Parking> getAllParkings() throws ClassNotFoundException, SQLException{
//        ResultSet rst = DBConnection.getInstance().getConnection().createStatement().executeQuery("Select * From Parking");
//        ArrayList <Parking>parkingList=new ArrayList<>();
//        while(rst.next()){
//            Parking parking=new Parking(rst.getString("vehNumber"),rst.getString("vehType"),rst.getString("parkSlot"),rst.getString("parkTime"));
//            parkingList.add(parking);
//        }
//        return parkingList;
//    }
}
