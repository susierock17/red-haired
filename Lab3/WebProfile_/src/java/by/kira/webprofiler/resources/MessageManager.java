/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.kira.webprofiler.resources;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author Kira
 */
public class MessageManager {
    
    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle("resources.messages", Locale.ROOT);
    
    private MessageManager(){}
    public static String getProperty(String key)
    {
        return resourceBundle.getString(key);
    }
}
