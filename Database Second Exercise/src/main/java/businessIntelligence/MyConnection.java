package businessIntelligence;

import java.sql.*;

/**
 * Created by LWY on 2017/11/7.
 */
public class MyConnection {
    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null)
            new MyConnection();
        return connection;
    }

    public static ResultSet myQuery(String theStatement) {
        Statement stmt;
        ResultSet res = null;
        try {
            stmt = MyConnection.getConnection().createStatement();
            res = stmt.executeQuery(theStatement);
//            stmt.close();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return res;
    }

    public static void update(String theStatement) {
        Statement stmt;
        try {
            stmt = MyConnection.getConnection().createStatement();
            stmt.executeUpdate(theStatement);
//            stmt.close();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

//    public void prepare(String sql, List<T> list){
//        for (item:
//             ) {
//
//        }
//    }
    private MyConnection() {
        // JDBC 驱动名及数据库 URL
        String DB_URL = "jdbc:mysql://localhost:3306/exercise2?serverTimezone=UTC&useUnicode=true&useSSL=True&characterEncoding=utf-8&useServerPrepStmts=false&rewriteBatchedStatements=true";

        // 数据库的用户名与密码
        String USER = "lwy";
        String PASS = "Data123456+";
        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            connection.setAutoCommit(false);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
