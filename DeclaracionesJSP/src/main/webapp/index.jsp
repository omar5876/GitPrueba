<%--Agregamos una declaracion de JSP--%>
<%!
private String usuario = "Omar";

public String getUsuario(){
    return this.usuario;
}

private int contadorVisitas = 1;
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Uso de declaraciones JSPs</title>
    </head>
    <body>
        <h1>Uso de declaraciones JSPs</h1>
        Valor del usuario por medio del atributo: <%=this.usuario%>
        <br>
        Valor del usuario por medio del metodo: <%=this.getUsuario()%>
        <br><!-- comment -->
        Contador Visitas: <%=this.contadorVisitas++%>
    </body>
</html>
