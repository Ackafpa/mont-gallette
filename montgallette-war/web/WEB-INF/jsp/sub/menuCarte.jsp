
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:url value="Controller?section=menu.acka&action=creerDonnees" var="urlcm01" />
<a href="${urlcm01}" >Créer jeu de test</a> 
<br><br>
<div>
    <table border="1">
        <thead>
            <tr>
                <th></th>
                <th>Nom</th>
                <th>Disponibilié</th>
                <th>Preparation?</th>
                <th>Prix</th>
                <th>Description courte</th>
                <th>Description complete</th>
                <th>Categorie</th> 
            </tr>                    
        </thead>
        <tbody>
            <c:forEach items="${produits}" var="p">
                <tr>
                    <td><img src=${p.photoURL}></td>
                    <td>${p.nom}</td>
                    <td>${p.dispo}</td>
                    <td>${p.preparation}</td>
                    <td>${p.prixHT}</td>
                    <td>${p.descriptionCourte}</td>
                    <td>${p.descriptionComplete}</td>
                    <td>${p.categorie.nom}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>