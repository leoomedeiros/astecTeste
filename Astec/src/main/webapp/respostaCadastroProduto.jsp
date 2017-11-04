<%-- 
    Document   : respostaCadastroProduto
    Created on : 02/11/2017, 22:23:41
    Author     : rafael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>produto cadastrado:</h1>
        <p><c:out value="${novoProd.nomeProduto}" /></p>
        <p><c:out value="${novoProd.categoria}" /></p>
        <p><c:out value="${novoProd.tamanho}" /></p>
        <p><c:out value="${novoProd.preco}" /></p>
        <p><c:out value="${novoProd.cor}" /></p>
        <p><c:out value="${novoProd.quantidade}" /></p>
        <p><c:out value="${novoProd.descricao}" /></p>
        <p><c:out value="${novoProd.codigoProduto}" /></p>
        <p><c:out value="${novoProd.codigoBanco}" /></p>
        <p><c:out value="${novoProd.dtCadastro}" /></p>
        
    </body>
</html>
