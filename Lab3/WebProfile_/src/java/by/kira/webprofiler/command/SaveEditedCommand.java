/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.kira.webprofiler.command;

import by.kira.webprofiler.data.DataKeeper;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Kira
 */
public class SaveEditedCommand implements ActionCommand{

    @Override
    public String execute(HttpServletRequest request) {
        DataKeeper dataKeeper = DataKeeper.getInstance();
        dataKeeper.editCurrentProject(request.getParameterMap());
        request.setAttribute("currentValue", dataKeeper.getCurrentProject());
        return "/jsp/mainpage.jsp";
    }
    
}
