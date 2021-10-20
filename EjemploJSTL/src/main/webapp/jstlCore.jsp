<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSTL Core</title>
    </head>
    <body>
        <h1>JSTL Core (Jsp Standart Tag Library)</h1>
        <c:set var="nombre" value="ernesto"/>
        Variable nombre: <c:out value="${nombre}"/>
        <br/>
        <br/>
        <c:out value="<h4>Hola<h4/>" escapeXml="false"/>
        <br/>
        <br/>
        <c:set var="bandera" value="true"/>
        <br/>
        <c:if test="${bandera}">
            La Bandera es Verdadera
        </c:if>
        <br/>
        <br/>
        <c:if test="${param.opcion != null}">
            <c:choose>
                <c:when test="${param.opcion == 1}">
                    Opcion es igual a 1
                </c:when>
                <c:when test="${param.opcion == 2}">
                    Opcion es igual a 2
                </c:when>
                <c:otherwise>
                    Opcion Desconocida: ${param.opcion}
                </c:otherwise>
            </c:choose>
        </c:if>
        <%
            String nombres[] = {"Claudia", "Pedro", "Juan"};
            request.setAttribute("nombres", nombres);
        %> 
        <br/>
        Lista de Nombre:
        <br/>
        <ul>
            <c:forEach var="persona" items="${nombres}">
                <li>Nombre: ${persona}</li>
            </c:forEach>
        </ul>
        <br/>
        <a href="index.jsp">Regresar al Inicio</a>
    </body>
</html>
