
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/global.css" rel="stylesheet" type="text/css"/>
        <link href="css/menu.css" rel="stylesheet" type="text/css"/>
        <title></title>
    </head>
    <body>
        <h1>Votre Commande</h1>
       Message :  ${msg}
       <core:forEach items="${liste}" var="ligne">
<input type="hidden" value=" " />
            <table>
                <tr>
                    <td>${ligne.produit}${ligne.produit.getId()}</td> 
                
                    <td>${ligne.preferences}</td>
                    <td>${ligne.garnitures}</td>
                    <td>${ligne.etat}</td>
                  
                    <td><a href="Controller?section=commande.acka&action=su"> Supprimer</a></td>
                    
                </tr>

            </table>

        </core:forEach>


<script src="../../js/alerte.js" type="text/javascript"></script>
    </body>
</html>
