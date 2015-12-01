<%-- 
    Document   : login
    Created on : 1 déc. 2015, 13:54:03
    Author     : cdi406
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <form action="Controller" method="get">
            Entrez votre code</br>
            <input type="password" name="code"/>
            <input type="hidden" name="section" value="login.acka"/>
            </br>
            
            <a href="Controller?section=login.acka&action=login"><input type="submit" name="login" value="Connexion"/></a>
        </form>    
    </body>
</html>
