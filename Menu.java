
package com.mysql.FoodDelivery;

import java.sql.*;
import java.util.Scanner;

public class Menu {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        
        String url = "jdbc:mysql://localhost:3306/praveen";
        String un = "root";
        String pw = "Praveen@123";
        String sql = "INSERT INTO Menu (restaurant_id, item_name, price) VALUES (?, ?, ?)";

        
        Class.forName("com.mysql.cj.jdbc.Driver");

        
        Connection conn = DriverManager.getConnection(url, un, pw);
        PreparedStatement pstmt = conn.prepareStatement(sql);

        
        Scanner scanner = new Scanner(System.in);

        
        System.out.println("Enter restaurant ID:");
        int restaurantId = scanner.nextInt();
        pstmt.setInt(1, restaurantId);

        scanner.nextLine(); 

        System.out.println("Enter menu item name:");
        String itemName = scanner.nextLine();
        pstmt.setString(2, itemName);

        System.out.println("Enter item price:");
        double price = scanner.nextDouble();
        pstmt.setDouble(3, price);

  
        pstmt.executeUpdate();

        System.out.println("Menu item added successfully.");

       
        pstmt.close();
        conn.close();
    }
}
