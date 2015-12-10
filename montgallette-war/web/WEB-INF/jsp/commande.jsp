
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
        <h1>Votre Commande</h1>
       Message :  ${msg}
       <core:forEach items="${liste}" var="ligne">

            <table>
                <tr>
                    <td>${ligne.produit}</td> 
                    <td>${ligne.preferences}</td>
                    <td>${ligne.garnitures}</td>
                    <td>${ligne.etat}</td>
                </tr>

            </table>

        </core:forEach>



    </body>
</html>
