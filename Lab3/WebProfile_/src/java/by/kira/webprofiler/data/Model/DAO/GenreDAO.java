/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.kira.webprofiler.data.Model.DAO;

import by.kira.webprofiler.data.Model.Entity.Genre;
import by.kira.webprofiler.data.Model.Entity.converter.MapConverter;
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
public class GenreDAO {
    private static final ConnectionPool cp = ConnectionPool.initConnection();
    private static Connection connection;
    
    private static final String findAllGenre = "SELECT * FROM genre";
    private static final String findGenreById = "SELECT * FROM genre WHERE id_genre = %d";
    private static final String findGenreByName = "SELECT * FROM genre WHERE genre_name = %s";
    private static final String removeGenreById = "DELET FROM genre WHERE id_genre = %d";

    private GenreDAO(){}

    public static List<Genre> findAll()
    {
        try {
            connection = cp.getConnection();
            Statement s = connection.createStatement(); 
            ResultSet rs = s.executeQuery(findAllGenre);
            if (rs.first())
            {
                List<Genre> result = new ArrayList<>();
                do{
                    Genre g = ResultSetConverter.toGenre(rs);
                    result.add(g);
                }while(rs.next());
                return result;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(GenreDAO.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public static Genre findEntityById(int id)
    {
         try {
            connection = cp.getConnection();
            Statement s = connection.createStatement(); 
            ResultSet rs = s.executeQuery(String.format(findGenreById, id));
            if (rs.first())
            {
                Genre result = ResultSetConverter.toGenre(rs);
                return result;
            }
        } catch (SQLException ex) {
            Logger.getLogger(GenreDAO.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public static Genre findEntityByName(String name)
    {
         try {
            connection = cp.getConnection();
            Statement s = connection.createStatement(); 
            ResultSet rs = s.executeQuery(String.format(findGenreByName, name));
            if (rs.first())
            {
                Genre result = ResultSetConverter.toGenre(rs);
                return result;
            }
        } catch (SQLException ex) {
            Logger.getLogger(GenreDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            s.execute(String.format(removeGenreById, id));
        } catch (SQLException ex) {
            Logger.getLogger(GenreDAO.class.getName()).log(Level.SEVERE, null, ex);
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
