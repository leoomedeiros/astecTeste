<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Alteração de Funcionário:</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="alterarCadastro.css" rel="stylesheet">
        <script src="alterarCadastro.js" type="text/javascript"></script>
    </head>
    <body>
        <div id="direito">
            <div id="cabecalho">
                <!--<img class="logo" src="https://i.imgur.com/mgK1d4U.jpg"/> -->
                <img class="logo" src="http://i65.tinypic.com/2uenpch.png"/>
                <h1>Alteração</h1>


            </div>

            <!----------------------------------------------------------------------------->

            <div id="conteudo">
                <form action="${pageContext.request.contextPath}/FuncionarioAlteracaoSalvar" method="post">  
                    <div id="contEsq" class="divisoria">
                        <h4>*Nome completo:<br></h4>
                        <input type="text" name="nome" value="${sessionScope.FuncionarioConsultado.nome}"/><br>

                        <h4>*Usuário:<br></h4>
                        <input type="text" name="usuario" value="${sessionScope.FuncionarioConsultado.usuario}"/><br>


                        <h4>Departamento:<br></h4>
                        <select name="slcDepar" value="${sessionScope.FuncionarioConsultado.departamento}">

                            <option value="diretoria">diretoria</option>
                            <option value="gerencia">gerência</option>
                            <option value="backoffice">backoffice</option>
                            <option value="venda">venda</option>
                            <option value="suporte">suporte técnico</option>
                        </select>
                        <br>

                        <h4>Filial:<br></h4>
                        <select name="slcFilial" value="${sessionScope.FuncionarioConsultado.filial}">

                            <option value="Sao Paulo">São Paulo</option>
                            <option value="Recife">Recife</option>
                            <option value="Porto Alegre">Porto Alegre</option>
                        </select><br>

                        <h4>Cargo:<br></h4>
                        <input type="text" name="cargo" value="${sessionScope.FuncionarioConsultado.cargo}" /> <br>
                    </div>

                    <input name="enviar" type="submit" value="Alterar">


                </form>
            </div>

            <!----------------------------------------------------------------------------->


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
