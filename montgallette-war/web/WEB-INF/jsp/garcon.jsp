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
            
            <table> 
                <tr>
                    <c:forEach items="${lemp}" var="e" begin="0">
                        <c:if test="${e.dispo}">


                        <div class="plan" id="${e.numero}">
                            <td>  <a href="Controller?section=commande.acka&action=creerTable&table=${e.numero}"><img  src="${t4d}" alt=""/></a></td>
                        </div>

                    </c:if>
                    <c:if test="${!e.dispo}">

                        <div class="plan" id="${e.numero}">
                            <td>  <a href="Controller?section=commande.acka&action=creerTable&table=${e.numero}"><img src="${t4i}" alt=""/></a></td>
                        </div>

                    </c:if>
                </c:forEach>
                </tr>
            </table>
        </div>

        <c:if test="${creer}">
            <div id="creation">

                <form action="Controller" method="post">
                    Nombre de couverts: <input type="text" name="couverts" size="3" maxlength="3"/>
                    <input type="hidden" name="section" value="commande.acka"/>
                    <input type="hidden" name="action" value="creerCo"/>
                    <input type="hidden" name="table" value="${table}"/>


                    <a href="Controller?section=commande.acka&action=creerCo" ><input type="submit" name="doIt" value="Valider"  onclick="changeDispo('${table}', '${t4i}')"/></a>


                </form>

            </div>
        </c:if>

        <script src="js/alerte.js" type="text/javascript"></script>
        <script src="js/tables.js" type="text/javascript"></script>
    </body>
</html>

