<%-- 
    Document   : newjspgarcon
    Created on : 2 déc. 2015, 13:53:02
    Author     : cdi406
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Garçon</title>
    </head>
    <body>
        <h1>Bienvenue ${user.prenom} ${user.nom}</h1>
        <a href="Controller?section=login.acka">Home</a> | 
        <a href="Controller?section=login.acka&action=client">Mode Client</a> | 
        <a href="Controller?section=login.acka&action=deco">Déconnexion</a>
        <hr>
        </br>
        Commande:
        </br>
        <c:import url="/WEB-INF/jsp/commande.jsp"/>
        </br>
        <hr>
        Menu:
        </br>
        <c:import url="/WEB-INF/jsp/menu.jsp"/>
    </body>
</html>
