<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="PT-br">
    <head>
        <meta charset="UTF-8">
        <title>Login</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/telas/estilo.css">
    </head>
    <body onload="popUp()">
        <div>
            <script>
                function popUp() {
                    alert("Usuário ou senha inválidos!");
                }
            </script>
        </div>

        <div id="log">
            <img src="${pageContext.request.contextPath}/telas/logo.png" id="logo" />

            <form action="${pageContext.request.contextPath}/login" method="post">
                <label> Usuário:   </label>
                <input type="text" id="txtUser" name="usuario"/>
                <p/>
                <label> Senha:   </label>
                <input type="password" id="txtSenha" name="senha"/>
                <p/>
                <input type="submit" id="inpSubmit" />

            </form>
        </div>
        <h1></h1>
    </body>
</html>