
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div onclick="refreshMenu('boisson')" title="Boissons" id="optionNavBoisson"></div>
<div onclick="refreshMenu('entree')" title="Entrées" id="optionNavEntree"></div>
<div onclick="refreshMenu('plat')" title="Plats" id="optionNavPlat"></div>
<div onclick="refreshMenu('dessert')" title="Desserts" id="optionNavDessert"></div>
<div onclick="refreshMenu('formule')" title="Formules" id="optionNavFormule"></div>

<script src="js/menu.js" type="text/javascript"></script>
