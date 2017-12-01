<%-- 
    Document   : clienteCadastrar
    Created on : 19/11/2017, 14:06:10
    Author     : Fernando
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Cadastrar de Funcionário:</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="funcionarioCadastrar.css" rel="stylesheet">
        <script src="funcionarioCadastrar.js" type="text/javascript"></script>
    </head>
    <body>
        <div id="direito">
            <div id="cabecalho">
                <!--<img class="logo" src="https://i.imgur.com/mgK1d4U.jpg"/> -->
                <img class="logo" src="http://i65.tinypic.com/2uenpch.png"/>
                <h1>Cadastrar Funcionário:</h1>


            </div>

            <div id="conteudo">
                <form action="${pageContext.request.contextPath}/FuncionarioCadastrarServlet" method="post">  
                    <div id="contEsq" class="divisoria">
                        <h4>Nome completo:<br></h4>
                        <input type="text" name="nome" value="Rafael da Silva Sauro"><br>

                        <h4>Usuário:<br></h4>
                        <input type="text" name="usuario" value="rafa"><br>

                        <h4>Departamento:</h4>
                        <select name="slcDepar">
                            <option value="diretoria">diretoria</option>
                            <option value="gerencia">gerência</option>
                            <option value="backoffice">backoffice</option>
                            <option value="venda">venda</option>
                            <option value="suporte">suporte</option>
                        </select>

                        <h4>Filial:</h4>
                        <select name="slcFilial">

                            <option value="Sao Paulo">São Paulo</option>
                            <option value="Recife">Recife</option>
                            <option value="Porto Alegre">Porto Alegre</option>
                        </select>

                        <h4>Cargo:<br></h4>
                        <input type="text" name="cargo" value="admin" <br>

                        <h4>Senha:<br></h4>
                        <input type="password" name="senha" value="abc123"<br>

                    </div>

                    <input name="enviar" type="submit" value="Cadastrar">


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
                    <a href="../../Funcionario/Cadastrar/funcionarioCadastrar.jsp">Cadastrar Funcionário</a>
                </li>
                <li>
                    <a href="../Consultar/respostaConsulta/respostaConsultar.jsp">Consultar Funcionário</a>
                </li>
            </ul>
        </div>

    </body>
</html>
