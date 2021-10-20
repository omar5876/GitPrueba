<%-- 
    Document   : index
    Created on : 5/10/2021, 2:15:58 p. m.
    Author     : ramiredw
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Hola Mundo JSPs</title>
    </head>
    <body>
        <h1>Hola Mundo JSPs</h1>
        <ul>
            <li> <% out.print("Hola Mundo con Scriptlets"); %></li>
            <li>${"Hola Mundo con Expression Language (EL)"}</li>
            <li><%="Hola Mundo con Expresiones" %></li>
            <li> <c:out value="Hola Mundo con JSTL"/></li>
        </ul>
    </body>
</html>
