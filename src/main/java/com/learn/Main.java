package com.learn;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    private final static String URL = "jdbc:mysql://10.4.4.8:3306/ukrpol_print_label";
    private final static String USER_NAME = "root";
    private final static String PASSWORD = "UkrPol_123";

    public static void main(String[] args) {

        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            if (!connection.isClosed()){
                System.out.println("+");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}