<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/global.css" rel="stylesheet" type="text/css"/>
        <link href="css/cuisine.css" rel="stylesheet" type="text/css"/>
        <link href="css/menu.css" rel="stylesheet" type="text/css"/>

        <title>Interface cuisine</title>
    </head>
    <body>
        <form>
            <input type="button" class="CuisineInactif" id="btnTest" onclick="test()" value="test"/>
        </form>

        <h1>Hello Cuisine!</h1>
        <table>
            <c:forEach items="${listeCuisine}" var="l">

                <c:set var="idProduit" value="l.produit.id"/>
                <c:set var="etat" value="l.etat"/>
                <tr>
                    <td>${l.produit}</td>
                    <td>${l.preferences}</td>
                    <td><input type="hidden" name="idProduit" value="${l.produit.id}" /></td>
                    <td><input type="button" class="CuisineInactif" id="btnPreparation${l.produit.id%2}" onclick="preparation(${l.produit.id%2});
                            changerEtat(${l.produit.id},${l.produit.id%2});
                            return false;" value="Préparer"/></td>
                    <td><input type="button" class="CuisineInactif" id="btnPret${l.produit.id%2}" onclick="pret(${l.produit.id%2})" value="Prêt"/></td>
                    <td><input type="button" class="CuisineIndispo" id="btnIndispo" onclick="indispo()" value="X"/></td>
                    <td>${l.etat}</td>
                </tr>
            </c:forEach>
            <%--
            <c:forEach items="${listeCuisine}" var="l">
                <tr>
                    <td>${l.produit.nom}</td>
                    <td><input type="button" class="CuisineInactif" id="btnPreparation" onclick="preparation()" value="Préparer"/></td>
                    <td><input type="button" class="CuisineInactif" id="btnPret" onclick="pret()" value="Prêt"/></td>
                    <td><input type="button" class="CuisineIndispo" id="btnIndispo" onclick="indispo()" value="X"/></td>
                    <td>${l.etat}</td>
                </tr>
            </c:forEach>
            --%>
        </table>
        </br>
        <a href="Controller?section=login.acka">Home</a> | 
        <a href="Controller?section=login.acka&action=deco">Déconnexion</a>
        </br>
        <script src="js/cuisine.js" type="text/javascript"></script>

    </body>

    <%-- CODE BRUT DE BASE (LISTE QUI FONCTIONNE)
    <body>

        <h1>Hello Cuisine!</h1>

        <c:forEach items="${listeCuisine}" var="l">
            ${l.produit.nom}</br>

        </c:forEach>

        </br>
        <a href="Controller?section=login.acka">Home</a> | 
        <a href="Controller?section=login.acka&action=deco">Déconnexion</a>
        </br>

    </body> --%>
</html>
