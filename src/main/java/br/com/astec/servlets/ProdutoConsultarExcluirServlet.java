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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author r.almeida.barbosa
 */
@WebServlet(name = "ProdutoConsultarExcluirServlet", urlPatterns = {"/ProdutoConsultarExcluirServletConsulta",
    "/ProdutoConsultarExcluirServletAlteracao", "/ProdutoConsultarExcluirServletExclusao"})
//"/ProdutoConsultarExcluirServletAltExc"})
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
        } 
        
        else if (request.getServletPath().equalsIgnoreCase("/ProdutoConsultarExcluirServletExclusao")) {
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

        } 
        
        //consulta não mudarei por enquanto
        else if (request.getServletPath().equalsIgnoreCase("/ProdutoConsultarExcluirServletConsulta")) {

            //String nome = request.getParameter("nomeProduto");
            //HttpSession sessao = request.getSession();
            //sessao.setAttribute("novaConsulta", nome);
            //request.setAttribute("novaConsulta", nome);
            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("telas/Produto/ConsultarExcluir/respostaConsulta/respostaConsultarExcluir.jsp");
            dispatcher.forward(request, response);
        }

    }

}
