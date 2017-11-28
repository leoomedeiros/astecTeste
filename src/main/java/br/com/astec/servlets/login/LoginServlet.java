/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.astec.servlets.login;

import br.com.astec.model.dao.funcionario.FuncionarioDao;
import br.com.astec.model.entidades.Funcionario;
import java.io.IOException;
import java.util.List;
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
 * @author fernando.tsuda
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Verifica se usuario ja esta logado
        HttpSession sessao = request.getSession();
        Funcionario usuario = (Funcionario) sessao.getAttribute("usuario");
        if (usuario != null) {
            // Usuario já está logado - redireciona para tela inicial
            response.sendRedirect(request.getContextPath() + "/protegido/home");
            return; // Forca a saida do método doGet
        }

        // Usuario nao logado
        // Antes verifica se tem msg do logout na sessao
        String msgErro = (String) sessao.getAttribute("msgErro");
        //sessao.removeAttribute("msgErro");
        if (msgErro != null) {
            request.setAttribute("msgErro", msgErro);
        }

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/WEB-INF/login.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("usuario");
        String senha = request.getParameter("senha");

        HttpSession sessao = request.getSession();

        try {
            FuncionarioDao autenticar = new FuncionarioDao();
            List retornoLogin = autenticar.loginFuncionario(username, senha);

            for (int i = 0; i < retornoLogin.size(); i++) {
                if (autenticar.loginFuncionario(username, senha).get(i).
                        getDepartamento().equalsIgnoreCase("diretoria")) {
                    if (autenticar.loginFuncionario(username, senha).get(i).
                            getUsuario().equalsIgnoreCase(username)
                            && autenticar.loginFuncionario(username, senha).get(i).
                                    getHashSenha().equals(senha)) {
                        sessao.setAttribute("usuario", autenticar.loginFuncionario(username, senha).get(i).
                                getDepartamento());
                        if (sessao.getAttribute("usuario") != null) {
                            response.sendRedirect("telas/Perfis/perfilDiretoria/perfilDiretoria.jsp");
                            //response.sendRedirect("telas/home/home.jsp");
                        }

                    }
                }

            }
            sessao.setAttribute("msgErro", "Usuário ou senha inválidos");
            response.sendRedirect("telas/loginInvalido.jsp");

        } catch (Exception ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
