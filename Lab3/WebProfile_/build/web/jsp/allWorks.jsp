<%-- 
    Document   : mainpage
    Created on : May 5, 2015, 6:09:19 PM
    Author     : Kira
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="ctg" uri="customtags" %>,
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
            <hr>
            <div >
                
                <table class="gradient-pattern-dotted-list">
                    <th >
                    <td class="love-hate-2"><ctg:bold>Имя</ctg:bold></td>
                    <td class="love-hate-2"><ctg:bold>Жанр</ctg:bold></td>
                    <td class="love-hate-2"><ctg:bold>Звукорежиссер</ctg:bold></td>
                    <td class="love-hate-2"><ctg:bold>Роли озвучивали</ctg:bold></td>
                    <td class="love-hate-2"><ctg:bold>Год</ctg:bold></td>
                    <td class="love-hate-2"><ctg:bold>Описание</ctg:bold></td>
                    </th>
                    <c:forEach varStatus="status" var="item" items="${projects}"  >
                        <form name="actionForm${status.count}" action="controller" method="POST">
                        <tr class="">
                            <td></td>
                            <td><button class="enjoy-css-small" name="command" value="TOPROJECT">${item.projectName}</button></td>
                            <td>${item.genreId}</td>
                            <td>${item.soundmanId}</td>
                            <td>${item.castingId}</td>
                            <td>${item.publishYear}</td>
                            <td>${item.description}</td>
                            <input type="hidden" name="goTo" value="${status.count - 1}"/>
                        </tr>
                        </form>
                    </c:forEach>
                </table>
                
                <!--
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
            </div>-->
                <hr >
        </center>
    </body>
</html>
