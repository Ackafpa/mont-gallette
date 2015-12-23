<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="Controller?section=menu.acka&action=creerDonnees" var="urlcm01" />

        <div id="menuSession">
            <c:url value="WEB-INF/jsp/sub/menuSession.jsp" var="urlm01"/>
            <c:import url="${urlm01}"/>
        </div>
        <div id="menuNavigation">
            <c:url value="WEB-INF/jsp/sub/menuNavigation.jsp" var="urlm02"/>
            <c:import url="${urlm02}"/>
        </div>
        <div id="menuCarte">
            <c:url value="Controller?section=menu.acka&action=afficher&categorie=boisson" var="urlm03"/>
            <c:import url="${urlm03}"/>
        </div>
