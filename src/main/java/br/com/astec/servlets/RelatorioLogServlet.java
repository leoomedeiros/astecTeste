/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.astec.servlets;

import br.com.astec.model.dao.LogDao;
import br.com.astec.model.entidades.LogFuncionario;
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
 * @author Usuário
 */
@WebServlet(name = "RelatorioLogServlet", urlPatterns = {"/RelatorioLogServlet"})
public class RelatorioLogServlet extends HttpServlet {

    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        
        HttpSession session = request.getSession();
        
        String dataInicial = request.getParameter("dataIni");
        String dataFinal = request.getParameter("dataFin");
        
        session.setAttribute("dtInicio", dataInicial);
        session.setAttribute("dtFim",dataFinal);
        
        
        
        List<LogFuncionario> lista;
        
        if ((!dataInicial.isEmpty())&&(!dataFinal.isEmpty())){
            try {
                LogDao log = new LogDao();
                lista = log.consultaPorDatas(dataInicial, dataFinal);
                session.setAttribute("listaLog", lista);

  
                
            } catch (Exception ex) {
                Logger.getLogger(RelatorioLogServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        response.sendRedirect("telas/Relatorio/RelatorioLog_falta/relatorioLog.jsp");
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
