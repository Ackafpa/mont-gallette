<%-- 
    Document   : menuCarte
    Created on : 7 déc. 2015, 16:19:07
    Author     : cdi411
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

        <h1>Carte</h1>
        <div>
            <table border="1">
                <thead>
                    <tr>
                        <th>Nom</th>
                        <th>Disponibilié</th>
                        <th>Preparation?</th>
                        <th>Prix</th>
                        <th>Description courte</th>
                        <th>Description complete</th>
                        <th>Categorie</th> 
                    </tr>                    
                </thead>
                <tbody>
                    <c:forEach items="${produits}" var="p">
                        <tr>
                            <td>${p.reference}</td>
                            <td>${p.label}</td>
                            <td><fmt:formatNumber value="${p.prixHT}" minIntegerDigits="2" minFractionDigits="2" maxFractionDigits="2" currencySymbol="€"/></td>
                            <td>${p.qte}</td>
                            <td>
                                <c:url var="url01" value="ControllerMVC2?section=panier.mcp&action=add&ref=${p.reference}"/>
                                <a href="${url01}">Ajouter ${p.label} au panier</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>