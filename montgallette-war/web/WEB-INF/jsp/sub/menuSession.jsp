
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<body onload="startTime()">
    <div id="menuSession">  
        <div id="horloge"></div>
        <div id="bienvenue">Bienvenu/e, vous êtes servi par <span style="color:gold"><c:out value="${user.prenom}"/></span></div>
        <div id="optionsSession" onclick="afficherOptionsSession()" title="Options"/>
    </div>
</body>

<script src="js/session.js" type="text/javascript"></script>

