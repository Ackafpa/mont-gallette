<%-- 
    Document   : home
    Created on : 2 déc. 2015, 16:21:02
    Author     : cdi406
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/global.css" rel="stylesheet" type="text/css"/>
        <link href="css/cssHome.css" rel="stylesheet" type="text/css"/>
        <link href="css/cssLogin.css" rel="stylesheet" type="text/css"/>
        <title>Home</title>
    </head>
    <body>
        <h1>MONT GALETTE</h1>
        <c:import url="/WEB-INF/jsp/login.jsp" />
        <br>
        <a href="Controller?section=salle.acka&action=jeuTables">Créer jeu tables</a><br>
        <a href="Controller?section=salle.acka&action=jeuEmplacements">Créer jeu Emplacements</a><br>
        <a href="Controller?section=commande.acka&action=creerDonnees">Créer test commande</a>
    </body>
</html>
