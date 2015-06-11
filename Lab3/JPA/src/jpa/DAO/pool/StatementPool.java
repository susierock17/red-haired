/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.DAO.pool;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kira
 */
public class StatementPool {
    private static Statement statement = null;
    
    private StatementPool(){};
    
    public static Statement getStatement()
    {
        if (statement == null)
        {
            Connection connection = ConnectionPool.getConnection();
            try {
                statement = connection.createStatement();
            } catch (SQLException ex) {
                Logger.getLogger(StatementPool.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return statement;
    }
    
    public static void closeStatement()
    {
        try {
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(StatementPool.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnectionPool.closeConnection();
    }
}
