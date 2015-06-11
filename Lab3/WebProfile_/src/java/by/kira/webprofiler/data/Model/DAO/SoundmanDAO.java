/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.kira.webprofiler.data.Model.DAO;

import by.kira.webprofiler.data.Model.Entity.Soundman;
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
public class SoundmanDAO {
    private static final ConnectionPool cp = ConnectionPool.initConnection();
    private static Connection connection;
    
    private static final String findAllSoundman = "SELECT * FROM soundman";
    private static final String findSoundmanById = "SELECT * FROM soundman WHERE id_soundman = %d";
    private static final String findSoundmanByName = "SELECT * FROM soundman WHERE soundman_name = %s";
    private static final String removeSoundmanById = "DELET FROM soundman WHERE id_soundman = %d";

    private SoundmanDAO(){}

    public static List<Soundman> findAll()
    {
        try {
            connection = cp.getConnection();
            Statement s = connection.createStatement(); 
            ResultSet rs = s.executeQuery(findAllSoundman);
            if (rs.first())
            {
                List<Soundman> result = new ArrayList<>();
                do{
                    Soundman g = ResultSetConverter.toSoundman(rs);
                    result.add(g);
                }while(rs.next());
                return result;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(SoundmanDAO.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public static Soundman findEntityById(int id)
    {
         try {
            connection = cp.getConnection();
            Statement s = connection.createStatement(); 
            ResultSet rs = s.executeQuery(String.format(findSoundmanById, id));
            if (rs.first())
            {
                Soundman result = ResultSetConverter.toSoundman(rs);
                return result;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SoundmanDAO.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public static Soundman findEntityByName(String name)
    {
         try {
            connection = cp.getConnection();
            Statement s = connection.createStatement(); 
            ResultSet rs = s.executeQuery(String.format(findSoundmanByName, name));
            if (rs.first())
            {
                Soundman result = ResultSetConverter.toSoundman(rs);
                return result;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SoundmanDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            s.execute(String.format(removeSoundmanById, id));
        } catch (SQLException ex) {
            Logger.getLogger(SoundmanDAO.class.getName()).log(Level.SEVERE, null, ex);
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
