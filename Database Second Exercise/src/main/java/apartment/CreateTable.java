package apartment;

import java.sql.*;

/**
 * Created by LWY on 2017/11/6.
 */
public class CreateTable {


    public static void main(String[] args) {


        String create_apartment;
        create_apartment = "CREATE TABLE IF NOT EXISTS `apartment`.`apartment` (\n" +
                "    `apartment_id` VARCHAR(50) NOT NULL,\n" +
                "    `phone` VARCHAR(8) NULL,\n" +
                "    `charge` double NULL,\n" +
                "    `area` VARCHAR(8) NOT NULL,\n" +
                "    PRIMARY KEY (`apartment_id`)\n" +
                ");";
        String create_student;
        create_student = "CREATE TABLE IF NOT EXISTS `apartment`.`student` (\n" +
                "    `student_id` VARCHAR(9) NOT NULL,\n" +
                "    `name` VARCHAR(16) NOT NULL,\n" +
                "    `gender` VARCHAR(3) NOT NULL,\n" +
                "    `department_name` VARCHAR(50) NOT NULL,\n" +
                "    PRIMARY KEY (`student_id`),\n" +
                "    INDEX (`name`)\n" +
                ");";
        String create_department;
        create_department = "CREATE TABLE IF NOT EXISTS `apartment`.`department` (\n" +
                "    `department_name` VARCHAR(50) NOT NULL,\n" +
                "    `gender` VARCHAR(3) NOT NULL,\n" +
                "    `apartment_id` VARCHAR(50) NOT NULL,\n" +
                "    unique(`department_name`,`gender`)\n" +
                ");";

        Statement stmt;
        try {
            stmt = MyConnection.getConnection().createStatement();
            stmt.executeUpdate(create_apartment);
            stmt.executeUpdate(create_student);
            stmt.executeUpdate(create_department);

            stmt.close();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }


    }
}
