<%-- 
    Document   : clienteConsultarExcluir
    Created on : 20/11/2017, 09:28:20
    Author     : Fernando
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Consulta de Cliente</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="clienteConsultar.css" rel="stylesheet">
        <script src="clienteConsultar.js" type="text/javascript"></script>
    </head>
    <body>
        <div id="direito">
            <div id="cabecalho">
                <!--<img class="logo" src="https://i.imgur.com/mgK1d4U.jpg"/> -->
                <img class="logo" src="http://i65.tinypic.com/2uenpch.png"/>
                <h1>Consulta de Cliente:</h1>


            </div>

            <div id="conteudo">
                <form class="pesquisa" action="${pageContext.request.contextPath}/ClienteConsulta" method="post">  
                    <div id="contEsq" class="divisoria">
                        <h4><br></h4>
                        <input type="text" name="nomeCliente" placeholder="Digite aqui o que deseja buscar..."><br>


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
                            <th>CPF:</th>
                            <th>Endereço:</th>
                            <th>Telefone:</th>
                        </tr> 
                       

                    </table>

                </div>

                <hr>

                <form class="excluirAlterar" action="${pageContext.request.contextPath}/ClienteAlterar" method="post">
                    <h4>Digite o codigo do Cliente:</h4>
                    <input type="number" name="inserirCodigo" ><br>
                    <div class="boxBotoes">
                        <input class="botao" name="alterar" type="submit" value="Alterar">
                    </div>
                </form>
                <form class="excluirAlterar" action="${pageContext.request.contextPath}/ClienteExcluir" method="post">
                    <h4>Digite o codigo do Cliente:</h4>
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
                    <a href="../../home/home.jsp">Home</a>
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
                    <a href="#">Sair</a>
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
                    <a href="../Consultar/clienteConsultar.jsp">Consultar Cliente</a>
                </li>
            </ul>
        </div>

        <div id="subRelatorio" class="sub">
            <ul class="submenu">
                <li id="relCliente" type="hidden">
                    <a href="../../Relatorio/relatorioProduto_falta/relatorioProduto.jsp">Relatório de Cliente</a>
                </li>
                <li id="relVenda" type="hidden">
                    <a href="../../Relatorio/RelatorioVenda/relatorioVenda.jsp">Relatório de Venda</a>
                </li>
                <li id="relLog" type="hidden">
                    <a href="../../Relatorio/relatorioLog_falta/relatorioLog.jsp">Relatório de Log</a>
                </li>
            </ul>
        </div>

        <div id="subUsuario" class="sub">
            <ul class="submenu">
                <li>
                    <a href="../../Funcionario/Cadastrar/funcionarioCadastrar.jsp">Cadastrar Funcionário</a>
                </li>
                <li>
                    <a href="../../Funcionario/Consultar/clienteConsultar.jsp">Consultar Funcionário</a>
                </li>
            </ul>
        </div>

    </body>
</html>
