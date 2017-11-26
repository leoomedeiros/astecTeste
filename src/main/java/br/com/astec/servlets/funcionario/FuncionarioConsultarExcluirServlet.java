/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.astec.servlets.funcionario;


import br.com.astec.model.dao.funcionario.FuncionarioDao;
import br.com.astec.model.entidades.Funcionario;
import br.com.astec.model.entidades.ValidarFuncionario;
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
 * @author Felipe
 */
@WebServlet(name = "FuncionarioConsultarExcluirServlet", urlPatterns = {
    "/FuncionarioConsulta", "/FuncionarioAlterar",
    "/FuncionarioExcluir","/FuncionarioAlteracaoSalvar"})

public class FuncionarioConsultarExcluirServlet extends HttpServlet {

    java.util.Date utilDate = new java.util.Date();
    java.sql.Timestamp sq = new java.sql.Timestamp(utilDate.getTime());

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        FuncionarioDao funcionarioDao = new FuncionarioDao();
        
        ////////////////////////////////////////////////////////////////////////
        //Excluir
            if (request.getServletPath().equalsIgnoreCase("/FuncionarioExcluir")) {//faz a exclusão no banco
            String temporario = request.getParameter("inserirCodigo");
            int codigoExclusao = Integer.parseInt(temporario);

            HttpSession sessao = request.getSession();
            sessao.setAttribute("codigoAltExc", codigoExclusao);

            try {
                List<Funcionario> atributosFuncionario = FuncionarioDao.consultarPorId(codigoExclusao);
                if (!atributosFuncionario.isEmpty()) {
                    for (Funcionario funcionario : atributosFuncionario) {
                        sessao.setAttribute("FuncionarioConsultado", funcionario);
                    }
                    FuncionarioDao.remover(codigoExclusao);
                    response.sendRedirect("telas/Funcionario/Excluir/respostaFuncionarioExcluido.jsp");

                } else {
                    response.sendRedirect("telas/Produto/MensagemErro.jsp");
                }

            } catch (Exception ex) {
                Logger.getLogger(FuncionarioCadastrarServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {

            } catch (Exception ex) {
                Logger.getLogger(FuncionarioConsultarExcluirServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        
        
        ////////////////////////////////////////////////////////////////////////
        //Update
        if (request.getServletPath().equalsIgnoreCase("/FuncionarioAlteracaoSalvar")) {//esta path é o SEGUNDO direcionamento vindo do form.

            String nome = request.getParameter("nome");
            String usuario = request.getParameter("usuario");
            String depart = request.getParameter("slcDepar");
            //int iDepart = Integer.parseInt(depart);
            String filial = request.getParameter("slcFilial");
            //int iFilial = Integer.parseInt(filial);
            String cargo = request.getParameter("cargo");
            String senha = request.getParameter("senha");

            Funcionario novoFuncionario = new Funcionario(sq, nome, usuario,
                    depart, filial, cargo, senha);

            HttpSession sessao = request.getSession();
            sessao.setAttribute("FuncionarioAlterado", novoFuncionario);
            int codigoAltExc = (Integer) sessao.getAttribute("codigoAltExc");

            ValidarFuncionario validar = new ValidarFuncionario();
            boolean valido = validar.ehPalavra(novoFuncionario);

            if (valido) {

                try {
                    FuncionarioDao.alterar(novoFuncionario, codigoAltExc);

                    Funcionario atributosFuncionario = FuncionarioDao.alterar(novoFuncionario, codigoAltExc);
                    sessao.setAttribute("FuncionarioConsultado", atributosFuncionario);
                } catch (Exception e) {
                    Logger.getLogger(FuncionarioConsultarExcluirServlet.class.getName()).log(Level.SEVERE, null, e);
                }

                response.sendRedirect("telas/Funcionario/Alterar/respostaFuncionarioAlterado.jsp");

            } else {
                response.sendRedirect("telas/Produto/MensagemErro.jsp");
            }
        }

        ////////////////////////////////////////////////////////////////////////
        //Pré Update
        if (request.getServletPath().equalsIgnoreCase("/FuncionarioAlterar")) {//esta path é o primeiro direcionamento vindo do form
            String temporario = request.getParameter("inserirCodigo");
            int codigoAltExc = Integer.parseInt(temporario);

            HttpSession sessao = request.getSession();
            sessao.setAttribute("codigoAltExc", codigoAltExc);

            try {
                List<Funcionario> atributosFuncionario = FuncionarioDao.consultarPorId(codigoAltExc);
                if (!atributosFuncionario.isEmpty()) {
                    for (Funcionario c : atributosFuncionario) {
                        sessao.setAttribute("FuncionarioConsultado", c);
                        response.sendRedirect("telas/Funcionario/Alterar/respostaAlterar.jsp");
                    }
                } else {
                    response.sendRedirect("telas/Produto/MensagemErro.jsp");
                }
            } catch (Exception ex) {
                Logger.getLogger(FuncionarioCadastrarServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {

            } catch (Exception ex) {
                Logger.getLogger(FuncionarioConsultarExcluirServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        ////////////////////////////////////////////////////////////////////////
        if (request.getServletPath().equalsIgnoreCase("/FuncionarioConsulta")) {
            //buscar

            String inputConsulta = request.getParameter("nomeFuncionario");
            String selectConsulta = request.getParameter("selectConsulta");

            HttpSession sessao = request.getSession();
            List<Funcionario> listaFuncionarios;

            if (inputConsulta.isEmpty() || selectConsulta.equalsIgnoreCase("todos")) {
               
                try {
                    listaFuncionarios = FuncionarioDao.consultarTodos();
                    if (!listaFuncionarios.isEmpty()) {
                        sessao.setAttribute("listaFuncionarios", listaFuncionarios);
                        response.sendRedirect("telas/Funcionario/Consultar/respostaConsulta/respostaConsultar.jsp");
                    } else {
                        response.sendRedirect("telas/home/home.jsp");
                    }

                } catch (Exception e) {
                    Logger.getLogger(FuncionarioConsultarExcluirServlet.class.getName()).log(Level.SEVERE, null, e);
                }

            }else if (selectConsulta.equalsIgnoreCase("nome")) {
               
                try {
                    listaFuncionarios = FuncionarioDao.consultarPorNome(inputConsulta);
                    if (!listaFuncionarios.isEmpty()) {
                        sessao.setAttribute("listaFuncionarios", listaFuncionarios);
                        response.sendRedirect("telas/Funcionario/Consultar/respostaConsulta/respostaConsultar.jsp");
                    } else {
                        response.sendRedirect("telas/home/home.jsp");
                    }

                } catch (Exception e) {
                    Logger.getLogger(FuncionarioConsultarExcluirServlet.class.getName()).log(Level.SEVERE, null, e);
                }

        }

    }
}
}

