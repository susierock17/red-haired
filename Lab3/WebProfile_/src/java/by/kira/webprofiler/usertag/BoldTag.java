/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.kira.webprofiler.usertag;

import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException; 
import java.util.GregorianCalendar; 
import java.util.Locale; 
import javax.servlet.jsp.JspException;import javax.servlet.jsp.JspTagException;
 import javax.servlet.jsp.JspWriter;

/**
 *
 * @author Kira
 */
public class BoldTag extends TagSupport{
    @Override 
    public int doStartTag() throws JspException {
        try {     
            JspWriter out = pageContext.getOut();   
            out.write("<b><u>");  
        } catch (IOException e) {
            throw new JspException(e.getMessage());    
        }  
        return EVAL_BODY_INCLUDE; 
    }
    
    @Override 
    public int doAfterBody() throws JspTagException {  
            return SKIP_BODY;   
    }
    
    @Override
    public int doEndTag() throws JspException { 
         try {     
            JspWriter out = pageContext.getOut();   
            out.write("</u></b>");  
        } catch (IOException e) {
            throw new JspException(e.getMessage());    
        }  
        return EVAL_PAGE; 
    }
}
