<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<table>
    <tbody>
        <c:forEach items="${produits}" var="p" varStatus="theCount">
            <tr id="${p.id}">
                <td id="tdStyle${theCount.index%2}"><img id="photoProduit" src=${p.photoURL}>
                    <div id="textCourt"><b>${p.nom}</b><br>${p.descriptionCourte}</div>
                    
                    <div id="prix"> <fmt:formatNumber value="${p.prixHT}" minFractionDigits="2" currencySymbol="&euro;" type="currency"/></div>
                    <!--  effacé = onclick="refreshCommande()parce que ça ne marche pas, merci de tenir compte de ce que je fais dans le menu " -->
                    <a href="Controller?section=commande.acka&action=ajouterLigne&produit=${p.id}"> <div  title="Ajouter" id="ajouter"><img src="images/ajouter.png" onmouseover="this.src = 'images/ajouterACTIF.png';" onmouseout="this.src = 'images/ajouter.png';"/></div></a>                  
                    <div title="Afficher les details" id="details"><img src="images/details.png" onmouseover="this.src = 'images/detailsACTIF.png';" onmouseout="this.src = 'images/details.png';"/></div>
                </td>
            </tr>
    </c:forEach>
</tbody>
</table>

<script src="js/menu.js" type="text/javascript"></script>
