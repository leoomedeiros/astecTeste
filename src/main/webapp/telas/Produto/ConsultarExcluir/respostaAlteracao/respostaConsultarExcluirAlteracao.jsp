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
                <!--<img class="logo" src="https://i.imgur.com/mgK1d4U.jpg"/> -->
                <img class="logo" src="http://i65.tinypic.com/2uenpch.png"/>
                <h1>Alteração</h1>


            </div>

            <div id="conteudo">
                <form action="${pageContext.request.contextPath}/ProdutoAlteracaoSalvar" method="post">  
                    <div id="contEsq" class="divisoria">
                        <h4>*Nome do Produto:<br></h4>
                        <input type="text" name="nomeProduto" value="${sessionScope.produtoConsultado.nomeProduto}"><br>

                        <h4>*Categoria:<br></h4>
                        <input type="text" name="categoria" value="${sessionScope.produtoConsultado.categoria}"><br>

                        <h4>*Tamanho:<br></h4>
                        <input type="number" name="tamanho" value="${sessionScope.produtoConsultado.tamanho}"><br>

                        <h4>*Preço:<br></h4>
                        <input type="number" name="preco" step="0.01" value="${sessionScope.produtoConsultado.preco}"><br>
                    </div>

                    <div id="contDir" class="divisoria">
                            <h4>*Cor:<br></h4>
                            <input type="text" name="cor" value="${sessionScope.produtoConsultado.cor}"><br>
                            
                            <h4>*Quantidade:<br></h4>
                            <input type="number" name="quantidade" value="${sessionScope.produtoConsultado.quantidade}"><br>
                            
                            <h4>*Descrição:<br></h4>
                            <input type="text" name="descricao" value="${sessionScope.produtoConsultado.descricao}"><br>

                            <a>*campos obrigatórios</a>
                    </div>


                    <input name="enviar" type="submit" value="Salvar">


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
                    <a href="#">Usuários</a>

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
