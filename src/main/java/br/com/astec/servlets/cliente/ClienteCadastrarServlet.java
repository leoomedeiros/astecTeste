/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.astec.servlets.cliente;

import br.com.astec.model.dao.cliente.ClienteDao;
import br.com.astec.model.entidades.Cliente;
import br.com.astec.model.entidades.ValidarCliente;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "ClienteCadastrarServlet", urlPatterns = {"/ClienteCadastrarServlet"})
public class ClienteCadastrarServlet extends HttpServlet {

    java.util.Date utilDate = new java.util.Date();
    java.sql.Timestamp sq = new java.sql.Timestamp(utilDate.getTime());
    boolean camposValidos = false;
    
    
   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession sessao = request.getSession();
        Cliente novo = (Cliente) sessao.getAttribute("novoCliente");
        String destino;
        if (novo != null) {
            request.setAttribute("novoCli", novo);

            sessao.removeAttribute("novoCli");
            destino = "telas/Cliente/Cadastrar/respostaCadastrarCliente.jsp";
        } else { // usuario acessou normalmente
            destino = "telas/Cliente/Cadastrar/clienteCadastar.jsp";
        }

        response.sendRedirect(destino);
        /*RequestDispatcher dispatcher
                = request.getRequestDispatcher(destino);
        dispatcher.forward(request, response);*/

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        

    
        String nomeCliente = request.getParameter("nomeCliente");
        String cpfCliente = request.getParameter("cpf");
        String enderecoCliente = request.getParameter("endereco");
        String telefoneCliente = request.getParameter("telefone");

        if(cpfCliente.equals("")){
            cpfCliente = "não informado";
        }
        if(telefoneCliente.equals("")){
            cpfCliente = "não informado";
        }
        
        Cliente novoCliente = new Cliente(Integer.SIZE, sq, nomeCliente, 
                cpfCliente, enderecoCliente, telefoneCliente);

        HttpSession sessao = request.getSession();
        sessao.setAttribute("novoCliente", novoCliente);
        
        ValidarCliente validarCliente = new ValidarCliente();
        boolean valido = validarCliente.ehPalavra(novoCliente);

        if (valido) {

            try {
                
                ClienteDao cliente = new ClienteDao();
                cliente.incluir(novoCliente);

            } catch (Exception ex) {
                Logger.getLogger(ClienteCadastrarServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {

            } catch (Exception ex) {
                Logger.getLogger(ClienteCadastrarServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            response.sendRedirect(request.getContextPath() + "/ClienteCadastrarServlet");
        } else {
            response.sendRedirect("telas/Cliente/Erro/erroClienteCadastrar.jsp");

        }

    }


}
