/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.astec.model.utils;

import br.com.astec.model.constants.LogAcao;
import br.com.astec.model.dao.LogDao;
import br.com.astec.model.entidades.LogFuncionario;

/**
 *
 * @author Usuário
 */
public final class LogFactory {

    private static LogFactory INSTANCE = new LogFactory();
    
    private static  Integer ID_FUNCIONARIO;
    private static final  LogDao DAO = new LogDao();
    
    private LogFactory() {
    }
    
    public static LogFactory factory(){
        
        if(INSTANCE == null){
            
            INSTANCE = new LogFactory();
            //IMPLEMENTA AQUI O METODO PARA PEGAR O USUARIO LOGADO
            INSTANCE.setIdFuncionario(1);
        }
        
        return INSTANCE;
    }
    
    public static void log(Integer idRegistro, String nomeTabela, LogAcao acao){
        LogFuncionario lf = new LogFuncionario();
        lf.setId(ID_FUNCIONARIO);
        lf.setAcao(acao.getValor());
        lf.setNomeTabela(nomeTabela);
        
        //
        //lf.setDate(new Date
        
        DAO.incluir(lf);
    }
    
    private static void setIdFuncionario(Integer idFuncionario){
        ID_FUNCIONARIO = idFuncionario;
    }
    
    
    
    
    
}
