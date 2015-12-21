<%-- 
    Document   : newjspgarcon
    Created on : 2 déc. 2015, 13:53:02
    Author     : cdi406
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/global.css" rel="stylesheet" type="text/css" />
        <link href="css/cssGarcon.css" rel="stylesheet" type="text/css" />
        <title>Garçon</title>
    </head>
    <body>

        <p id="controls">
            <a id="home" href="Controller?section=login.acka">Accueil</a> 
            </br>

            <a id="deco" href="Controller?section=login.acka&action=deco">Déconnexion</a>
        </p>

        </br>

        <div id="plan">

            <c:url value="images/Table4persDispo.png" var="t4d"/>

            <c:url value="images/Table4persIndispo.png" var="t4i"/>


            <div class="rang">
            <c:forEach items="${lemp}" var="e" end="5">

                <c:if test="${e.dispo}">


                    <div class="planCell" id="${e.numero}">
                        <a href="Controller?section=commande.acka&action=creerTable&table=${e.numero}"><img  src="${t4d}" alt=""/></a>
                    </div>


                </c:if>
                <c:if test="${!e.dispo}">

                    <div class="planCell" id="${e.numero}">
                        <a href="Controller?section=commande.acka&action=creerTable&table=${e.numero}"><img src="${t4i}" alt=""/></a>
                    </div>

                </c:if>
            </c:forEach>
                </div>
            
            <div class="rang">
            <c:forEach items="${lemp}" var="e" begin="6" end="11">

                <c:if test="${e.dispo}">


                    <div class="planCell" id="${e.numero}">
                        <a href="Controller?section=commande.acka&action=creerTable&table=${e.numero}"><img  src="${t4d}" alt=""/></a>
                    </div>


                </c:if>
                <c:if test="${!e.dispo}">

                    <div class="planCell" id="${e.numero}">
                        <a href="Controller?section=commande.acka&action=creerTable&table=${e.numero}"><img src="${t4i}" alt=""/></a>
                    </div>

                </c:if>
            </c:forEach>
                </div>
            
            <div class="rang">
            <c:forEach items="${lemp}" var="e" begin="12" end="17">

                <c:if test="${e.dispo}">


                    <div class="planCell" id="${e.numero}">
                        <a href="Controller?section=commande.acka&action=creerTable&table=${e.numero}"><img  src="${t4d}" alt=""/></a>
                    </div>


                </c:if>
                <c:if test="${!e.dispo}">

                    <div class="planCell" id="${e.numero}">
                        <a href="Controller?section=commande.acka&action=creerTable&table=${e.numero}"><img src="${t4i}" alt=""/></a>
                    </div>

                </c:if>
            </c:forEach>
            </div>



        </div>

        <c:if test="${creer}">
            <c:import url="WEB-INF/jsp/sub/creationTable.jsp"/>
        </c:if>

        <script src="js/alerte.js" type="text/javascript"></script>
        <script src="js/tables.js" type="text/javascript"></script>
    </body>
</html>

