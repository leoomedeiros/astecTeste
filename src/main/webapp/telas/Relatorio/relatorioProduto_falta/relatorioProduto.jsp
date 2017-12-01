<%-- 
    Document   : relatorioProduto
    Created on : 23/11/2017, 01:36:28
    Author     : Usuário
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<%@page import="br.com.astec.model.entidades.LogFuncionario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Relatório de Produto</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="relatorioProduto.css" rel="stylesheet">
        <script src="relatorioProduto.js" type="text/javascript"></script>
    </head>
    <body>
        <div id="direito">
            <div id="cabecalho">
                <!--<img class="logo" src="https://i.imgur.com/mgK1d4U.jpg"/> -->
                <img class="logo" src="http://i65.tinypic.com/2uenpch.png"/>
                <h1>Relatório de Produto:</h1>
                    
                
            </div>
            
            <div id="conteudo">
                <form class="pesquisa" action="${pageContext.request.contextPath}/RelatorioProdutoServlet" method="POST">  
                    <div id="contEsq" class="divisoria">
                        <h4>Data inicial:<br></h4>
                        <input type="date" name="dataIni" placeholder="dd-mm-aaaa"><br>

                        
                    </div>

                    <div id="contDir" class="divisoria">
                        <h4>Data Final:</h4>    
                        <input type="date" name="dataFin" placeholder="dd-mm-aaaa"><br>
                            
                    </div>
                    
                    <input class="botao" name="buscar" type="submit" value="Buscar">
                    
                    
                </form>
                <div class="divTabela">
                        <table>
                                <tr>
                                    <th>Cod. Log:</th>
                                    <th>Cod. Usuário:</th>
                                    <th>Nome do Produto:</th>
                                    <th>Cod. Produto:</th>
                                    <th>Ação:</th>
                                    <th>Data/Hora:</th>
                                    <th>Quant. efetuada:</th>
                                </tr>
                                <c:forEach items="${sessionScope.listaLogProduto}" var="listaLogProduto" >
                                <tr class="linhas">
                                    <td>${listaLogProduto.id}</td>
                                    <td>${listaLogProduto.idFunc}</td>
                                    <td>${listaLogProduto.nomeTabela}</td>
                                    <td>${listaLogProduto.idItem}</td>
                                    <td>${listaLogProduto.acao}</td>
                                    <td>${listaLogProduto.dataAcao}</td>
                                    <td>${listaLogProduto.qntd}</td>
                                </tr>
                                </c:forEach>


                            </table>
                </div>
                <form class="pesquisa" action="${pageContext.request.contextPath}/ExportRelatorioLogProdutoServlet" method="POST">
                    <h4>DE:
                    <input type="text" name="expDtI" value="<%=session.getAttribute("dtInicio")%>" disabled="true">
                    ATÉ:
                    <input type="text" name="expDtF" value="<%=session.getAttribute("dtFim")%>" disabled="true"></h4>
                    
                    <button class="botao"
                            name="Export"
                            type="submit">Exportar</button>
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
                    <a href="../../Venda/venda.js">Venda</a>                    
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
                            <a href="relatorioProduto.jsp">Relatório de Produto</a>
                        </li>
                        <li id="relVenda" type="hidden">
                            <a href="../RelatorioVenda/relatorioVenda.jsp">Relatório de Venda</a>
                        </li>
                        <li id="relLog" type="hidden">
                            <a href="../RelatorioLog_falta/relatorioLog.jsp">Relatório de Log</a>
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

		</div>       
    </body>
</html>