
package com.mysql.FoodDelivery;

import java.sql.*;
import java.util.Scanner;

public class Order {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        
        String url = "jdbc:mysql://localhost:3306/praveen";
        String un = "root";
        String pw = "Praveen@123";
        String sql = "INSERT INTO `Order1` (customer_id, restaurant_id, order_date, status) VALUES (?, ?, ?, ?)";

        
        Class.forName("com.mysql.cj.jdbc.Driver");

        
        Connection conn = DriverManager.getConnection(url, un, pw);
        PreparedStatement pstmt = conn.prepareStatement(sql);

        
        Scanner scanner = new Scanner(System.in);

        
        System.out.println("Enter customer ID:");
        int customerId = scanner.nextInt();
        pstmt.setInt(1, customerId);

        System.out.println("Enter restaurant ID:");
        int restaurantId = scanner.nextInt();
        pstmt.setInt(2, restaurantId);

        System.out.println("Enter order date (YYYY-MM-DD):");
        String orderDate = scanner.next();
        pstmt.setDate(3, Date.valueOf(orderDate));

        scanner.nextLine(); 

        System.out.println("Enter order status:");
        String status = scanner.nextLine();
        pstmt.setString(4, status);

        
        pstmt.executeUpdate();

        System.out.println("Order added successfully.");

        
        pstmt.close();
        conn.close();
    }
}
