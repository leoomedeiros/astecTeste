package br.com.astec.servlets;

import br.com.astec.model.dao.ProdutoDao;
import br.com.astec.model.entidades.Produto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

/**
 *
 * @author r.almeida.barbosa
 */
@WebServlet(name = "ProdutoConsultarExcluirServlet", urlPatterns = {"/ProdutoConsultarExcluirServletConsulta",
    "/ProdutoConsultarExcluirServletAlteracao", "/ProdutoConsultarExcluirServletExclusao",
    "/ProdutoAlteracaoSalvar"})

public class ProdutoConsultarExcluirServlet extends HttpServlet {

    java.util.Date utilDate = new java.util.Date();
    java.sql.Timestamp sq = new java.sql.Timestamp(utilDate.getTime());

    /*@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }*/
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProdutoDao produtoDao = new ProdutoDao();

        if (request.getServletPath().equalsIgnoreCase("/ProdutoConsultarExcluirServletAlteracao")) {//esta path é o primeiro direcionamento vindo do form
            String temporario = request.getParameter("inserirCodigo");
            int codigoAltExc = Integer.parseInt(temporario);

            HttpSession sessao = request.getSession();
            sessao.setAttribute("codigoAltExc", codigoAltExc);

            try {
                List<Produto> atributosProduto = produtoDao.consultarPorId(codigoAltExc);
                if (!atributosProduto.isEmpty()) {
                    for (Produto c : atributosProduto) {
                        sessao.setAttribute("produtoConsultado", c);
                        response.sendRedirect("telas/Produto/ConsultarExcluir/respostaAlteracao/respostaConsultarExcluirAlteracao.jsp");
                    }
                } else {
                    response.sendRedirect("telas/Produto/MensagemErro.jsp");
                }
            } catch (Exception ex) {
                Logger.getLogger(ProdutoCadastrarServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {

            } catch (Exception ex) {
                Logger.getLogger(ProdutoConsultarExcluirServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            //response.sendRedirect("telas/Produto/ConsultarExcluir/respostaAlteracao/respostaConsultarExcluirAlteracao.jsp");

            /*RequestDispatcher dispatcher
                    = request.getRequestDispatcher("telas/Produto/ConsultarExcluir/respostaAlteracao/respostaConsultarExcluirAlteracao.jsp");
            dispatcher.forward(request, response);*/
        } else if (request.getServletPath().equalsIgnoreCase("/ProdutoAlteracaoSalvar")) {//esta path é o SEGUNDO direcionamento vindo do form.

            String nomeProduto = request.getParameter("nomeProduto");
            String categoria = request.getParameter("categoria");
            int tamanho = Integer.parseInt(request.getParameter("tamanho"));
            double preco = Double.parseDouble(request.getParameter("preco"));
            String cor = request.getParameter("cor");
            int quantidade = Integer.parseInt(request.getParameter("quantidade"));
            String descricao = request.getParameter("descricao");

            Produto novo = new Produto(sq, nomeProduto, categoria, cor, tamanho,
                    quantidade, descricao, preco);

            HttpSession sessao = request.getSession();
            sessao.setAttribute("produtoAlterado", novo);
            int codigoAltExc = (Integer) sessao.getAttribute("codigoAltExc");

            try {
                //ProdutoDao salvarAlteracao = new ProdutoDao();
                produtoDao.alterar(novo, codigoAltExc);

                Produto atributosProduto = produtoDao.alterar(novo, codigoAltExc);
                sessao.setAttribute("produtoConsultado", atributosProduto);
            } catch (Exception e) {
                Logger.getLogger(ProdutoConsultarExcluirServlet.class.getName()).log(Level.SEVERE, null, e);
            }

            response.sendRedirect("telas/Produto/ConsultarExcluir/respostaAlteracao/respostaProdutoAlterado.jsp");

            /*RequestDispatcher dispatcher
                    = request.getRequestDispatcher("telas/Produto/ConsultarExcluir/respostaAlteracao/respostaProdutoAlterado.jsp");
            dispatcher.forward(request, response);*/
        } else if (request.getServletPath().equalsIgnoreCase("/ProdutoConsultarExcluirServletExclusao")) {//faz a exclusão no banco
            String temporario = request.getParameter("inserirCodigo");
            int codigoExclusao = Integer.parseInt(temporario);

            HttpSession sessao = request.getSession();
            sessao.setAttribute("codigoAltExc", codigoExclusao);

            try {
                List<Produto> atributosProduto = produtoDao.consultarPorId(codigoExclusao);
                if (!atributosProduto.isEmpty()) {
                    for (Produto c : atributosProduto) {
                        sessao.setAttribute("produtoConsultado", c);
                        response.sendRedirect("telas/Produto/ConsultarExcluir/respostaExclusao/respostaConsultarExcluirExclusao.jsp");
                    }
                } else {
                    response.sendRedirect("telas/Produto/MensagemErro.jsp");
                }

            } catch (Exception ex) {
                Logger.getLogger(ProdutoCadastrarServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {

            } catch (Exception ex) {
                Logger.getLogger(ProdutoConsultarExcluirServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            //response.sendRedirect("telas/Produto/ConsultarExcluir/respostaExclusao/respostaConsultarExcluirExclusao.jsp");

            /*RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/telas/Produto/ConsultarExcluir/respostaExclusao/respostaConsultarExcluirExclusao.jsp");
            dispatcher.forward(request, response);*/
            
        } else if (request.getServletPath().equalsIgnoreCase("/ProdutoConsultarExcluirServletConsulta")) {//primeiro direcionamento vindo do form "buscar"

            String inputConsulta = request.getParameter("nomeProduto");
            String selectConsulta = request.getParameter("selectConsulta");

            HttpSession sessao = request.getSession();
            List<Produto> listaProdutos;

            if (inputConsulta.isEmpty() || selectConsulta.equalsIgnoreCase("todos")) {//se o input estiver "vazio" ou se o select estiver com "todos" selecionado
                //retornar todos os produtos no banco 
                try {
                    listaProdutos = produtoDao.consultarTodos();
                    if (!listaProdutos.isEmpty()) {
                            sessao.setAttribute("listaProdutos", listaProdutos);
                            response.sendRedirect("telas/Produto/ConsultarExcluir/respostaConsulta/respostaConsultarExcluir.jsp");
                    } else {
                        response.sendRedirect("telas/Produto/MensagemErro.jsp");
                    }

                } catch (Exception e) {
                    Logger.getLogger(ProdutoConsultarExcluirServlet.class.getName()).log(Level.SEVERE, null, e);
                }

            } else if (selectConsulta.equalsIgnoreCase("nome")) {//se o select estiver com "nome" selecionado.
                //filtrar pelo nome do produto
                try {
                    listaProdutos = produtoDao.consultarPorNome(inputConsulta);
                    if (!listaProdutos.isEmpty()) {
                            sessao.setAttribute("listaProdutos", listaProdutos);
                            response.sendRedirect("telas/Produto/ConsultarExcluir/respostaConsulta/respostaConsultarExcluir.jsp");
                    } else {
                        response.sendRedirect("telas/Produto/MensagemErro.jsp");
                    }

                } catch (Exception ex) {
                    Logger.getLogger(ProdutoConsultarExcluirServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            //response.sendRedirect("telas/Produto/ConsultarExcluir/respostaConsulta/respostaConsultarExcluir.jsp");

            /*RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/telas/Produto/ConsultarExcluir/respostaConsulta/respostaConsultarExcluir.jsp");
            dispatcher.forward(request, response);*/
        }

    }

}
