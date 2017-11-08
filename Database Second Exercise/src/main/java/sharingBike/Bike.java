package sharingBike;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 * Created by LWY on 2017/11/9.
 */
public class Bike {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        if (localDate.getDayOfMonth() == 1) {
            try {
                bikeRepair();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void bikeRepair() throws SQLException {
        String query = "SELECT bike_id,use_time,last_address FROM bike.bike WHERE use_time>200.0";
        ResultSet resultSet = MyConnection.myQuery(query);
        String insert = "INSERT INTO bike.bike_repair(bike_id, use_time, last_address) VALUES (?,?,?)";
        PreparedStatement preparedStatement = MyConnection.getConnection().prepareStatement(insert);
        while (resultSet.next()) {
            preparedStatement.setInt(1,resultSet.getInt(1));
            preparedStatement.setDouble(2,resultSet.getDouble(2));
            preparedStatement.setString(3,resultSet.getString(3));
            preparedStatement.executeUpdate();
        }
        MyConnection.getConnection().commit();
    }
}
