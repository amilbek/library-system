package com.company.data;

import com.company.data.interfaces.IDB;

import java.sql.*;

public class PostgresDB implements IDB {
    @Override
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        String connectionUrl = "jdbc:postgresql://localhost:5432/libraries";
        try {
            //Loading the driver and the driver automatically register itself with JDBC
            Class.forName("org.postgresql.Driver");
            //Establish the Connection
            Connection con = DriverManager.getConnection(connectionUrl, "postgres", "nur131102");
            return con;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
