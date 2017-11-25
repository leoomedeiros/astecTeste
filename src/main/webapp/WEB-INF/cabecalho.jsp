<html>
    <head>
        <title>Home</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="estiloPi.css" rel="stylesheet">
        <script src="programa.js" type="text/javascript"></script>
    </head>
    <body>

        <%@page contentType="text/html" pageEncoding="UTF-8"%>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%--<header style="background-color: pink">--%>
        <h2><c:out value="${sessionScope.usuario.nomeCompleto}" /></h2>
        <%--<p><c:out value="${sessionScope.usuario.hashSenha}" /></p>
        <p><a href="${pageContext.request.contextPath}/logout">Sair</a></p>
        --%>
    </body>
</html>
