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
        <title>Login</title>
    </head>
    <body>
        
        <a href="Controller?section=login.acka&action=test">Créer jeu de test Employés</a> | 
        
        <hr>
        <form action="Controller" method="get">
            Entrez votre code</br>
            <input type="password" name="id" maxlength="4"/>
            <input type="hidden" name="section" value="login.acka"/>
            <input type="hidden" name="action" value="login"/>
            
            </br>
            <a href="Controller?section=login.acka&action=login"><input type="submit" name="login" value="Connexion"/></a>
        </form>   
        <hr>
        <c:if test="${deco}">
            ${msgDeco}${user.prenom} ${user.nom} ?
            <a href="Controller?section=login.acka&action=deco">Déconnexion</a>
        </c:if>
        ${msg}${errCode}
        </br>
        ${prov}
    </body>
</html>
