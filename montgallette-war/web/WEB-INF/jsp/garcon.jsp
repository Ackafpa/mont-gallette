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
            <table>
                <tr>
                    <td><a onclick="creer()" href="Controller?section=commande.acka&action=creerTable&table=1"><img src="images/Table4persDispo.png" alt=""/></a></td>
                    <td><a href="Controller?section=commande.acka&action=creerTable&table=2"><img src="images/table2persVertiDispo.png" alt=""/></a></td>
                    <td><a href="Controller?section=commande.acka&action=creerTable&table=3"><img src="images/table2persVertiDispo.png" alt=""/></a></td>
                    <td><a href="Controller?section=commande.acka&action=creerTable&table=4"><img src="images/table2persVertiDispo.png" alt=""/></a></td>
                    <td><a href="Controller?section=commande.acka&action=creerTable&table=5"><img src="images/table2persVertiDispo.png" alt=""/></a></td>
                    <td><a href="Controller?section=commande.acka&action=creerTable&table=6"><img src="images/Table4persDispo.png" alt=""/></a></td>
                </tr>
                <tr>
                    <td><a href="Controller?section=commande.acka&action=creerTable&table=7"><img src="images/table2persHorizDispo.png" alt=""/></a></td>
                    <td><a href="Controller?section=commande.acka&action=creerTable&table=8"><img src="images/Table4persDispo.png" alt=""/></a></td>
                    <td><a href="Controller?section=commande.acka&action=creerTable&table=9"><img src="images/Table4persDispo.png" alt=""/></a></td>
                    <td><a href="Controller?section=commande.acka&action=creerTable&table=10"><img src="images/Table4persDispo.png" alt=""/></a></td>
                    <td><a href="Controller?section=commande.acka&action=creerTable&table=11"><img src="images/Table4persDispo.png" alt=""/></a></td>
                    <td><a href="Controller?section=commande.acka&action=creerTable&table=12"><img src="images/table2persHorizDispo.png" alt=""/></a></td>
                </tr>
                <tr>
                    <td><a href="Controller?section=commande.acka&action=creerTable&table=13"><img src="images/Table4persDispo.png" alt=""/></a></td>
                    <td><a href="Controller?section=commande.acka&action=creerTable&table=14"><img src="images/table2persVertiDispo.png" alt=""/></a></td>
                    <td><a href="Controller?section=commande.acka&action=creerTable&table=15"><img src="images/table2persVertiDispo.png" alt=""/></a></td>
                    <td><a href="Controller?section=commande.acka&action=creerTable&table=16"><img src="images/table2persVertiDispo.png" alt=""/></a></td>
                    <td><a href="Controller?section=commande.acka&action=creerTable&table=17"><img src="images/table2persVertiDispo.png" alt=""/></a></td>
                    <td><a href="Controller?section=commande.acka&action=creerTable&table=18"><img src="images/Table4persDispo.png" alt=""/></td>
                </tr>
            </table>
            
            
        </div>
        <c:if test="${creer}">
        <div id="creation">
            <c:import url='WEB-INF/jsp/creation.jsp'/>
        </div>
        </c:if>

        <script src="js/alerte.js" type="text/javascript"></script>
        <script src="js/scriptCreation.js" type="text/javascript"></script>
    </body>
</html>

       