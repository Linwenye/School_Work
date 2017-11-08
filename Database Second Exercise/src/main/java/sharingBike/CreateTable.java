package sharingBike;

import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by LWY on 2017/11/6.
 */
public class CreateTable {


    public static void main(String[] args) {
//      createTable();
        addConstraint();
    }

    public static void createTable() {
        String create_user;
        create_user = "CREATE TABLE IF NOT EXISTS `bike`.`user` (\n" +
                "  `user_id` INT NULL,\n" +
                "  `username` VARCHAR(16) NOT NULL,\n" +
                "  `remain` DOUBLE NOT NULL,\n" +
                "  `phone` VARCHAR(11) NULL,\n" +
                "  `address` VARCHAR(255) NULL,\n" +
                "  `enalbe` TINYINT NULL);";
        String create_record;
        create_record = "CREATE TABLE IF NOT EXISTS `bike`.`record` (\n" +
//                "  `record_id` INT NULL,\n" +
                "  `start_time` DATETIME NULL,\n" +
                "  `end_time` DATETIME NULL,\n" +
                "  `start_address` VARCHAR(255) NULL,\n" +
                "  `end_address` VARCHAR(255) NULL,\n" +
                "  `user_id` INT NULL,\n" +
                "  `bike_id` INT NULL,\n" +
                "  `price` DOUBLE NULL);\n";
        String create_bike;
        create_bike = "CREATE TABLE IF NOT EXISTS `bike`.`bike` (\n" +
                "  `bike_id` INT NOT NULL,\n" +
                "  `last_address` VARCHAR(255) NULL,\n" +
                "  `use_time` DOUBLE NULL,\n" +
                "  `enable` TINYINT NULL);";
        String create_bike_repair;
        create_bike_repair = "CREATE TABLE IF NOT EXISTS `bike`.`bike_repair` (\n" +
                "  `bike_id` INT NOT NULL,\n" +
                "  `use_time` DOUBLE NOT NULL,\n" +
                "  `last_address` VARCHAR(255) NULL);";

        Statement stmt;
        try {
            stmt = MyConnection.getConnection().createStatement();
            stmt.executeUpdate(create_user);
            stmt.executeUpdate(create_bike);
            stmt.executeUpdate(create_bike_repair);
            stmt.executeUpdate(create_record);

            stmt.close();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

    }

    public static void addConstraint() {
        String addBikePrimary = "ALTER TABLE bike.bike ADD PRIMARY KEY(bike_id)";
        String addUserPrimary = "ALTER TABLE bike.user ADD PRIMARY KEY(user_id)";
        String addRecordIndexUser = "ALTER TABLE bike.record ADD INDEX (user_id)";
        String addRecordIndexTime = "ALTER TABLE bike.record ADD INDEX (end_time)";
        String addBikeIndex = "ALTER TABLE bike.bike ADD INDEX (use_time)";
        MyConnection.update(addBikePrimary);
        MyConnection.update(addUserPrimary);
        MyConnection.update(addRecordIndexUser);
        MyConnection.update(addRecordIndexTime);
        MyConnection.update(addBikeIndex);
    }
}
