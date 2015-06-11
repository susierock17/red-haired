<%-- 
    Document   : updatePage
    Created on : May 5, 2015, 7:39:44 PM
    Author     : Kira
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
    <head>
        <!--<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">-->
        <meta content="charset=UTF-8">
        <title>${title}</title>
        <link rel="stylesheet" type="text/css" href="jsp/css/button.css">
        <link rel="stylesheet" type="text/css" href="jsp/css/input.css">
        <link rel="stylesheet" type="text/css" href="jsp/css/text.css">
        <link rel="stylesheet" type="text/css" href="jsp/css/background.css">
    </head>
    <body>
    <center >
        <h1 class="header">Введите данные</h1>
        <form name="updateForm" action="controller" method="POST">
            <table class="gradient-pattern-dotted">
                <tr>
                    <td class="love-hate" align='right'>Имя:</td><td align='left'><input class="enjoy-input" type='text' required="required" placeholder="Пример: Spirited Away"  name="name" value='${textValue.projectName}'/><br></td>
                </tr>
                <tr>
                    <td class="love-hate" align='right'>Жанр:</td><td align='left'>
                        <select class="enjoy-input" name="genreSelection">
                            <c:forEach var="item" items="${genreList}">
                                <option value="${item.idGenre}"
                                        <c:if test="${item.idGenre == textValue.genreId.idGenre}">
                                            selected="selected"
                                        </c:if> >${item.genreName}</option>
                            </c:forEach> 
                        </select>
                        <!--<input type='text' name="genre" value='${textValue.genreId}'/><br>-->
                    </td>
                </tr>
                <tr>
                    <td class="love-hate" align='right'>Звукорежисер:</td>
                    <td align='left'>
                        <select class="enjoy-input" name="soundmanSelection">
                            <c:forEach var="item" items="${soundmanList}">
                                <option value="${item.idSoundman}"
                                        <c:if test="${item.idSoundman == textValue.soundmanId.idSoundman}">
                                            selected="selected"
                                        </c:if> >${item.soundmanName}</option>
                            </c:forEach> 
                        </select>
                        <!--<input type='text' name="soundman" value='${textValue.soundmanId}'/><br>-->
                    </td>
                </tr>
                <tr>
                    <td class="love-hate" align='right'>Роли озвучивали:</td>
                    <td align='left'>
                        <select class="enjoy-input" name="castingSelection">
                            <c:forEach var="item" items="${castingList}">
                                <option value="${item.idCasting}" 
                                        <c:if test="${item.idCasting == textValue.castingId.idCasting}">
                                            selected="selected"
                                        </c:if> >${item.actorList}</option>
                            </c:forEach> 
                        </select>
                        <!--<input type='text' name="cast" value='${textValue.castingId}'/><br>-->
                    </td>
                </tr>
                <tr>
                    <td class="love-hate"  align='right'>Год:</td><td align='left'><input class="enjoy-input" placeholder="Пример: 1994" pattern="[0-9]{4,4}" type='text' name="year" value='${textValue.publishYear}'/><br></td>
                </tr>
                <tr>
                    <td class="love-hate"  align='right'>Описание:</td><td align='left'><input class="enjoy-input" type='text' maxlength='128' name='description' value='${textValue.description}'/><br></td>
                </tr>
            
            </table>
                <button  class="enjoy-css" type="submit" name="command" value="${action}">Сохранить</button>
        </form><hr/>
    </center>
    </body>
</html>
