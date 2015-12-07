<%-- 
    Document   : login
    Created on : 1 déc. 2015, 13:54:03
    Author     : cdi406
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/cssLogin.css" rel="stylesheet" type="text/css"/>
        <title>Login</title>
    </head>
    <body>
        <div id="blockLogin">
            <a id="emp" href="Controller?section=login.acka&action=test">Créer jeu de test Employés</a>

            <form action="Controller" method="post">
                <p id="enterCode">Entrez votre code</p>
                <input id="code" type="password" name="id" maxlength="4" size="4"/>
                <input type="hidden" name="section" value="login.acka"/>
                <input type="hidden" name="action" value="login"/>

                </br>
                </br>
                <a id="linkLogin" href="Controller?section=login.acka&action=login"><input id="login" type="submit" name="login" value="Connexion"/></a>
            </form>   

            <c:if test="${deco}">
                ${msgDeco}${user.prenom} ${user.nom} ?
                <a href="Controller?section=login.acka&action=deco">Déconnexion</a>
            </c:if>
                <p id="err">${msg}${errCode}</p>
            </br>
        </div>
    </body>
</html>
