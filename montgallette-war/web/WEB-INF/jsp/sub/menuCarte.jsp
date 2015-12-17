<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

    <table>
        <tbody>
            <c:forEach items="${produits}" var="p">
                <tr>
                    <td id="tdStyle${p.id%2}"><img id="photoProduit" src=${p.photoURL}>
                        <div id="textCourt"><b>${p.nom}</b><br>${p.descriptionCourte}</div>
                        <div id="prix"> <fmt:formatNumber value="${p.prixHT}" minFractionDigits="2" currencySymbol="&euro;" type="currency"/></div>
                        <div onclick="refreshCommande(${p.id})" title="Ajouter" id="ajouter"><img src="images/ajouter.png" onmouseover="this.src = 'images/ajouterACTIF.png';" onmouseout="this.src = 'images/ajouter.png';"/></div>
                        <div title="Afficher les details" id="details"><img src="images/details.png" onmouseover="this.src = 'images/detailsACTIF.png';" onmouseout="this.src = 'images/details.png';"/></div>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

