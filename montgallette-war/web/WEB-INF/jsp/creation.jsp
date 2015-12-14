<%-- 
    Document   : creation
    Created on : 14 déc. 2015, 15:23:01
    Author     : cdi406
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

        <link href="css/global.css" rel="stylesheet" type="text/css" />
        
        <form action="Controller" method="post">
        Nombre de couverts: <input type="text" name="couverts"/>
        <input type="hidden" name="section" value="commande.acka"/>
        <input type="hidden" name="action" value="creerCo"/>
        <a href="Controller?section=commande.acka&action=creerCo"><input type="submit" name="doIt" value="Valider"></a>
        </form>
 