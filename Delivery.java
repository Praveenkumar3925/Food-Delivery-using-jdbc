
package com.mysql.FoodDelivery;

import java.sql.*;
import java.util.Scanner;

public class Delivery {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // Database connection details
        String url = "jdbc:mysql://localhost:3306/praveen";
        String un = "root";
        String pw = "Praveen@123";
        String sql = "INSERT INTO Delivery1 (order_id, delivery_address, delivery_status, delivery_date) VALUES (?, ?, ?, ?)";

        // Load the MySQL JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Establish a connection to the database
        Connection conn = DriverManager.getConnection(url, un, pw);
        PreparedStatement pstmt = conn.prepareStatement(sql);

        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Collect user input for order_id, delivery_address, delivery_status, and delivery_date
        System.out.println("Enter order ID:");
        int orderId = scanner.nextInt();
        pstmt.setInt(1, orderId);

        scanner.nextLine(); // Consume newline

        System.out.println("Enter delivery address:");
        String deliveryAddress = scanner.nextLine();
        pstmt.setString(2, deliveryAddress);

        System.out.println("Enter delivery status:");
        String deliveryStatus = scanner.nextLine();
        pstmt.setString(3, deliveryStatus);

        System.out.println("Enter delivery date (YYYY-MM-DD):");
        String deliveryDate = scanner.nextLine();
        pstmt.setDate(4, Date.valueOf(deliveryDate));

        // Execute the SQL insert statement
        pstmt.executeUpdate();

        System.out.println("Delivery added successfully.");

        // Close the resources
        pstmt.close();
        conn.close();
    }
}
