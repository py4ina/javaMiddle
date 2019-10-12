package com.learn;

import java.sql.*;

public class Main {
    private final static String URL = "jdbc:mysql://10.4.4.8:3306/ukr_pol";
    private final static String USER_NAME = "root";
    private final static String PASSWORD = "UkrPol_123";

    private static final String QUERY = "SELECT * FROM user";

    public static void main(String[] args) {
        System.out.println("Start");

        try (Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
             CallableStatement statement = connection.prepareCall("{call getAllWorkingTerminals}");
             ResultSet resultSet = statement.executeQuery()){

            while (resultSet.next()){
                System.out.println(resultSet.getString("name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Stop");
        }
    }
}