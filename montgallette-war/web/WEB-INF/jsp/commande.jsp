
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>


        <h1>Votre Commande</h1><br><br><br><br>
        ${msgCommande}
        <br><br><br><br>

        <core:forEach items="${liste}" var="ligne">

            <form method="GET" action="Controller">     
                <input type="hidden" name="section" value="commande.acka"/>
                <input type="hidden" name="action" value="su"/>             
                <input type="hidden" name="ligne" value="${ligne.idLocal}"/>
                

                <table>
                    <tr>
                        <td>${ligne.produit}</td>                 
                        <td>${ligne.preferences}</td>
                        <td>${ligne.garnitures}</td>
                        <td>${ligne.etat}</td>
                        
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

