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
import java.util.List;
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
@WebServlet(name = "ClienteConsultarExcluirServlet", urlPatterns = {
    "/ClienteConsulta", "/ClienteAlterar",
    "/ClienteExcluir","/ClienteAlteracaoSalvar"})

public class ClienteConsultarExcluirServlet extends HttpServlet {

    java.util.Date utilDate = new java.util.Date();
    java.sql.Timestamp sq = new java.sql.Timestamp(utilDate.getTime());

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ClienteDao clienteDao = new ClienteDao();
        
        ////////////////////////////////////////////////////////////////////////
        
        if (request.getServletPath().equalsIgnoreCase("/ClienteExcluir")) {//faz a exclusão no banco
            String temporario = request.getParameter("inserirCodigo");
            int codigoExclusao = Integer.parseInt(temporario);

            HttpSession sessao = request.getSession();
            sessao.setAttribute("codigoAltExc", codigoExclusao);

            try {
                List<Cliente> atributosCliente = clienteDao.consultarPorId(codigoExclusao);
                if (!atributosCliente.isEmpty()) {
                    for (Cliente cliente : atributosCliente) {
                        sessao.setAttribute("clienteConsultado", cliente);
                    }
                    clienteDao.remover(codigoExclusao);
                    response.sendRedirect("telas/Cliente/Excluir/respostaClienteExcluido.jsp");

                } else {
                    response.sendRedirect("telas/Cliente/Erro/erroClienteExcluir.jsp");
                }

            } catch (Exception ex) {
                Logger.getLogger(ClienteCadastrarServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {

            } catch (Exception ex) {
                Logger.getLogger(ClienteConsultarExcluirServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        
        
        ////////////////////////////////////////////////////////////////////////
        //Update
        if (request.getServletPath().equalsIgnoreCase("/ClienteAlteracaoSalvar")) {//esta path é o SEGUNDO direcionamento vindo do form.

            String nomeCliente = request.getParameter("nomeCliente");
            String cpfCliente = request.getParameter("cpf");
            String enderecoCliente = request.getParameter("endereco");
            String telefoneCliente = request.getParameter("telefone");

            Cliente novoCliente = new Cliente(Integer.SIZE, sq, nomeCliente,
                    cpfCliente, enderecoCliente, telefoneCliente);

            HttpSession sessao = request.getSession();
            sessao.setAttribute("clienteAlterado", novoCliente);
            int codigoAltExc = (Integer) sessao.getAttribute("codigoAltExc");

            ValidarCliente validar = new ValidarCliente();
            boolean valido = validar.ehPalavra(novoCliente);

            if (valido) {

                try {
                    clienteDao.alterar(novoCliente, codigoAltExc);

                    Cliente atributosCliente = clienteDao.alterar(novoCliente, codigoAltExc);
                    sessao.setAttribute("clienteConsultado", atributosCliente);
                } catch (Exception e) {
                    Logger.getLogger(ClienteConsultarExcluirServlet.class.getName()).log(Level.SEVERE, null, e);
                }

                response.sendRedirect("telas/Cliente/Alterar/respostaClienteAlterado.jsp");

            } else {
                response.sendRedirect("telas/Cliente/Erro/erroClienteAlterar.jsp");
            }
        }

        ////////////////////////////////////////////////////////////////////////
        if (request.getServletPath().equalsIgnoreCase("/ClienteAlterar")) {//esta path é o primeiro direcionamento vindo do form
            String temporario = request.getParameter("inserirCodigo");
            int codigoAltExc = Integer.parseInt(temporario);

            HttpSession sessao = request.getSession();
            sessao.setAttribute("codigoAltExc", codigoAltExc);

            try {
                List<Cliente> atributosCliente = clienteDao.consultarPorId(codigoAltExc);
                if (!atributosCliente.isEmpty()) {
                    for (Cliente c : atributosCliente) {
                        sessao.setAttribute("clienteConsultado", c);
                        response.sendRedirect("telas/Cliente/Alterar/respostaAlterar.jsp");
                    }
                } else {
                    response.sendRedirect("telas/Cliente/Erro/erroClienteAlterar");
                }
            } catch (Exception ex) {
                Logger.getLogger(ClienteCadastrarServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {

            } catch (Exception ex) {
                Logger.getLogger(ClienteConsultarExcluirServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        ////////////////////////////////////////////////////////////////////////
        if (request.getServletPath().equalsIgnoreCase("/ClienteConsulta")) {
            //buscar

            String inputConsulta = request.getParameter("nomeCliente");
            String selectConsulta = request.getParameter("selectConsulta");

            HttpSession sessao = request.getSession();
            List<Cliente> listaClientes;

            if (inputConsulta.isEmpty() || selectConsulta.equalsIgnoreCase("todos")) {
               
                try {
                    listaClientes = clienteDao.consultarTodos();
                    if (!listaClientes.isEmpty()) {
                        sessao.setAttribute("listaClientes", listaClientes);
                        response.sendRedirect("telas/Cliente/Consultar/respostaConsulta/respostaConsultar.jsp");
                    } else {
                        response.sendRedirect("telas/Cliente/Erro/erroClienteConsultar");
                    }

                } catch (Exception e) {
                    Logger.getLogger(ClienteConsultarExcluirServlet.class.getName()).log(Level.SEVERE, null, e);
                }

            }

        }

    }
}
