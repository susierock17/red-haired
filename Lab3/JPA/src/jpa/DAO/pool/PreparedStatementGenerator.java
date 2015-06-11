/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.DAO.pool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kira
 */
public class PreparedStatementGenerator {
    
    private PreparedStatementGenerator(){};
    
    public static PreparedStatement getStatement(String sqlRequest)
    {
        Connection connection = ConnectionPool.getConnection();
        try {
            return connection.prepareStatement(sqlRequest);
        } catch (SQLException ex) {
            Logger.getLogger(PreparedStatementGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
}
