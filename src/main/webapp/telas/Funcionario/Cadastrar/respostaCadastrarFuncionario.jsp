

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Cadastro de Funcionario:</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="telas/Funcionario/Cadastrar/funcionarioCadastrar.css" type="text/css" rel="stylesheet">
        <link href="funcionarioCadastrar.css" type="text/css" rel="stylesheet">
        <script src="telas/Funcionario/Cadastrar/funcionarioCadastrar.js" type="text/javascript" rel="javascript"></script>
        <script src="funcionarioCadastrar.js" type="text/javascript" rel="javascript"></script>
    </head>
    <body>
        <div id="direito">
            <div id="cabecalho">
                <img class="logo" src="http://i65.tinypic.com/2uenpch.png"/>
                <h1>Cadastramento</h1>
            </div>

            <div id="conteudo">
                <h2>Funcionário cadastrado com sucesso.</h2>
                <a id="ok" href="funcionarioCadastrar.jsp">Voltar</a>
            </div>


        </div>


        <div class="menu principal">
            <div class="usuario">
                <div class="informacoes">
                    <h5>Nome do Funcionário</h5>
                    <h6>Cargo do Funcionário</h6>
                </div>
                <img class="imagemPerfil" src="http://i63.tinypic.com/2zspjlh.jpg"/>
            </div>

            <ul class="menu">
                <li type="visible">
                    <a href="#">Home</a>
                </li>
                <li type="visible">
                    <a>Produto</a>

                </li>

                <li type="visible">
                    <a>Cliente</a>

                </li>
                <li type="visible">
                    <a href="../../venda/venda.html">Venda</a>                    
                </li>
                <li type="visible">
                    <a>Relatórios</a>

                </li>
                <li type="visible">
                    <a href="#">Usuários</a>

                </li>
                <li type="visible">
                    <a href="${pageContext.request.contextPath}/logout">Sair</a>
                    <input id="perfil" hidden value="<c:out value="${usuario}"/>">
                </li>  
            </ul>
        </div>

        <div id="subProduto" class="sub">
            <ul class="submenu">
                <li>
                    <a href="../../Produto/Cadastrar/produtoCadastrar.jsp">Cadastrar Produto</a>
                </li>
                <li>
                    <a href="../../Produto/ConsultarExcluir/produtoConsultarExcluir.jsp">Consultar Produto</a>
                </li>
            </ul>
        </div>


        <div id="subCliente" class="sub">
            <ul class="submenu">
                <li>
                    <a href="../../Cliente/Cadastrar/clienteCadastrar.jsp">Cadastrar Cliente</a>
                </li>
                <li>
                    <a href="../../Cliente/Consultar/clienteConsultar.jsp">Consultar Cliente</a>
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
                    <a href="../../Funcionario/Cadastrar/funcionarioCadastrar.jsp">Cadastrar Funcionário</a>
                </li>
                <li>
                    <a href="../Consultar/respostaConsulta/respostaConsultar.jsp">Consultar Funcionário</a>
                </li>
            </ul>
        </div>

    </body>
</html>
