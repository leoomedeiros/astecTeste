/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.astec.model.dao;

import br.com.astec.model.entidades.AbstractEntity;
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
    public abstract boolean alterar(t entity) throws SQLException, Exception;
    public abstract boolean remover(t entity) throws SQLException, Exception;
    public abstract List<t> consultar() throws SQLException, Exception;
    public abstract t consultarPorId(Integer id) throws SQLException, Exception;
    
    public Connection getConnection(){
        return ConnectionUtils.getConnection();
    }

    
}
