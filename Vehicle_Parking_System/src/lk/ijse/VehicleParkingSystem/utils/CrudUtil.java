package lk.ijse.VehicleParkingSystem.utils;



import lk.ijse.VehicleParkingSystem.db.DBConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CrudUtil {
    public static <T>T execute(String sql, Object...params) throws SQLException, ClassNotFoundException {
        PreparedStatement stm = DBConnection.getInstance().getConnection().prepareStatement(sql);
        for (int i = 0; i < params.length; i++) {
            stm.setObject((i + 1), params[i]);
        }

        if (sql.startsWith("SELECT")){
            // execute query
            return (T)stm.executeQuery();
        }
        // executeUpdate
        return (T)(Boolean)(stm.executeUpdate()>0);
    }
}
