
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div id="headerIMG"><img src="images/menu/${param.categorie}.jpg"</div>



<div class="accordion vertical">

    <c:forEach items="${produits}" var="p" varStatus="theCount">
        <section id="${p.id}">

            <h2><a href="#${p.id}">${p.nom}</a></h2>
            <img id="photoProduit" src="${p.photoURL}">
            <c:if test="${sessionScope.prov eq 'client'}">
                <p>${p.descriptionCourte}</p>
                <p>${p.descriptionComplete}</p>
            </c:if>
            <div id="ajouter"><a href="#" onclick="refreshCommande(${p.id})">Ajouter</a></div>
        </section>
    </c:forEach>        
    
</div>




<script src="js/menu.js" type="text/javascript"></script>
