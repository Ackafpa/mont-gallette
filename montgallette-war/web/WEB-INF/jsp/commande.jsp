
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
        <h1>Votre Commande</h1><br><br><br><br>
        ${msgCommande}
        <br><br><br><br>

        <core:forEach items="${liste}" var="ligne">

            <form method="GET" action="Controller">     
                <input type="hidden" value="${ligne.id}" />
                <input type="hidden" name="section" value="commande.acka"/>
                <input type="hidden" name="action" value="su"/>
                <input type="hidden" name="commande" value="${ligne.commande.id}"/>
                <input type="hidden" name="ligne" value="${ligne.id}"/>

                <table>
                    <tr>

                        <td>${ligne.produit}</td>                 
                        <td>${ligne.preferences}</td>
                        <td>${ligne.garnitures}</td>
                        <td>${ligne.etat}</td>
                        <td>ID : ${ligne.id} Commande : ${ligne.commande.id}</td>


                        <td><input type="submit" name="DoSu" value="Suprimer"></td>

                    </tr>

                </table>

            </form>   
        </core:forEach>
        <form method="GET" action ="Controller">

            <input type="hidden" name="section" value="commande.acka"/>
            <input type="hidden" name="action" value="val">
            <input type="submit" name="val" value="Valider">
        </form>
        <script src="../../js/alerte.js" type="text/javascript"></script>
    </body>
</html>
