<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:url value="Controller?section=menu.acka&action=creerDonnees" var="urlcm01" />
<a href="${urlcm01}" >Créer jeu de test</a>

<br><br>
<div>
    <table>
        <tbody>
            <c:forEach items="${produits}" var="p">
                <tr>
                    <td id="tdStyle${p.id%2}"><img id="photoProduit" src=${p.photoURL}>
                        <div id="textCourt"><b>${p.nom}</b><br>${p.descriptionCourte}</div>
                        <div id="prix"><fmt:formatNumber minFractionDigits="2" value="${p.prixHT}"/></div> 
                        <div><img id="voirDetails" src="images/voirDetails.png" alt=""/></div>
                        <div><img id="ajouter" src="images/ajouter.png" alt="Ajouter"/></div>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>