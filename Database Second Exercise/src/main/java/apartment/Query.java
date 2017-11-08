package apartment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by LWY on 2017/11/7.
 */
public class Query {
    public static void main(String[] args) {
        long a = System.currentTimeMillis();

        //language=MySQL
        String queryBoy = "SELECT apartment_id FROM apartment.department WHERE department_name = '软件学院' AND gender='男'";
        String queryGirl = "SELECT apartment_id FROM apartment.department WHERE department_name = '软件学院' and gender='女'";


        try {

            ResultSet boy = MyConnection.myQuery(queryBoy);
            ResultSet girl = MyConnection.myQuery(queryGirl);
            boy.next();
            girl.next();
            String apart1 = boy.getString(1);
            String apart2 = girl.getString(1);
            System.out.println(apart1);
            System.out.println(apart2);
            String sqlUp1 = "UPDATE apartment.department\n" +
                    "SET apartment_id = '" + apart2 +
                    "' WHERE department_name = '软件学院' AND gender = '男'";

            String sqlUp2 = "UPDATE apartment.department\n" +
                    "SET apartment_id ='" + apart1 +
                    "' WHERE department_name = '软件学院' AND gender = '女'";
            System.out.println(sqlUp1);
            Statement statement = MyConnection.getConnection().createStatement();
            statement.executeUpdate(sqlUp1);
            statement.executeUpdate(sqlUp2);

            long b = System.currentTimeMillis();
            System.out.println("用时" + (b - a) + " ms");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
