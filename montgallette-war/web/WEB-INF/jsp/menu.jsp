
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu</title>
    </head>
    <body>
        <div id="menuSession">
            <c:url value="/WEB-INF/jsp/sub/menuSession.jsp" var="urlm01"/>
            <c:import url="${urln01}"/>
        </div>
        <div id="menuNavigation">
            <c:url value="/WEB-INF/jsp/sub/menuNavigation.jsp" var="urlm02"/>
            <c:import url="${urln02}"/>
        </div>
        <div id="menuCarte">
            <c:url value="Controller?section=menu.acka&action=voir" var="urlm03"/>
            <c:import url="${urln03}"/>
        </div>
    </body>
</html>
