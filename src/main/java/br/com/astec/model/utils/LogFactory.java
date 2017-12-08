/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.astec.model.utils;

import br.com.astec.model.constants.LogAcao;
import br.com.astec.model.dao.LogDao;
import br.com.astec.model.entidades.LogFuncionario;
import java.sql.SQLException;

/**
 *
 * @author Usuário
 */
public final class LogFactory {

    private static LogFactory INSTANCE = new LogFactory();
    
    
    private static final  LogDao DAO = new LogDao();
    
    private LogFactory() {
    }
    
    
    
    public static void log(Integer idFunc, Integer idRegistro, String nomeTabela, LogAcao acao) throws SQLException{
        LogFuncionario lf = new LogFuncionario();
        lf.setId(idFunc);
        lf.setAcao(acao.getValor());
        lf.setNomeTabela(nomeTabela);
        lf.setIdItem(idRegistro);
        //
        //lf.setDate(new Date
        
        DAO.incluir(lf);
    }
    
    
    
    
    
}
