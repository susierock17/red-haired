/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.kira.webprofiler.command;

import by.kira.webprofiler.data.Model.DAO.CastingDAO;
import by.kira.webprofiler.data.Model.DAO.GenreDAO;
import by.kira.webprofiler.data.Model.DAO.SoundmanDAO;
import by.kira.webprofiler.data.Model.Entity.Project;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Kira
 */
public class AddCommand implements ActionCommand{

    @Override
    public String execute(HttpServletRequest request) {
        try {
            //throw new UnsupportedOperationException("AddCommand:Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(AddCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("textValue", new Project());
        request.setAttribute("action", "addNewValue");
        request.setAttribute("genreList", GenreDAO.findAll());
        request.setAttribute("soundmanList", SoundmanDAO.findAll());
        request.setAttribute("castingList", CastingDAO.findAll());
        return "/jsp/updatePage.jsp";
    }
    
}
