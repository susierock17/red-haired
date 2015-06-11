/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.kira.webprofiler.command;

import by.kira.webprofiler.data.DataKeeper;
import by.kira.webprofiler.data.Model.DAO.CastingDAO;
import by.kira.webprofiler.data.Model.DAO.GenreDAO;
import by.kira.webprofiler.data.Model.DAO.ProjectDAO;
import by.kira.webprofiler.data.Model.DAO.SoundmanDAO;
import by.kira.webprofiler.data.Model.Entity.Genre;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Kira
 */
//I do nothing for a while. Test purposes only
public class TestCommand implements ActionCommand{

    @Override
    public String execute(HttpServletRequest request) {
        
        DataKeeper dataKeeper = DataKeeper.getInstance();
        request.setAttribute("testList", ProjectDAO.findAll());
        
        //I do nothing for a while. Test purposes only
        
        //request.setAttribute("currentValue", dataKeeper.getCurrentElement());
        return "/jsp/mainpage.jsp";
    }
    
}
