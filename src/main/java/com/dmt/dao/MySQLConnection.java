package com.dmt.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {

    private static final String hostName = "bv2rebwf6zzsv341.cbetxkdyhwsb.us-east-1.rds.amazonaws.com";
    private static final String dbName = "m4e4yllj64as94sg";
    private static final String userName = "v3x53lleunm45i2m";
    private static final String password = "c50x1ftvbo1u3gxb";

    public static Connection getMySQLConnection() {
        return getMySQLConnection(hostName, dbName, userName, password);
    }

    public static Connection getMySQLConnection(String hostName, String dbName,
                                                String userName, String password) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName + "?autoReconnect=true&useUnicode=true&characterEncoding=utf-8&useSSL=false";

            Connection conn = DriverManager.getConnection(connectionURL, userName,
                    password);
            return conn;
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }

        return null;

    }

    public static void main(String[] args) {
        System.out.println(getMySQLConnection());
    }
}
