/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.astec.servlets;

import br.com.astec.model.dao.DaoCliente;
import br.com.astec.model.entidades.Cliente;
import java.io.IOException;
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
 * @author Fernando
 */
@WebServlet(name = "CadastrarCliente", urlPatterns = {"/ServletCadastrarCliente"})
public class ServletCadastrarCliente extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession sessao = request.getSession();
        Cliente novoCliente = (Cliente) sessao.getAttribute("novoCliente");
        String destino;
        if (novoCliente != null) {
            request.setAttribute("novoCliente", novoCliente);

            sessao.removeAttribute("novoCliente");
            destino = "respostaCadastroProduto.jsp";
        } else { // usuario acessou normalmente
            destino = "clienteCadastar.jsp";
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

        String nomeCliente = request.getParameter("nomeCliente");
        String cpf = request.getParameter("cpf");
        String endereco = request.getParameter("endereco");
        String telefone = request.getParameter("telefone");

        Cliente novoCliente = new Cliente(sq, nomeCliente, cpf, endereco, telefone);

        HttpSession sessao = request.getSession();
        sessao.setAttribute("novoCliente", novoCliente);

        try {
            DaoCliente cliente = new DaoCliente();
            cliente.incluir(novoCliente);
        } catch (Exception ex) {
            Logger.getLogger(ProdutoCadastrarServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {

        } catch (Exception ex) {
            Logger.getLogger(ServletCadastrarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }

        response.sendRedirect(request.getContextPath() + "/CadastrarCliente");

    }

}
