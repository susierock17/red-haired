<%-- 
    Document   : error
    Created on : Apr 8, 2015, 9:01:14 PM
    Author     : Kira
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ERROR</title>
    </head>
    <body>
    <center>
        <h1>I don't know what a f@ck is this!</h1>
        Request from ${pageContext.errorData.requestURI} is failed  <br/> 
        Servlet name or type: ${pageContext.errorData.servletName}  <br/> 
        Status code: ${pageContext.errorData.statusCode}  <br/> 
        Exception: ${pageContext.errorData.throwable} 
    </center>
    </body>
</html>
