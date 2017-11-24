/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.astec.servlets;

import br.com.astec.model.dao.ProdutoDao;
import br.com.astec.model.dao.VendaDao;
import br.com.astec.model.entidades.LogFuncionario;
import br.com.astec.model.entidades.Venda;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "RelatorioVendaServlet", urlPatterns = {"/RelatorioVendaServlet"})
public class RelatorioVendaServlet extends HttpServlet {

    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        
        HttpSession session = request.getSession();
        
        String dataInicial = request.getParameter("dataIni");
        String dataFinal = request.getParameter("dataFin");
        
        session.setAttribute("dtInicio", dataInicial);
        session.setAttribute("dtFim",dataFinal);
        
        double valorTotalRelatorio=0;
        
        
        List<Venda> lista;
        
        if ((!dataInicial.isEmpty())&&(!dataFinal.isEmpty())){
            try {
                VendaDao vD = new VendaDao();
                lista = vD.consultaVendaPorDatas(dataInicial, dataFinal);
                session.setAttribute("listaVenda", lista);
                for (Venda venda : lista) {
                    valorTotalRelatorio += venda.getValorTotal();
                }
  
                
            } catch (Exception ex) {
                Logger.getLogger(RelatorioLogServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        session.setAttribute("valorTotalRelatorio",valorTotalRelatorio);
        
        
        
        response.sendRedirect("telas/Relatorio/relatorioVenda/relatorioVenda.jsp");
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
