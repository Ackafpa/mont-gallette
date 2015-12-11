<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url value="Controller?section=menu.acka&action=creerDonnees" var="urlcm01" />
<a href="${urlcm01}" >Créer jeu de test</a>

<br><br>
<div>
    <table>
        <tbody>
            <c:forEach items="${commandes}" var="p">
                <c:forEach items="${listeCuisine}" var="lc">
                    <tr>
                        <td id="tdStyle${lc.id%2}">
                            <div id="textCourt">
                                <b>${lc.nom}</b>
                                <br>${lc.descriptionCourte}</div>
                            <div>
                                <button id="btnPreparation" onclick="preparation()" class="btnCuisineInactif">Préparer</button> <%-- GREY & CLICABLE --%>
                            </div> <%--Bouton preparation ("préparer" > "en préparation") --%>
                            <div>
                                <button id="btnPret" onclick="pret()" disabled>Prêt</button>
                            </div> <%--Bouton "prêt" --%>
                            <div>
                                <button></button>
                            </div> <%--Bouton pour menu avec Rendre indisponible --%>
                            <div><img id="rendreIndispo" src="images/?.png" alt="RendreIndispo"/></div> 
                        </td>
                    </tr>
                </c:forEach>
            </c:forEach>
        </tbody>
    </table>
</div>

<script>
    //Passe btnPreparation en couleur et passe btnPret en grey et clicable
    function preparation() {
        if (document.getElementById('btnPreparation').value === 'Preparer Plat') {
            document.getElementById('btnPreparation').value = 'En préparation';
            document.getElementById('btnPreparation').class = 'btnCuisinePreparation';
            document.getElementById('btnPret').disabled = false;//changer état btnPret
            document.getElementById('').value = ;//changer état attribut produit
        } else {
            document.getElementById('btnPreparation').value = 'Préparer';
            document.getElementById('btnPreparation').class = 'btnCuisineInactif';
            document.getElementById('btnPret').disabled = true;
            //changer état btnPret
            //changer état attribut produit
        }
    }

    //
    function pret() {

    }

    //annule pret() et revient a etat en preparation()
    function annulerPret() {

    }


</script>

