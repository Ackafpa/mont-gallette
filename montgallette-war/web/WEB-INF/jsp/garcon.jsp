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
        <link href="css/global.css" rel="stylesheet" type="text/css" />
        <link href="css/cssGarcon.css" rel="stylesheet" type="text/css" />
        <title>Garçon</title>
    </head>
    <body>
        <p id="controls">
            <a id="home" href="Controller?section=login.acka">Accueil</a> 
            </br>

            <a id="deco" href="Controller?section=login.acka&action=deco">Déconnexion</a>
        </p>
        </br>
        <div >
            Commande:
            </br>
            <c:url value="/WEB-INF/jsp/commande.jsp" var="urlComm" />
            <a id="commande" href="${urlComm}"><img src=""></a>
            </br>
        </div>
        <div >

            </br>
            <c:url value="/WEB-INF/jsp/menu.jsp" var="urlmenu"/>
            <a id="menu" href="${urlmenu}"><img src="images/menu.png"></a
        </div>

        <p id="button">
            <a id="clientMode" href="Controller?section=login.acka&action=client">Mode Client</a> 
        </p>
    </body>
</html>
