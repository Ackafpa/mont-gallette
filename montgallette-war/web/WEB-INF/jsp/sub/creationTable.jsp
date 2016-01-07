<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<link href="css/global.css" rel="stylesheet" type="text/css" />
<link href="css/cssLogin.css" rel="stylesheet" type="text/css"/>

<div id="creation">
    <form action="Controller" method="post">
        <p id="enterCode">Nombre de couverts:</p><input id="code" type="text" name="couverts" size="3" maxlength="3"/>
        <input type="hidden" name="section" value="commande.acka"/>
        <input type="hidden" name="action" value="creerCo"/>
        <input type="hidden" name="table" value="${table}"/>
        <br />
        <br />
        <a href="Controller?section=commande.acka&action=creerCo" ><input class="login" type="submit" name="doIt" value="Valider"/></a>

        <%-- AJOUT CLAVIER NUMERIQUE --%>
        <%-- BOUTON DELETE --%>
        <input id="btnReset" class="login" type="reset" value="Delete" onclick="reset()"/>
        <br>
        <br>
        <button type="button" class="btnClavier" onclick="ajouter(1)">1</button>
        <button type="button" class="btnClavier" onclick="ajouter(2)">2</button>
        <button type="button" class="btnClavier" onclick="ajouter(3)">3</button>
        <br>
        <button type="button" class="btnClavier" onclick="ajouter(4)">4</button>
        <button type="button" class="btnClavier" onclick="ajouter(5)">5</button>
        <button type="button" class="btnClavier" onclick="ajouter(6)">6</button>
        <br>
        <button type="button" class="btnClavier" onclick="ajouter(7)">7</button>
        <button type="button" class="btnClavier" onclick="ajouter(8)">8</button>
        <button type="button" class="btnClavier" onclick="ajouter(9)">9</button>
        <br>
        <button type="button" class="btnClavier" onclick="ajouter(0)">0</button>
        <br>
        <br>
        <%-- FIN CLAVIER NUMERIQUE --%>

    </form>
</div>
<script src="js/clavierLogin.js" type="text/javascript"></script>
<script src="js/menu.js" type="text/javascript"></script>