/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Date;
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
@WebServlet(urlPatterns = {"/produtoCadastrarServlet"})
public class produtoCadastrarServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession sessao = request.getSession();
        Produto novo = (Produto) sessao.getAttribute("novoProduto");
        String destino;
        if (novo != null) {
            request.setAttribute("novoProd", novo);
            sessao.removeAttribute("novoProd");
            destino = "resposta.jsp";
        } else { // usuario acessou normalmente
            destino = "formulario.jsp";
        }
        RequestDispatcher dispatcher
                = request.getRequestDispatcher(destino);
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nomeProduto = request.getParameter("nomeProduto");
        String categoria = request.getParameter("categoria");
        Long tamanho = Long.parseLong(request.getParameter("tamanho"));
        double preco = Double.parseDouble(request.getParameter("preco"));
        int codigoProduto = Integer.parseInt(request.getParameter("codigoProduto"));
        int codigoBanco = Integer.parseInt(request.getParameter("codigoBanco"));
        String cor = request.getParameter("cor");
        int quantidade = Integer.parseInt(request.getParameter("quantidade"));
        String descricao = request.getParameter("descricao");

        Produto novo = new Produto(codigoProduto, codigoBanco, nomeProduto, descricao, BigDecimal.valueOf(preco),
                BigDecimal.valueOf(tamanho), categoria, cor, quantidade, new Date());

        HttpSession sessao = request.getSession();
        sessao.setAttribute("novoProduto", novo);

        response.sendRedirect(request.getContextPath() + "/produtoCadastrarServlet");

    }

}
