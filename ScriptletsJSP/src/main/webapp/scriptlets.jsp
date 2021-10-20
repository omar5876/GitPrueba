

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP con Scriptlets</title>
    </head>
    <body>
        <h1>JSP con Scriptlets</h1>
        <br>
        <%--Scriptlet para enviar informacion al servidor--%>
        <%
            out.print("Saludos desde un Scriptlet");
        %>
        <%--Scriptlet para manipular los objetos implicitos--%>
        <%
            String nombreAplicacion = request.getContextPath();
            out.print("Nombre de la Aplicacion: " + nombreAplicacion);
        %>
        <br>
        <%--Scriptlet con codigo condicionado--%>
        <%
            if(session != null && session.isNew()){
        %>
        La sesion SI es nueva
        <%
            } else if(session != null){
        %>
        La sesion NO es nueva
        <%
            }
        %>
        <br>
        <a href="index.html">Regresar al inicio</a>
    </body>
</html>
