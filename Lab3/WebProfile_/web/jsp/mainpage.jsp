<%-- 
    Document   : mainpage
    Created on : May 5, 2015, 6:09:19 PM
    Author     : Kira
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Studio Profiler</title>
        <link rel="stylesheet" type="text/css" href="jsp/css/button.css">
        <link rel="stylesheet" type="text/css" href="jsp/css/input.css">
        <link rel="stylesheet" type="text/css" href="jsp/css/text.css">
        <link rel="stylesheet" type="text/css" href="jsp/css/background.css">
        
    </head>
    <body>
        <center>
            <div class="header" align="center">ПОРТФОЛИО СТУДИИ ОЗВУЧИВАНИЯ</div>
        <form name="actionForm" action="controller" method="POST">
            <button class="enjoy-css" type="submit" name="command" value="toAll">Перейти к списку</button><br/>
            <button class="enjoy-css" type="submit" name="command" value="previous" >Назад</button>
            <button class="enjoy-css" type="submit" name="command" value="add"/>Добавить</button>
            <button class="enjoy-css" type="submit" name="command" value="remove"/>Удалить</button>
            <button class="enjoy-css" type="submit" name="command" value="edit"/>Редактировать</button>
            <button class="enjoy-css" type="submit" name="command" value="next">Далее</button>
        </form>
            <hr>
            <div >
                <div class="header">${currentValue.projectName}</div>
            <table class="gradient-pattern-dotted">
                <tr>
                    <td class="love-hate" align='right'>Жанр:</td><td class="info-text">${currentValue.genreId}</td>
                </tr>
                <tr>
                    <td class="love-hate" align='right'>Звукорежисер:</td><td class="info-text">${currentValue.soundmanId}</td>
                </tr>
                <tr>
                    <td class="love-hate" align='right'>Роли озвучивали:</td><td class="info-text">${currentValue.castingId}</td>
                </tr>
                <tr>
                    <td class="love-hate" align='right'>Год:</td><td class="info-text">${currentValue.publishYear}</td>
                </tr>
                <tr>
                    <td class="love-hate" align='right'>Описание:</td><td class="info-text">${currentValue.description}</td>
                </tr>
            </table>
            </div>
                <hr>
        </center>
    </body>
</html>
