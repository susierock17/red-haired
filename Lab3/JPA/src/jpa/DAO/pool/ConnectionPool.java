/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.DAO.pool;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kira
 */
public class ConnectionPool {
    private static final String DATASOURCE_NAME = "jdbc:mysql://localhost:3306/university";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    
    private static Connection connection = null;
    
    private ConnectionPool(){};
    
    public static Connection getConnection(){
        if (connection == null)
            try {
                connection = DriverManager.getConnection(DATASOURCE_NAME, USER, PASSWORD);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionPool.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }
   
    public static void closeConnection()
    {
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionPool.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
