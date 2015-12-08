

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mode: Client</title>
    </head>
    <body>
        <div id="menu">
            <c:url value="/WEB-INF/jsp/menu.jsp" var="urlc01"/>
            <c:import url="${urlc01}"/>
        </div>
        <div id="commande">
            <c:url value="/WEB-INF/jsp/commande.jsp" var="urlc02"/>
            <c:import url="${urlc02}"/>
        </div>




    </body>
</html>
