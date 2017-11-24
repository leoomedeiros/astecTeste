/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.astec.servlets;

import br.com.astec.model.dao.ProdutoDao;
import br.com.astec.model.entidades.LogFuncionario;
import br.com.astec.model.utils.GeradorRelatorio;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@WebServlet(name = "ExportRelatorioLogProdutoServlet", urlPatterns = {"/ExportRelatorioLogProdutoServlet"})
public class ExportRelatorioLogProdutoServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        String dataInicial = session.getAttribute("dtInicio").toString();
        String dataFinal = session.getAttribute("dtFim").toString();

        List<LogFuncionario> lista;

        if ((!dataInicial.isEmpty()) && (!dataFinal.isEmpty())) {
            try {
                ProdutoDao pDao = new ProdutoDao();
                lista = pDao.consultaPorDatas(dataInicial, dataFinal);

                response.setContentType("text/csv");

                Date data = new Date();

                SimpleDateFormat formato = new SimpleDateFormat("ddMMyyyyHHmmss");

                String dataFormatada = formato.format(data);

                // Make sure to show the download dialog
                response.setHeader("Content-disposition", "attachment; filename=Relatorio_Log_Produto_" + dataFormatada + ".csv");

                // Assume file name is retrieved from database
                // For example D:\\file\\test.pdf
                File arquivo = GeradorRelatorio.generateLogProdutoCsvFile(lista, "Relatorio_Log");

                // This should send the file to browser
                OutputStream out = response.getOutputStream();

                FileInputStream in = new FileInputStream(arquivo);
                byte[] buffer = new byte[4096];
                int length;
                while ((length = in.read(buffer)) > 0) {
                    out.write(buffer, 0, length);
                }
                in.close();
                out.flush();

            } catch (Exception ex) {
                Logger.getLogger(ExportRelatorioLogServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        response.sendRedirect("telas/Relatorio/relatorioProduto_falta/relatorioProduto.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
