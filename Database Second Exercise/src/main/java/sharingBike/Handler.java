package sharingBike;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by LWY on 2017/11/7.
 */
public class Handler {
    public static void main(String[] args) {
        try {
//            insertAddress();
            changeChargeAndSetEnable();
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        addTriggerToUser();
//        addTriggerToRecord();
    }


    public static void insertAddress() throws SQLException {
        String select = "SELECT user_id,end_address\n" +
                "FROM bike.record R1\n" +
                "WHERE TIME(R1.end_time) BETWEEN '18:00:00' AND '23:59:59'\n" +
                "GROUP BY user_id\n" +
                "HAVING count(*) >= ALL (SELECT count(*)\n" +
                "  FROM bike.record R2\n" +
                "  WHERE R1.user_id = R2.user_id AND TIME(R2.end_time) " +
                "BETWEEN '18:00:00' AND '23:59:59')";
        ResultSet myquery = MyConnection.myQuery(select);

        String update = "UPDATE bike.user SET address = ? WHERE user_id = ?";
        PreparedStatement preparedStatement = MyConnection.getConnection().prepareStatement(update);

        final int batchSize = 1000;
        int count = 0;
        while (myquery.next()) {
            preparedStatement.setString(2, myquery.getString(1));
            preparedStatement.setString(1, myquery.getString(2));
            preparedStatement.addBatch();

            if (++count % batchSize == 0) {
                preparedStatement.executeBatch();
            }
        }
        preparedStatement.executeBatch();
        MyConnection.getConnection().commit();
    }

    public static void changeChargeAndSetEnable() throws SQLException {
        String changeCharge = "UPDATE bike.user SET remain=remain-? WHERE bike.user.user_id=?";
        PreparedStatement preparedStatement = MyConnection.getConnection().prepareStatement(changeCharge);
        String price = "SELECT user_id,sum(price) FROM bike.record GROUP BY user_id";
        ResultSet resultSet = MyConnection.myQuery(price);
        final int batchSize = 1000;
        int count = 0;
        while (resultSet.next()) {
            preparedStatement.setInt(2, resultSet.getInt(1));
            preparedStatement.setDouble(1, resultSet.getDouble(2));
            preparedStatement.addBatch();
            if (++count % batchSize == 0) {
                preparedStatement.executeBatch();
            }
        }
        preparedStatement.executeBatch();
        MyConnection.getConnection().commit();
    }

    public static void addTriggerToUser() {
        String sql = "CREATE TRIGGER user_enable\n" +
                "BEFORE UPDATE ON bike.user\n" +
                "FOR EACH ROW\n" +
                "  BEGIN\n" +
                "    IF NEW.remain < 0\n" +
                "    THEN SET NEW.enable = 0;\n" +
                "    ELSEIF NEW.remain >= 0\n" +
                "      THEN SET NEW.enable = 1;\n" +
                "    END IF;\n" +
                "  END;\n";
        MyConnection.update(sql);

    }

    public static void addTriggerToRecord() {
        String sql = "CREATE TRIGGER record_bike\n" +
                "after INSERT ON bike.record\n" +
                "FOR EACH ROW\n" +
                "BEGIN\n" +
                "UPDATE bike.bike SET last_address=NEW.end_address AND use_time = use_time+(NEW.end_time-NEW.start_time)/3600.0 WHERE bike_id=NEW.bike_id;" +
                "END\n";
        MyConnection.update(sql);

    }
}
