/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.astec.model.dao;

import br.com.astec.model.entidades.AbstractEntity;
import br.com.astec.model.entidades.LogFuncionario;
import br.com.astec.model.entidades.Produto;
import br.com.astec.model.utils.ConnectionUtils;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Usuário
 */
public abstract class AbstractDao <t extends AbstractEntity>{
    
    
    public abstract boolean incluir(t entity) throws SQLException, Exception;
    public abstract Produto alterar(t entity, int id) throws SQLException, Exception;
    public abstract boolean remover(int id) throws SQLException, Exception;
    public abstract List<t> consultarTodos() throws SQLException, Exception;
    public abstract List<Produto> consultarPorId(Integer id) throws SQLException, Exception;
    public abstract List<Produto> consultarPorNome(String nomeConsultado) throws SQLException, Exception;
    public abstract List<LogFuncionario> consultaPorDatas(String dataInicial, String dataFinal) throws SQLException, Exception;
    public Connection getConnection(){
        return ConnectionUtils.getConnection();
    }

    
}
