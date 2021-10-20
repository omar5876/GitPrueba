
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alcance de Variables</title>
    </head>
    <body>
        <h1>Alcance de Variables</h1>
        <br/>
        Variable request:<br/>
        Altura: ${rectanguloRequest.altura}
        Base: ${rectanguloRequest.base}
        Area: ${rectanguloRequest.area}
        <br/><br/>
        Variable session:<br/>
        Altura: ${rectanguloSesion.altura}
        Base: ${rectanguloSesion.base}
        Area: ${rectanguloSesion.area}
        <br/><br/>
        Variable aplicacion:<br/>
        Altura: ${rectanguloAplicacion.altura}
        Base: ${rectanguloAplicacion.base}
        Area: ${rectanguloAplicacion.area}
        <br/><br/>
        <a href="${pageContent.request.contextPath}/index.jsp">Regresar al Inicio</a>
    </body>
</html>
