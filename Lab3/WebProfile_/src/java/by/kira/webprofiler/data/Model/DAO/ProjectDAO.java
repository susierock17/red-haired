/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.kira.webprofiler.data.Model.DAO;

import by.kira.webprofiler.data.Model.Entity.Project;
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
public class ProjectDAO {
    private static final ConnectionPool cp = ConnectionPool.initConnection();
    private static Connection connection;
    
    private static final String findAllProject = "SELECT * FROM project";
    private static final String findProjectById = "SELECT * FROM project WHERE id_project = %d";
    private static final String findProjectByName = "SELECT * FROM project WHERE project_name = %s";
    private static final String removeProjectById = "DELETE FROM project WHERE id_project = %d";
    private static final String createProject = "INSERT INTO university.project (project_name, description, publish_year, genre_id, soundman_id, casting_id) VALUES ('%s', '%s', '%s', %d, %d, %d)";
    private static final String updateProject = "UPDATE university.project SET project_name = '%s', description = '%s', publish_year = '%s', genre_id = %d, soundman_id = %d, casting_id = %d WHERE id_project = %d";
    private static final String getCount = "SELECT COUNT(*) FROM project ";

    private ProjectDAO(){}

    public static List<Project> findAll()
    {
        try {
            connection = cp.getConnection();
            Statement s = connection.createStatement(); 
            ResultSet rs = s.executeQuery(findAllProject);
            if (rs.first())
            {
                List<Project> result = new ArrayList<>();
                do{
                    Project g = ResultSetConverter.toProject(rs);
                    result.add(g);
                }while(rs.next());
                return result;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ProjectDAO.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public static Project findEntityById(int id)
    {
         try {
            connection = cp.getConnection();
            Statement s = connection.createStatement(); 
            ResultSet rs = s.executeQuery(String.format(findProjectById, id));
            if (rs.first())
            {
                Project result = ResultSetConverter.toProject(rs);
                return result;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProjectDAO.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public static Project findEntityByName(String name)
    {
         try {
            connection = cp.getConnection();
            Statement s = connection.createStatement(); 
            ResultSet rs = s.executeQuery(String.format(findProjectByName, name));
            if (rs.first())
            {
                Project result = ResultSetConverter.toProject(rs);
                return result;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProjectDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            s.executeUpdate(String.format(removeProjectById, id));
        } catch (SQLException ex) {
            Logger.getLogger(ProjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         finally{
             try {
                 connection.close();
             } catch (SQLException ex) {
                 Logger.getLogger(ProjectDAO.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
    }
    
    public static void create(Project p)
    {
         try {
            connection = cp.getConnection();
            Statement s = connection.createStatement(); 
            s.executeUpdate(String.format(createProject, p.getProjectName(), p.getDescription(), p.getPublishYear(), p.getGenreId().getIdGenre(), p.getSoundmanId().getIdSoundman(), p.getCastingId().getIdCasting()));
        } catch (SQLException ex) {
            Logger.getLogger(ProjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         finally{
             try {
                 connection.close();
             } catch (SQLException ex) {
                 Logger.getLogger(ProjectDAO.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
    }
    
    public static void edit(Project p)
    {
         try {
            connection = cp.getConnection();
            Statement s = connection.createStatement(); 
            s.executeUpdate(String.format(updateProject, p.getProjectName(), p.getDescription(), p.getPublishYear(), p.getGenreId().getIdGenre(), p.getSoundmanId().getIdSoundman(), p.getCastingId().getIdCasting(), p.getIdProject()));
        } catch (SQLException ex) {
            Logger.getLogger(ProjectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         finally{
             try {
                 connection.close();
             } catch (SQLException ex) {
                 Logger.getLogger(ProjectDAO.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
    }
    
    public static int getProjectCount()
    {
        List<Project> projects = findAll();
        return projects.size();
    }
    
    
}
