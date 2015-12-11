<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/global.css" rel="stylesheet" type="text/css"/>
        <link href="css/menu.css" rel="stylesheet" type="text/css"/>
    <div id="menuSession">
        <c:url value="WEB-INF/jsp/sub/menuSession.jsp" var="urlm01"/>
        <c:import url="${urlm01}"/>
    </div>
        <c:url value="Controller?section=cuisine.acka" var="urlc"/>
        <c:redirect url="${urlc}"/>
    <title>Interface cuisine</title>
</head>
<body>

    <h1>Hello Cuisine!</h1>
    
    
    <div id="menuCuisine">
        <c:url value="Controller?section=menuCuisine.acka&action=afficher" var="urlc"/>
        <c:import url="${urlc}"/>
    </div>
    --%>
    
    
    <c:forEach items="${listeCuisine}" var="l">
        ${l.produit}</br>
        
    </c:forEach>

    <a href="Controller?section=login.acka">Home</a> | 
    <a href="Controller?section=login.acka&action=deco">Déconnexion</a>
    </br>


</body>
</html>
