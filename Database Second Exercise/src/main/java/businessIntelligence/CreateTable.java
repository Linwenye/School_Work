package businessIntelligence;

import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by LWY on 2017/11/6.
 */
public class CreateTable {


    public static void main(String[] args) {
        createTable();
        addConstraint();
    }

    public static void createTable() {
        String create_customer;
        create_customer = "CREATE TABLE IF NOT EXISTS `BI`.`customer` (\n" +
                "  `customer_id` INT,\n" +
                "  `username` VARCHAR(16) NOT NULL,\n" +
                "  `remain` DOUBLE NOT NULL,\n" +
                "  `phone` VARCHAR(11) NULL,\n" +
                "  `address` VARCHAR(255) NULL,\n" +
                "  `age` INT,\n"+
                "  `gender` VARCHAR(255),\n"+
                "  `education` VARCHAR(255));";


        String create_order_date;
        create_order_date = "CREATE TABLE IF NOT EXISTS `BI`.`order_date` (\n" +
                "  `order_date_id` INT NOT NULL,\n" +
                "  `order_date` DATE NOT NULL,\n" +
                "  `week` VARCHAR(255) NOT NULL,\n" +
                "  `month` VARCHAR(255) NOT NULL); "
        ;

        String create_product_date;
        create_product_date = "CREATE TABLE IF NOT EXISTS `BI`.`product_date` (\n" +
                "  `product_date_id` INT NOT NULL,\n" +
                "  `start_date` DATE NOT NULL,\n" +
                "  `start_week` VARCHAR(255) NOT NULL,\n" +
                "  `start_month` VARCHAR(255) NOT NULL,\n" +
                "  `end_date` DATE NOT NULL,\n" +
                "  `end_week` VARCHAR(255) NOT NULL,\n" +
                "   `end_month` VARCHAR(255) NOT NULL ); ";

        String create_product;
        create_product = "CREATE TABLE IF NOT EXISTS `BI`.`product` (\n" +
                "  `product_id` INT NOT NULL,\n" +
                "  `product_date_id` INT NOT NULL,\n" +
                "  `price` DOUBLE NULL,\n" +
                "   `sell_num` INT,\n"+
                "   `stock` INT,\n"+
                "   `interst_rate` DOUBLE," +
                "FOREIGN KEY (product_date_id) REFERENCES product_date(product_date_id));";

        String create_order;
        create_order = "CREATE TABLE IF NOT EXISTS `BI`.`order` (\n" +
                "  `order_id` INT NOT NULL,\n" +
                "  `product_id` INT NOT NULL,\n" +
                "  `order_date_id` INT NOT NULL,\n" +
                "  `customer_id` INT NOT NULL,\n" +
                "  `num` INT NOT NULL,\n" +
                "  `sum_price` DOUBLE NULL," +
                "FOREIGN KEY(product_id) REFERENCES product(product_id)," +
                "FOREIGN KEY (order_date_id) REFERENCES order_date(order_date_id)," +
                "FOREIGN KEY (customer_id) REFERENCES customer(customer_id));\n";


        Statement stmt;
        try {
            stmt = MyConnection.getConnection().createStatement();
            stmt.executeUpdate(create_customer);
            stmt.executeUpdate(create_order_date);
            stmt.executeUpdate(create_product_date);
            stmt.executeUpdate(create_product);
            stmt.executeUpdate(create_order);
            stmt.close();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

    }

    public static void addConstraint() {
        String addOrderPrimary = "ALTER TABLE bi.order ADD PRIMARY KEY(order_id)";
        String addCustomerPrimary = "ALTER TABLE bi.customer ADD PRIMARY KEY(customer_id)";
        String addProductPrimary = "ALTER TABLE bi.product ADD PRIMARY KEY(product_id)";
        String addProductDatePrimary = "ALTER TABLE bi.product_date ADD PRIMARY KEY(product_date_id)";
        String addOrderDatePrimary = "ALTER TABLE bi.order_date ADD PRIMARY KEY(order_date_id)";
        MyConnection.update(addOrderPrimary);
//        MyConnection.update(addCustomerPrimary);
//        MyConnection.update(addOrderDatePrimary);
//        MyConnection.update(addProductDatePrimary);
//        MyConnection.update(addProductPrimary);
    }
}
