
package com.mysql.FoodDelivery;

import java.sql.*;
import java.util.Scanner;

public class OrderItem {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // Database connection details
        String url = "jdbc:mysql://localhost:3306/praveen";
        String un = "root";
        String pw = "Praveen@123";
        String sql = "INSERT INTO OrderItem (order_id, menu_id, quantity) VALUES (?, ?, ?)";

        // Load the MySQL JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Establish a connection to the database
        Connection conn = DriverManager.getConnection(url, un, pw);
        PreparedStatement pstmt = conn.prepareStatement(sql);

        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Collect user input for order_id, menu_id, and quantity
        System.out.println("Enter order ID:");
        int orderId = scanner.nextInt();
        pstmt.setInt(1, orderId);

        System.out.println("Enter menu ID:");
        int menuId = scanner.nextInt();
        pstmt.setInt(2, menuId);

        System.out.println("Enter quantity:");
        int quantity = scanner.nextInt();
        pstmt.setInt(3, quantity);

        // Execute the SQL insert statement
        pstmt.executeUpdate();

        System.out.println("Order item added successfully.");

        // Close the resources
        pstmt.close();
        conn.close();
    }
}
