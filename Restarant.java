package com.mysql.FoodDelivery;

import java.sql.*;
import java.util.Scanner;

public class Restarant {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
    	
    	String url="jdbc:mysql://localhost:3306/praveen";
    	String un="root";
    	String pw="Praveen@123";
    	String sql = "INSERT INTO Restaurant (name, address, phone) VALUES (?, ?, ?)";
        
        Class.forName("com.mysql.cj.jdbc.Driver");

        
        Connection conn = DriverManager.getConnection(url,un,pw);
        PreparedStatement pstmt = conn.prepareStatement(sql);

        
        Scanner scanner = new Scanner(System.in);

       
        System.out.println("Enter restaurant name:");
        String name = scanner.nextLine();
        pstmt.setString(1, name);
        
        System.out.println("Enter restaurant address:");
        String address = scanner.nextLine();
        pstmt.setString(2, address);
        
        System.out.println("Enter restaurant phone:");
        String phone = scanner.nextLine();
        pstmt.setString(3, phone);
        
       
        pstmt.executeUpdate();

        System.out.println("Restaurant added successfully.");

       
        pstmt.close();
        conn.close();
    }
}
