<%-- 
    Document   : clienteConsultarExcluir
    Created on : 20/11/2017, 09:28:20
    Author     : Fernando
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Consulta de Funcionarios</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="respostaConsultar.css" rel="stylesheet">
        <script src="respostaConsultar.js" type="text/javascript"></script>
    </head>
    <body>
        <div id="direito">
            <div id="cabecalho">
                <!--<img class="logo" src="https://i.imgur.com/mgK1d4U.jpg"/> -->
                <img class="logo" src="http://i65.tinypic.com/2uenpch.png"/>
                <h1>Consulta de Funcionarios:</h1>


            </div>

            <div id="conteudo">
                <form class="pesquisa" action="${pageContext.request.contextPath}/FuncionarioConsulta" method="post">  
                    <div id="contEsq" class="divisoria">
                        <h4><br></h4>
                        <input type="text" name="nomeFuncionario" placeholder="Digite aqui o que deseja buscar..."><br>


                    </div>

                    <div id="contDir" class="divisoria">
                        <h4>Pesquisar Por:</h4>    
                        <select name="selectConsulta" >
                            <option value="nome">Nome</option>
                            <option value="todos">Todos</option>
                        </select>

                    </div>

                    <input class="botao" name="buscar" type="submit" value="Buscar">
                </form>

                <div class="divTabela">
                    <table>


                        <tr>
                            <th>Codigo:</th>
                            <th>Nome:</th>
                            <th>Usuário:</th>
                            <th>Departamento:</th>
                            <th>Filial:</th>
                            <th>Cargo:</th>
                        </tr>

                        <c:forEach var="listaFuncionarios" items="${sessionScope.listaFuncionarios}">
                            <tr class="linhas">
                                <td><c:out value="${listaFuncionarios.id}"/></td>
                                <td><c:out value="${listaFuncionarios.nome}"/></td>
                                <td><c:out value="${listaFuncionarios.usuario}"/></td>
                                <td><c:out value="${listaFuncionarios.departamento}"/></td>
                                <td><c:out value="${listaFuncionarios.filial}"/></td>
                                <td><c:out value="${listaFuncionarios.cargo}"/></td>
                            </tr>
                        </c:forEach>

                    </table>

                </div>

                <hr>

                <form class="excluirAlterar" action="${pageContext.request.contextPath}/FuncionarioAlterar" method="post">
                    <h4>Digite o codigo do Funcionário:</h4>
                    <input type="number" name="inserirCodigo" ><br>
                    <div class="boxBotoes">
                        <input class="botao" name="alterar" type="submit" value="Alterar">
                    </div>
                </form>
                <form class="excluirAlterar" action="${pageContext.request.contextPath}/FuncionarioExcluir" method="post">
                    <h4>Digite o codigo do Funcionário:</h4>
                    <input type="number" name="inserirCodigo" ><br>
                    <div class="boxBotoes">
                        <input class="botao" name="excluir" type="submit" value="Excluir">
                    </div>
                </form>


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
                    <a>Usuários</a>

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
                    <a href="../../../Produto/Cadastrar/produtoCadastrar.jsp">Cadastrar Produto</a>
                </li>
                <li>
                    <a href="../../../Produto/ConsultarExcluir/produtoConsultarExcluir.jsp">Consultar Produto</a>
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
                <li id="relCliente" type="hidden">
                    <a href="#">Relatório de Cliente</a>
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
                    <a href="../../Cadastrar/funcionarioCadastrar.jsp">Cadastrar Funcionário</a>
                </li>
                <li>
                    <a href="../Consultar/respostaConsulta/respostaConsultar.jsp">Consultar Funcionário</a>
                </li>
            </ul>
        </div>

    </body>
</html>
