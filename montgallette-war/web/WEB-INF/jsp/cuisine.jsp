<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/menu.css" rel="stylesheet" type="text/css"/>
    <div id="menuSession">
        <c:url value="WEB-INF/jsp/sub/menuSession.jsp" var="urlm01"/>
        <c:import url="${urlm01}"/>
    </div>
    <title>Interface cuisine</title>
</head>
<body>
    <h1>Hello Cuisine!</h1>
    
    <%--    EN COURS
    <div id="menuCuisine">
        <c:url value="Controller?section=menuCuisine.acka&action=afficher" var="urlm03"/>
        <c:import url="${}"/>
    </div>
    --%>

    <a href="Controller?section=login.acka">Home</a> | 
    <a href="Controller?section=login.acka&action=deco">Déconnexion</a>
</body>
</html>
