<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/global.css" rel="stylesheet" type="text/css"/>
        <link href="css/menu.css" rel="stylesheet" type="text/css"/>
    
    <title>Interface cuisine</title>
</head>
<body>

    <h1>Hello Cuisine!</h1>
   
    <c:forEach items="${listeCuisine}" var="l">
        ${l.produit.nom}</br>
        
    </c:forEach>

    <a href="Controller?section=login.acka">Home</a> | 
    <a href="Controller?section=login.acka&action=deco">Déconnexion</a>
    </br>


</body>
</html>
