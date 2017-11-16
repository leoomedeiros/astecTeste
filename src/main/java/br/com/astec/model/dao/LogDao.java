/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.astec.model.dao;

import br.com.astec.model.entidades.LogFuncionario;
import br.com.astec.model.entidades.Produto;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Usuário
 */
public class LogDao extends AbstractDao<LogFuncionario>{

    @Override
    public boolean incluir(LogFuncionario entity) {
        throw new UnsupportedOperationException("1 Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Produto alterar(LogFuncionario entity, int id) {
        throw new UnsupportedOperationException("2 Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean remover(int id) {
        throw new UnsupportedOperationException("3 Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<LogFuncionario> consultarTodos() {
        throw new UnsupportedOperationException("4 Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LogFuncionario consultarPorId(Integer id) {
        throw new UnsupportedOperationException("5 Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List<Produto> consultarPorNome(String nomeConsultado) {
        throw new UnsupportedOperationException("6 Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
