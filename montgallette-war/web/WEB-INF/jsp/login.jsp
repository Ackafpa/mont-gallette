<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<title>Login</title>

<div id="blockLogin">
    <!--<a id="emp" href="Controller?section=login.acka&action=test">Créer jeu de test Employés</a>-->
    <form action="Controller" method="post">
        <p id="enterCode">Entrez votre code</p>
        <%-- TEXTFIELD CODE --%>
        <input id="code" type="password" name="id" maxlength="4" size="4"/>
        <input type="hidden" name="section" value="login.acka"/>
        <input type="hidden" name="action" value="login"/>
        </br>
        </br>
        <%-- CLAVIER NUMERIQUE --%>

        <%-- BOUTON RESET --%>
        <input id="btnReset" class="login" type="reset" value="Delete" onclick="reset()"/>
        <%-- BOUTON CONNEXION --%>
        <a id="linkLogin" href="Controller?section=login.acka&action=login">
            <input class="login" id="submit" type="submit" name="submit" value="Connexion"/>
        </a>
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
        <%-- /CLAVIER NUMERIQUE --%>
    </form>
    <script src="js/clavierLogin.js" type="text/javascript"></script>
    <c:if test="${deco}">
        ${msgDeco}${user.prenom} ${user.nom} ?
        <a href="Controller?section=login.acka&action=deco">Déconnexion</a>
    </c:if>
    <p id="err">${msg}${errCode}</p>
    </br>
</div>
<script src="js/menu.js" type="text/javascript"></script>



