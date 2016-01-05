<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<div id="headerIMG"><img src="images/menu/${param.categorie}.jpg"</div>

<div class="accordion vertical">
    <c:forEach items="${produits}" var="p" varStatus="theCount">
        <section id="${p.id}">
            <h2><a href="#${p.id}">${p.nom}</a></h2>
            
            <p>${p.descriptionCourte}</p>
            <p>${p.descriptionComplete}</p>
        </section>
    </c:forEach>
    
    <c:forEach var="pageParameter" items="${param}">
        <li> <c:out value="${pageParameter.key}" /> = <c:out value="${pageParameter.value}" />
      </c:forEach>
            
            <c:out value="****************************************"/>
            <c:out value="USER - ${session.user}"/>
            <c:out value="PROV - ${session.prov}"/>
</div>

<script src="js/menu.js" type="text/javascript"></script>
