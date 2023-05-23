package com.dmt.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
	public Connection cn;
	public void Connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Da xac dinh");
            String url = "jdbc:mysql://localhost:3306/QuanLyCongViec";
            String username = "root";
            String password = "quang10217";
            cn = DriverManager.getConnection(url, username, password);
            System.out.println("Da ket noi");
            
            // Tiếp tục thực hiện các thao tác với cơ sở dữ liệu MySQL ở đây
            
        } catch (ClassNotFoundException e) {
            System.out.println("Khong tim thay driver");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Ket noi khong thanh cong");
            e.printStackTrace();
        } finally {
            
        }
    }
}
