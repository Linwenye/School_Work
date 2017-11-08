package sharingBike;

import java.io.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by LWY on 2017/11/7.
 */
public class ReadTxt {
    public static void main(String[] args) {
        long a = System.currentTimeMillis();
        new ReadTxt().readUser();
        new ReadTxt().readBike();
        new ReadTxt().readRecord();
        long b = System.currentTimeMillis();
        System.out.println("running time is " + (b - a) + " ms");
    }

    public void readUser() {
        String filePath = "C:\\Users\\Venric\\Desktop\\database\\Homework II_design\\user.txt";
        try {
            File fileView = new File(filePath);

            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileView), "UTF-8"));

            String line;

            String sql = "INSERT INTO bike.user (user_id, username, phone, remain) VALUES (?,?,?,?)";

            PreparedStatement preparedStatement = MyConnection.getConnection().prepareStatement(sql);
            while ((line = in.readLine()) != null) {
                String[] lins = line.split(";");

                preparedStatement.setInt(1, Integer.valueOf(lins[0]));
                preparedStatement.setString(2, lins[1]);
                preparedStatement.setString(3, lins[2]);
                preparedStatement.setDouble(4, Double.valueOf(lins[3]));
                preparedStatement.executeUpdate();
            }

            in.close();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void readBike() {
        String filePath = "C:\\Users\\Venric\\Desktop\\database\\Homework II_design\\bike.txt";
        try {
            File fileView = new File(filePath);

            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileView), "UTF-8"));
            String line;
            String sql = "INSERT INTO bike.bike(bike_id) VALUES (?)";
            PreparedStatement preparedStatement = MyConnection.getConnection().prepareStatement(sql);
            while ((line = in.readLine()) != null) {
                preparedStatement.setInt(1, Integer.valueOf(line));
                preparedStatement.executeUpdate();
            }
            MyConnection.getConnection().commit();
            in.close();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void readRecord() {
        String filePath = "C:\\Users\\Venric\\Desktop\\database\\Homework II_design\\record.txt";
        try {
            File fileView = new File(filePath);

            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileView), "UTF-8"));
            String sql = "INSERT INTO bike.record(user_id, bike_id,start_time, end_time, start_address, end_address,price) VALUES (?,?,?,?,?,?,?)";

            PreparedStatement preparedStatement = MyConnection.getConnection().prepareStatement(sql);
            String line;
            final int batchSize = 1000;
            int count = 0;
            while ((line = in.readLine()) != null) {
                String[] lins = line.split(";");
                int value;
                if (count == 0) {
                    value = 11127;
                } else {
                    value = Integer.parseInt(lins[0]);
                }
                preparedStatement.setInt(1, value);
                preparedStatement.setInt(2, Integer.valueOf(lins[1]));

                SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss");
                Timestamp start = new Timestamp(formatter.parse(lins[3]).getTime());
                Timestamp end = new Timestamp(formatter.parse(lins[5]).getTime());
                preparedStatement.setTimestamp(3, start);
                preparedStatement.setTimestamp(4, end);
                preparedStatement.setString(5, lins[2]);
                preparedStatement.setString(6, lins[4]);
                preparedStatement.setDouble(7, calculatePrice(start, end));
                preparedStatement.addBatch();

                if (++count % batchSize == 0) {
                    preparedStatement.executeBatch();
                }
            }
            preparedStatement.executeBatch();
            MyConnection.getConnection().commit();
            in.close();
        } catch (SQLException | IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    private double calculatePrice(Timestamp start, Timestamp end) {
        // this code can be rewritten with table driven
        //but for speed, following code was written.Shamed.
        double minute = (end.getTime() - start.getTime()) / 1000.0 / 60;
        double price = 0;
        if (minute <= 30) {
            price = 1;
        } else if (minute > 30 && minute <= 60) {
            price = 2;
        } else if (minute > 60 && minute <= 90) {
            price = 3;
        } else if (minute > 90) {
            price = 4;
        }
        return price;
    }
}
