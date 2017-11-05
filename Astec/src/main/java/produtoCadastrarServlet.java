/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import br.com.astec.db.dao.DaoProduto;
import br.com.astec.model.produto.Produto;
import java.io.IOException;
import java.*;
import java.security.Timestamp;
import java.text.DateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
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
 * @author rafael.abarbosa1
 */
@WebServlet(name = "produtoCadastrarServlet", urlPatterns = {"/produtoCadastrarServlet"})
public class produtoCadastrarServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession sessao = request.getSession();
        Produto novo = (Produto) sessao.getAttribute("novoProduto");
        String destino;
        if (novo != null) {
            request.setAttribute("novoProd", novo);

            sessao.removeAttribute("novoProd");
            destino = "respostaCadastroProduto.jsp";
        } else { // usuario acessou normalmente
            destino = "produtoCadastar.jsp";
        }
        RequestDispatcher dispatcher
                = request.getRequestDispatcher(destino);
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        java.util.Date utilDate = new java.util.Date();
        java.sql.Timestamp sq = new java.sql.Timestamp(utilDate.getTime());

        String nomeProduto = request.getParameter("nomeProduto");
        String categoria = request.getParameter("categoria");
        int tamanho = Integer.parseInt(request.getParameter("tamanho"));
        double preco = Double.parseDouble(request.getParameter("preco"));
        String cor = request.getParameter("cor");
        int quantidade = Integer.parseInt(request.getParameter("quantidade"));
        String descricao = request.getParameter("descricao");
        int codigoProduto = 01;
        int codigoBanco = 02;

        Produto novo = new Produto(codigoBanco, sq, nomeProduto, codigoProduto,
                categoria, cor, tamanho, quantidade, descricao, preco);

        HttpSession sessao = request.getSession();
        sessao.setAttribute("novoProduto", novo);

        try {
            DaoProduto produto = new DaoProduto();
            produto.inserir(novo);
        } catch (Exception ex) {
            Logger.getLogger(produtoCadastrarServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {

        } catch (Exception ex) {
            Logger.getLogger(produtoCadastrarServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        response.sendRedirect(request.getContextPath() + "/produtoCadastrarServlet");

    }
    

}
