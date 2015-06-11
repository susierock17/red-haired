/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.kira.webprofiler.data.Model.DAO;

import by.kira.webprofiler.data.Model.Entity.Casting;
import by.kira.webprofiler.data.Model.Entity.converter.ResultSetConverter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kira
 */
public class CastingDAO {
    private static final ConnectionPool cp = ConnectionPool.initConnection();
    private static Connection connection;
    
    private static final String findAllCasting = "SELECT * FROM casting";
    private static final String findCastingById = "SELECT * FROM casting WHERE id_casting = %d";
    private static final String findCastingByActorList = "SELECT * FROM casting WHERE actor_list = %s";
    private static final String removeCastingById = "DELET FROM casting WHERE id_casting = %d";

    private CastingDAO(){}

    public static List<Casting> findAll()
    {
        try {
            connection = cp.getConnection();
            Statement s = connection.createStatement(); 
            ResultSet rs = s.executeQuery(findAllCasting);
            if (rs.first())
            {
                List<Casting> result = new ArrayList<>();
                do{
                    Casting g = ResultSetConverter.toCasting(rs);
                    result.add(g);
                }while(rs.next());
                return result;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CastingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
             try {
                 connection.close();
             } catch (SQLException ex) {
                 Logger.getLogger(ProjectDAO.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
        return null;
    }
    
    public static Casting findEntityById(int id)
    {
         try {
            connection = cp.getConnection();
            Statement s = connection.createStatement(); 
            ResultSet rs = s.executeQuery(String.format(findCastingById, id));
            if (rs.first())
            {
                Casting result = ResultSetConverter.toCasting(rs);
                return result;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CastingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         finally{
             try {
                 connection.close();
             } catch (SQLException ex) {
                 Logger.getLogger(ProjectDAO.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
        return null;
    }
    
    public static Casting findEntityByName(String name)
    {
         try {
            connection = cp.getConnection();
            Statement s = connection.createStatement(); 
            ResultSet rs = s.executeQuery(String.format(findCastingByActorList, name));
            if (rs.first())
            {
                Casting result = ResultSetConverter.toCasting(rs);
                return result;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CastingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         finally{
             try {
                 connection.close();
             } catch (SQLException ex) {
                 Logger.getLogger(ProjectDAO.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
        return null;
    }
    
    public static void removeEntityById(int id)
    {
         try {
            connection = cp.getConnection();
            Statement s = connection.createStatement(); 
            s.execute(String.format(removeCastingById, id));
        } catch (SQLException ex) {
            Logger.getLogger(CastingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         finally{
             try {
                 connection.close();
             } catch (SQLException ex) {
                 Logger.getLogger(ProjectDAO.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
    }
}
