<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url value="Controller?section=menu.acka&action=creerDonnees" var="urlcm01" />
<a href="${urlcm01}" >Créer jeu de test</a>

<br><br>
<div>
    <table>
        <tbody>
            <c:forEach items="${produits}" var="p">
                <tr>
                    <td id="tdStyle${p.id%2}">
                        <div id="textCourt"><b>${p.nom}</b><br>${p.descriptionCourte}</div>
                        <div id="etat">
                            <button onclick="preparationPlat()">Preparer Plat</button>
                        </div> <%--Bouton preparation (commandé, en préparation...) --%>
                        <div id="btnChangementEtat"></div> <%--Bouton pour commandé>en préparation & en préparation > prêt --%>
                        <div></div> <%--Bouton pour menu avec Rendre indisponible --%>
                        <div><img id="rendreIndispo" src="images/?.png" alt="RendreIndispo"/></div> 
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

<script>
    function preparationPlat(){
        if(document.getElementById('etat').value='Preparer Plat'){
        document.getElementById('etat').value='En préparation';
    }
    }
    </script>
    
