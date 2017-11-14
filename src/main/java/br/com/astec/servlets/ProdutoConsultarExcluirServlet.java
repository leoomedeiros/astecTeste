/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.astec.servlets;

import br.com.astec.model.dao.ProdutoDao;
import br.com.astec.model.entidades.Produto;
import java.io.IOException;
import java.io.PrintWriter;
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

        if (request.getServletPath().equalsIgnoreCase("/ProdutoConsultarExcluirServletAlteracao")) {
            String temporario = request.getParameter("inserirCodigo");
            int codigoAltExc = Integer.parseInt(temporario);

            HttpSession sessao = request.getSession();
            sessao.setAttribute("codigoAltExc", codigoAltExc);
            //sessao.setAttribute("produtoConsultado", consultado);

            try {
                //if (codigoAltExc == codigoBanco){
                ProdutoDao consultarCodigo = new ProdutoDao();
                consultarCodigo.consultarPorId(codigoAltExc);
                Produto atributosProduto = consultarCodigo.consultarPorId(codigoAltExc);
                sessao.setAttribute("produtoConsultado", atributosProduto);
                //}
            } catch (Exception ex) {
                Logger.getLogger(ProdutoCadastrarServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {

            } catch (Exception ex) {
                Logger.getLogger(ProdutoConsultarExcluirServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("telas/Produto/ConsultarExcluir/respostaAlteracao/respostaConsultarExcluirAlteracao.jsp");
            dispatcher.forward(request, response);

        } else if (request.getServletPath().equalsIgnoreCase("/ProdutoAlteracaoSalvar")) {
            //String temporario = request.getParameter("inserirCodigo");
            //int codigoAltExc = Integer.parseInt(temporario);

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
            int codigoAltExc = (Integer)sessao.getAttribute("codigoAltExc");
            //Session codigoAltExc = (Session)sessao.getAttribute("codigoAltExc");
            //sessao.setAttribute("codigoAltExc", codigoAltExc);
            
            //Integer.parseInt("codigoAltExc");
            

            try {
                ProdutoDao salvarAlteracao = new ProdutoDao();
                salvarAlteracao.alterar(novo, codigoAltExc);

                Produto atributosProduto = salvarAlteracao.alterar(novo, codigoAltExc);
                sessao.setAttribute("produtoConsultado", atributosProduto);
            } catch (Exception e) {
                Logger.getLogger(ProdutoConsultarExcluirServlet.class.getName()).log(Level.SEVERE, null, e);
            }

            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("telas/Produto/ConsultarExcluir/respostaAlteracao/respostaProdutoAlterado.jsp");
            dispatcher.forward(request, response);

        } else if (request.getServletPath().equalsIgnoreCase("/ProdutoConsultarExcluirServletExclusao")) {
            String temporario = request.getParameter("inserirCodigo");
            int codigoExclusao = Integer.parseInt(temporario);

            HttpSession sessao = request.getSession();
            sessao.setAttribute("codigoAltExc", codigoExclusao);

            //sessao.setAttribute("produtoConsultado", consultado);
            try {
                //if (codigoAltExc == codigoBanco){
                //consultando para saber se o código resgata do banco
                ProdutoDao excluir = new ProdutoDao();
                //consultarCodigo.consultarPorId(codigoAltExc);
                //recuperando os dados do produto
                Produto atributosProduto = excluir.consultarPorId(codigoExclusao);
                sessao.setAttribute("produtoConsultado", atributosProduto);
                excluir.remover(codigoExclusao);
                //}
            } catch (Exception ex) {
                Logger.getLogger(ProdutoCadastrarServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {

            } catch (Exception ex) {
                Logger.getLogger(ProdutoConsultarExcluirServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/telas/Produto/ConsultarExcluir/respostaExclusao/respostaConsultarExcluirExclusao.jsp");
            dispatcher.forward(request, response);

        } //consulta não mudarei por enquanto
        else if (request.getServletPath().equalsIgnoreCase("/ProdutoConsultarExcluirServletConsulta")) {

            /*String nome = request.getParameter("nomeProduto");
            HttpSession sessao = request.getSession();
            sessao.setAttribute("novaConsulta", nome);
            request.setAttribute("novaConsulta", nome);*/
            
            String temporario = request.getParameter("nomeProduto");
            int codigoAltExc = Integer.parseInt(temporario);

            HttpSession sessao = request.getSession();
            sessao.setAttribute("codigoAltExc", codigoAltExc);
            //sessao.setAttribute("produtoConsultado", consultado);

            try {
                //if (codigoAltExc == codigoBanco){
                ProdutoDao consultarCodigo = new ProdutoDao();
                consultarCodigo.consultarPorId(codigoAltExc);
                Produto atributosProduto = consultarCodigo.consultarPorId(codigoAltExc);
                sessao.setAttribute("produtoConsultado", atributosProduto);
                //}
            } catch (Exception ex) {
                Logger.getLogger(ProdutoCadastrarServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {

            } catch (Exception ex) {
                Logger.getLogger(ProdutoConsultarExcluirServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            
            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("telas/Produto/ConsultarExcluir/respostaConsulta/respostaConsultarExcluir.jsp");
            dispatcher.forward(request, response);
        }

    }

}
