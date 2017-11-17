<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<p><c:out value="${sessionScope.produtoConsultado.nomeProduto}" /></p>
<p><c:out value="${produtoConsultado.categoria}" /></p>--%>
<%-- 
    Document   : produtoConsultarExcluir
    Created on : Nov 10, 2017, 9:46:45 AM
    Author     : r.almeida.barbosa
--%>
<!DOCTYPE html>
<html>
    <head>
        <title>Exclusão de produtos</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="produtoConsultarExcluir2.css" type="text/css" rel="stylesheet">
        <script src="produtoConsultarExcluir2.js" type="text/javascript" rel="javascript"></script>
    </head>
    <body>
        <div id="direito">
            <div id="cabecalho">
                <img class="logo" src="http://i65.tinypic.com/2uenpch.png"/>
                <h1>Exclusão</h1>


            </div>
            <div id="conteudo">
                
                <h2>Produto "<c:out value="${sessionScope.produtoConsultado.nomeProduto}" />" excluído com sucesso.</h2>
                <a id="ok" href="../produtoConsultarExcluir.jsp">Voltar</a>
                
            </div>

        </div>


        <div class="menu principal">
            <div class="usuario">
                <div class="informacoes">
                    <h5>Nome do Usuario</h5>
                    <h6>Cargo do Usuario</h6>
                </div>
                <img class="imagemPerfil" src="http://i63.tinypic.com/2zspjlh.jpg"/>
            </div>

            <ul class="menu">
                <li type="visible">
                    <a href="../../../home/home.jsp">Home</a>
                </li>
                <li type="visible">
                    <a>CRUD Produto</a>

                </li>
                <li type="visible">
                    <a>CRUD Cliente</a>

                </li>
                <li type="visible">
                    <a href="../../venda/venda.html">Venda</a>                    
                </li>
                <li type="visible">
                    <a>Relatórios</a>

                </li>
                <li type="visible">
                    <a>Usuários</a>

                </li>
                <li type="visible">
                    <a href="#">Sair</a>
                </li>  
            </ul>
        </div>

        <div id="subProduto" class="sub">
            <ul class="submenu">
                <li>
                    <a href="../../Cadastrar/produtoCadastrar.jsp">Cadastrar Produto</a>
                </li>
                <li>
                    <a href="../produtoConsultarExcluir.jsp">Consultar Produto</a>
                </li>
            </ul>
        </div>

        <div id="subCliente" class="sub">
            <ul class="submenu">
                <li>
                    <a href="#">Cadastrar Cliente</a>
                </li>
                <li>
                    <a href="#">Consultar Cliente</a>
                </li>
            </ul>
        </div>

        <div id="subRelatorio" class="sub">
            <ul class="submenu">
                <li id="relProduto" type="hidden">
                    <a href="#">Relatório de Produto</a>
                </li>
                <li id="relVenda" type="hidden">
                    <a href="#">Relatório de Venda</a>
                </li>
                <li id="relLog" type="hidden">
                    <a href="#">Relatório de Log</a>
                </li>
            </ul>
        </div>

        <div id="subUsuario" class="sub">
            <ul class="submenu" >
                <li>
                    <a href="#">Cadastrar Usuário</a>
                </li>
                <li>
                    <a href="#">Consultar Usuário</a>
                </li>
            </ul>
        </div>

    </body>
</html>

