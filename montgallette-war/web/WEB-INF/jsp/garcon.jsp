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

        <div>
            <c:url value="images/Table4persDispo.png" var="t4d"/>
            <c:url value="images/table2persVertiDispo.png" var="t2vd"/>
            <c:url value="images/table2persHorizDispo.png" var="t2hd"/>
            <c:url value="images/Table4persIndispo.png" var="t4i"/>
            <c:url value="images/table2persVertiIndispo.png" var="t2vi"/>
            <c:url value="images/table2persHorizIndispo.png" var="t2hi"/>

            <table>
                <tr>
                    <td><a href="Controller?section=commande.acka&action=creerTable&table=1"><img id="1" src="images/Table4persDispo.png" alt=""/></a></td>
                    <td><a href="Controller?section=commande.acka&action=creerTable&table=2"><img id="2" src="images/table2persVertiDispo.png" alt=""/></a></td>
                    <td><a href="Controller?section=commande.acka&action=creerTable&table=3"><img id="3" src="images/table2persVertiDispo.png" alt=""/></a></td>
                    <td><a href="Controller?section=commande.acka&action=creerTable&table=4"><img id="4" src="images/table2persVertiDispo.png" alt=""/></a></td>
                    <td><a href="Controller?section=commande.acka&action=creerTable&table=5"><img id="5" src="images/table2persVertiDispo.png" alt=""/></a></td>
                    <td><a href="Controller?section=commande.acka&action=creerTable&table=6"><img id="6" src="images/Table4persDispo.png" alt=""/></a></td>
                </tr>
                <tr>
                    <td><a href="Controller?section=commande.acka&action=creerTable&table=7"><img id="7" src="images/table2persHorizDispo.png" alt=""/></a></td>
                    <td><a href="Controller?section=commande.acka&action=creerTable&table=8"><img id="8" src="images/Table4persDispo.png" alt=""/></a></td>
                    <td><a href="Controller?section=commande.acka&action=creerTable&table=9"><img id="9" src="images/Table4persDispo.png" alt=""/></a></td>
                    <td><a href="Controller?section=commande.acka&action=creerTable&table=10"><img id="10" src="images/Table4persDispo.png" alt=""/></a></td>
                    <td><a href="Controller?section=commande.acka&action=creerTable&table=11"><img id="11" src="images/Table4persDispo.png" alt=""/></a></td>
                    <td><a href="Controller?section=commande.acka&action=creerTable&table=12"><img id="12" src="images/table2persHorizDispo.png" alt=""/></a></td>
                </tr>
                <tr>
                    <td><a href="Controller?section=commande.acka&action=creerTable&table=13"><img id="13" src="images/Table4persDispo.png" alt=""/></a></td>
                    <td><a href="Controller?section=commande.acka&action=creerTable&table=14"><img id="14" src="images/table2persVertiDispo.png" alt=""/></a></td>
                    <td><a href="Controller?section=commande.acka&action=creerTable&table=15"><img id="15" src="images/table2persVertiDispo.png" alt=""/></a></td>
                    <td><a href="Controller?section=commande.acka&action=creerTable&table=16"><img id="16" src="images/table2persVertiDispo.png" alt=""/></a></td>
                    <td><a href="Controller?section=commande.acka&action=creerTable&table=17"><img id="17" src="images/table2persVertiDispo.png" alt=""/></a></td>
                    <td><a href="Controller?section=commande.acka&action=creerTable&table=18"><img id="18" src="images/Table4persDispo.png" alt=""/></a></td>
                </tr>
            </table>


        </div>
            
        <c:if test="${creer}">
            <div id="creation">
                <%-- <c:import url='WEB-INF/jsp/creation.jsp'/> --%>
                <form action="Controller" method="post">
                    Nombre de couverts: <input type="text" name="couverts" size="3" maxlength="3"/>
                    <input type="hidden" name="section" value="commande.acka"/>
                    <input type="hidden" name="action" value="creerCo"/>
                    <input type="hidden" name="table" value="${table}"/>
                    <c:if test="${t4p}">
                        <a href="Controller?section=commande.acka&action=creerCo" ><input type="submit" name="doIt" value="Valider" onclick="changeDispo('${table}', 'images/Table4persIndispo.png')"></a>
                        </c:if>

                </form>

            </div>
        </c:if>

        <script src="js/alerte.js" type="text/javascript"></script>
        <script src="js/tables.js" type="text/javascript"></script>
    </body>
</html>

