package org.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static  final String HOST = "127.0.0.1";
    private static  final int PORT = 3306;
    private static final String DB_NAME =  "jdbc_course_db";
    private static final String NAME =  "root";
    private static final String PASSWORD =  "";



    public static Connection  getConnection() {
        Connection connection = null;
        try {
            String stringFormate = String.format("jdbc:mysql://%s:%d/%s",HOST,PORT,DB_NAME);
            connection = DriverManager.getConnection( stringFormate,NAME,PASSWORD);
        }
        catch (SQLException se) {
            se.printStackTrace();
        }

        return  connection;
    }

}
