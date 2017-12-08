/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.astec.servlets.funcionario;

import br.com.astec.model.constants.LogAcao;
import br.com.astec.model.dao.LogDao;
import br.com.astec.servlets.funcionario.*;
import br.com.astec.model.dao.funcionario.FuncionarioDao;
import br.com.astec.model.entidades.Funcionario;
import br.com.astec.model.entidades.LogFuncionario;
import br.com.astec.model.entidades.ValidarFuncionario;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "FuncionarioCadastrarServlet", urlPatterns = {"/FuncionarioCadastrarServlet"})
public class FuncionarioCadastrarServlet extends HttpServlet {

    java.util.Date utilDate = new java.util.Date();
    java.sql.Timestamp sq = new java.sql.Timestamp(utilDate.getTime());
    boolean camposValidos = false;
    
    
   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession sessao = request.getSession();
        Funcionario novo = (Funcionario) sessao.getAttribute("novoFuncionario");
        String destino;
        if (novo != null) {
            request.setAttribute("novoFunc", novo);

            sessao.removeAttribute("novoFunc");
            destino = "telas/Funcionario/Cadastrar/respostaCadastrarFuncionario.jsp";
        } else { // usuario acessou normalmente
            destino = "telas/Funcionario/Cadastrar/funcionarioCadastrar.jsp";
        }

        response.sendRedirect(destino);
        /*RequestDispatcher dispatcher
                = request.getRequestDispatcher(destino);
        dispatcher.forward(request, response);*/

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        

    
        String nome = request.getParameter("nome");
        String usuario = request.getParameter("usuario");
        String depart = request.getParameter("slcDepar");
        //int iDepart = Integer.parseInt(depart);
        String filial = request.getParameter("slcFilial");
        //int iFilial = Integer.parseInt(filial);
        String cargo = request.getParameter("cargo");
        String senha = request.getParameter("senha");

        Funcionario novoFuncionario = new Funcionario(sq, nome, usuario, depart, 
                filial, cargo, senha);

        HttpSession sessao = request.getSession();
        sessao.setAttribute("novoFuncionario", novoFuncionario);
        
        ValidarFuncionario validarFuncionario = new ValidarFuncionario();
        boolean valido = validarFuncionario.ehPalavra(novoFuncionario);

        if (valido) {

            try {
                
                FuncionarioDao funcionario = new FuncionarioDao();
                
                if (funcionario.incluir(novoFuncionario)){
                        
                        int idFunc =(Integer)sessao.getAttribute("id_funcionario");
                        LogFuncionario logF = new LogFuncionario (idFunc,
                                LogAcao.INCLUSAO.getValor(),
                                Funcionario.class.getSimpleName(),
                                funcionario.lastId());
                        
                        LogDao lD = new LogDao();
                        lD.incluir(logF);
                        
                }

            } catch (Exception ex) {
                Logger.getLogger(FuncionarioCadastrarServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {

            } catch (Exception ex) {
                Logger.getLogger(FuncionarioCadastrarServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            response.sendRedirect(request.getContextPath() + "/FuncionarioCadastrarServlet");
        } else {
            response.sendRedirect("telas/Produto/MensagemErro.jsp");

        }

    }


}
