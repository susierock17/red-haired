/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.kira.webprofiler.command.client;

import by.kira.webprofiler.command.*;
import java.util.HashMap;

/**
 *
 * @author Kira
 */
public class CommandFactory {
    
    private static final HashMap<String, ActionCommand> actions;
    static{
        actions = new HashMap<>();
        actions.put("ADD", new AddCommand());
        actions.put("EDIT", new EditCommand());
        actions.put("REMOVE", new RemoveCommand());
        actions.put("TEST", new TestCommand());
        actions.put("NEXT", new NextCommand());
        actions.put("PREVIOUS", new PreviousCommand());
        actions.put("ADDNEWVALUE", new AddNewValueCommand());
        actions.put("SAVEEDITED", new SaveEditedCommand());
        actions.put("TOMAINPAGE", new ToMainPageCommand());
        actions.put("TOALL", new ToAllCommand());
        actions.put("TOPROJECT", new ToProjectCommand());
    }

    private CommandFactory() {
    }
    
    public static ActionCommand getCommand(String command)
    {
        return actions.get(command);
    }
    
    
}
