<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div id="menuSession">  
    [Date/heure] - Vous �tes servi par <c:out value="${user.prenom}"/>
    <c:url value="Controller?section=menu.acka&action=home" var="urlms01" />
     --- <a href="${urlms01}">Home</a>
</div>
