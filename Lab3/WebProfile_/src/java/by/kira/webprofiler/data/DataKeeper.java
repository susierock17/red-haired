/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.kira.webprofiler.data;


import by.kira.webprofiler.data.Model.DAO.ProjectDAO;
import by.kira.webprofiler.data.Model.Entity.*;
import by.kira.webprofiler.data.Model.Entity.converter.MapConverter;
import java.util.List;
import java.util.Map;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
/**
 *
 * @author Kira
 */
public class DataKeeper {
    
    private static DataKeeper singletone = null;
    
    private Project currentProject;
    private int currentProjectNumber = 0;
    public Project getCurrentProject()
    {
        getCurrentProjectFromDB();
        return currentProject;
    }
    
    
    public static DataKeeper getInstance()
    {
        if (singletone == null)
            singletone = new DataKeeper();
        return singletone;
    }
    private DataKeeper(){
            getCurrentProjectFromDB();
       
    };
    
    public void addNewProject(Map<String, String[]> map)
    {
         addNewProject(MapConverter.toProject(map));
    }
    public void addNewProject(Project newProject)
    {
        currentProject.setProjectName(newProject.getProjectName());
        currentProject.setDescription(newProject.getDescription());
        currentProject.setPublishYear(newProject.getPublishYear());
        
        currentProject.setCastingId(newProject.getCastingId());
        currentProject.setGenreId(newProject.getGenreId());
        currentProject.setSoundmanId(newProject.getSoundmanId());
        
        ProjectDAO.create(currentProject);
        
    }
    
    public void editCurrentProject(Map<String, String[]> map)
    {
        editCurrentProject(MapConverter.toProject(map));
    }
    public void editCurrentProject(Project editedProject)
    {
        currentProject.setProjectName(editedProject.getProjectName());
        currentProject.setDescription(editedProject.getDescription());
        currentProject.setPublishYear(editedProject.getPublishYear());
        
        currentProject.setCastingId(editedProject.getCastingId());
        currentProject.setGenreId(editedProject.getGenreId());
        currentProject.setSoundmanId(editedProject.getSoundmanId());
        
        ProjectDAO.edit(currentProject);
    }
    
    public void removeCurrentProject()
    {
        if (getProjectCount() > 0)
        ProjectDAO.removeEntityById(currentProject.getIdProject());
    }
   
    private int getProjectCount()
    {
        return ProjectDAO.getProjectCount();
    }
    
    private void getCurrentProjectFromDB()
    {
        
        List<Project> projects = ProjectDAO.findAll();
        if (projects != null)
        currentProject = projects.get(currentProjectNumber); 
    }
    
    private void checkCurrentIndex()
    {
        if (currentProjectNumber < 0)
            currentProjectNumber = getProjectCount() - 1;
        else if (currentProjectNumber >= getProjectCount())
            currentProjectNumber = 0;
    }
    public void moveToLast()
    {
        currentProjectNumber = getProjectCount() - 1;
        getCurrentProjectFromDB(); 
    }
    
    public boolean isEmpty()
    {
        return getProjectCount() <= 0;
    }
    
    public void moveNext()
    {
        currentProjectNumber++;
        checkCurrentIndex();
        getCurrentProjectFromDB();
    }
    
    public void  movePrevious()
    {
        currentProjectNumber--;
        checkCurrentIndex();
        getCurrentProjectFromDB();
    }
    
    public List<Project> getAllProject()
    {
        return ProjectDAO.findAll();
    }
    
    public void setCurrent(int id)
    {
        currentProjectNumber = id;
    }
    
}
