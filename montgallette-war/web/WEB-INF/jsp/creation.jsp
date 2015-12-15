<%-- 
    Document   : creation
    Created on : 14 déc. 2015, 15:23:01
    Author     : cdi406
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

        <link href="css/global.css" rel="stylesheet" type="text/css" />
        
        <form action="Controller" method="post">
            Nombre de couverts: <input type="text" name="couverts" size="3" maxlength="3"/>
        <input type="hidden" name="section" value="commande.acka"/>
        <input type="hidden" name="action" value="creerCo"/>
        <input type="hidden" name="table" value="${table}"/>

        <a href="Controller?section=commande.acka&action=creerCo"><input type="submit" name="doIt" value="Valider" ></a>

        </form>
        
        <script src="js/tables.js" type="text/javascript"></script>