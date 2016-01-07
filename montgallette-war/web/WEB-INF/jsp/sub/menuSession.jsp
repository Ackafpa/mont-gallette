
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<body onload="startTime()">
    <div id="menuSession">  
        <div id="horloge"></div>


        <c:if test="${sessionScope.prov eq 'client'}">
            <div id="bienvenue">Bienvenu/e, vous êtes servi par <span style="color:gold"><c:out value="${user.prenom}"/></span></div>
        </c:if>

        <c:if test="${sessionScope.prov eq 'serveur'}">
            <div id="bienvenue">Bonjour <span style="color:gold"><c:out value="${user.prenom}"/></span></div>
        </c:if>
            
        <div class="dropdown" style="float:right;">
            <div class="dropbtn"></div>
            <div class="dropdown-content">
                <a href="Controller?section=login.acka&action=client">Mode Client</a>
                <a href="Controller?section=login.acka&action=deco">Fermer session</a>
            </div>
        </div>
    </div>
</body>


<script src="js/session.js" type="text/javascript"></script>

