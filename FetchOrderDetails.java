package com.mysql.FoodDelivery;

import java.sql.*;
import java.util.Scanner;

public class FetchOrderDetails {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // Database connection details
        String url = "jdbc:mysql://localhost:3306/praveen";
        String un = "root";
        String pw = "Praveen@123";

        // Load the MySQL JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Establish a connection to the database
        Connection conn = DriverManager.getConnection(url, un, pw);

        Scanner scanner = new Scanner(System.in);

        // Get user input for name and order_id
        System.out.println("Enter customer name:");
        String customerName = scanner.nextLine();

        System.out.println("Enter order ID:");
        int orderId = scanner.nextInt();

        // SQL query to fetch details from all tables
        String sql = 
            "SELECT c.name AS customer_name, " +
            "       c.address AS customer_address, " +
            "       c.phone AS customer_phone, " +
            "       r.name AS restaurant_name, " +
            "       r.address AS restaurant_address, " +
            "       r.phone AS restaurant_phone, " +
            "       o.order_date, " +
            "       o.status AS order_status, " +
            "       oi.menu_id, " +
            "       m.item_name AS menu_item_name, " +
            "       m.price AS menu_item_price, " +
            "       oi.quantity, " +
            "       d.delivery_address, " +
            "       d.delivery_status, " +
            "       d.delivery_date " +
            "FROM `Order1` o " +
            "JOIN Customer c ON o.customer_id = c.id " +
            "JOIN Restaurant r ON o.restaurant_id = r.id " +
            "JOIN OrderItem oi ON o.id = oi.order_id " +
            "JOIN Menu m ON oi.menu_id = m.id " +
            "LEFT JOIN Delivery1 d ON o.id = d.order_id " +
            "WHERE c.name = ? AND o.id = ?";

        // Prepare and execute the SQL query
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, customerName);
        pstmt.setInt(2, orderId);

        ResultSet rs = pstmt.executeQuery();

        // Display the results
        while (rs.next()) {
            System.out.println("Customer Name: " + rs.getString("customer_name"));
            System.out.println("Customer Address: " + rs.getString("customer_address"));
            System.out.println("Customer Phone: " + rs.getString("customer_phone"));
            System.out.println("Restaurant Name: " + rs.getString("restaurant_name"));
            System.out.println("Restaurant Address: " + rs.getString("restaurant_address"));
            System.out.println("Restaurant Phone: " + rs.getString("restaurant_phone"));
            System.out.println("Order Date: " + rs.getDate("order_date"));
            System.out.println("Order Status: " + rs.getString("order_status"));
            System.out.println("Menu Item Name: " + rs.getString("menu_item_name"));
            System.out.println("Menu Item Price: " + rs.getDouble("menu_item_price"));
            System.out.println("Quantity: " + rs.getInt("quantity"));
            System.out.println("Delivery Address: " + rs.getString("delivery_address"));
            System.out.println("Delivery Status: " + rs.getString("delivery_status"));
            System.out.println("Delivery Date: " + rs.getDate("delivery_date"));
            System.out.println("-------------------------");
        }

        // Close the resources
        rs.close();
        pstmt.close();
        conn.close();
    }
}
