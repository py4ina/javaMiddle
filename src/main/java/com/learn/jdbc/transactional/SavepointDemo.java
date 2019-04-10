package com.learn.jdbc.transactional;

import java.sql.*;
import java.text.SimpleDateFormat;

public class SavepointDemo {
    /**
     * JDBC Driver and database url
     */
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DATABASE_URL = "jdbc:mysql://localhost/tutorials";

    /**
     * User and Password
     */
    static final String USER = "root";
    static final String PASSWORD = "Reper245!";

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
    static String insertTableSQL = "INSERT INTO DBUSER (USER_ID, USERNAME, CREATED_BY, CREATED_DATE) VALUES (?,?,?,?)";

    static String updateTableSQL = "UPDATE DBUSER SET USERNAME =? WHERE USER_ID = ?";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        PreparedStatement preparedStatementInsert = null;
        PreparedStatement preparedStatementUpdate = null;

        Class.forName(JDBC_DRIVER);
        Connection dbConnection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);

        try {
            dbConnection.setAutoCommit(false);

            preparedStatementInsert = dbConnection.prepareStatement(insertTableSQL);
            preparedStatementInsert.setInt(1, 999);
            preparedStatementInsert.setString(2, "mkyong101");
            preparedStatementInsert.setString(3, "system");
            preparedStatementInsert.setTimestamp(4, timestamp);
            preparedStatementInsert.executeUpdate();

            preparedStatementUpdate = dbConnection.prepareStatement(updateTableSQL);
            // preparedStatementUpdate.setString(1,
            // "A very very long string caused db error");
            preparedStatementUpdate.setString(1, "new string");
            preparedStatementUpdate.setInt(2, 999);
            preparedStatementUpdate.executeUpdate();

            dbConnection.commit();

            System.out.println("Done!");

        } catch (SQLException e) {

            System.out.println(e.getMessage());
            dbConnection.rollback();

        } finally {

            if (preparedStatementInsert != null) {
                preparedStatementInsert.close();
            }

            if (preparedStatementUpdate != null) {
                preparedStatementUpdate.close();
            }

            if (dbConnection != null) {
                dbConnection.close();
            }

        }
    }
}