<%-- 
    Document   : respostaProdutoAlterado
    Created on : Nov 13, 2017, 2:19:16 PM
    Author     : r.almeida.barbosa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Alteração de produto:</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="produtoCadastrar1.css" rel="stylesheet">
        <script src="produtoCadastrar1.js" type="text/javascript"></script>
    </head>
    <body>
        <div id="direito">
            <div id="cabecalho">
                <img class="logo" src="http://i65.tinypic.com/2uenpch.png"/>
                <h1>Alteração</h1>


            </div>
            <div id="conteudo">

                Produto<h1><c:out value="${sessionScope.produtoConsultado.nomeProduto}" /></h1> alterado com sucesso.
                <a href="../produtoConsultarExcluir.jsp">OK</a>
                <br>
                <br>
                <br>
                <br>
                <br>
                <br>
                <br>
                <br>
                <br>
                <br>
                <br>
                <br>

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
                    <a href="../../home/home.jsp">Home</a>
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
                    <a href="telas/Produto/Cadastrar/produtoCadastrar.jsp">Cadastrar Produto</a>
                </li>
                <li>
                    <a href="telas/Produto/ConsultarExcluir/produtoConsultarExcluir.jsp">Consultar Produto</a>
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
