/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.astec.model.dao;

import br.com.astec.model.constants.LogAcao;
import br.com.astec.model.entidades.Cliente;
import static br.com.astec.model.utils.ConnectionUtils.getConnection;
import br.com.astec.model.utils.LogFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Fernando
 */
public class DaoCliente {
    //Id Funcionario Logado

    private final LogFactory _log = LogFactory.factory();

    public boolean incluir(Cliente entity) throws SQLException, Exception {
        java.util.Date utilDate = new java.util.Date();
        java.sql.Timestamp sq = new java.sql.Timestamp(utilDate.getTime());

        String sql = "INSERT INTO cliente (datas, nome, cpf, endereco, telefone)"
                + " VALUES (?, ?, ?, ?, ?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(sql);
            //preparedStatement.setInt(1, novo.getCodigoBanco());
            preparedStatement.setTimestamp(1, sq);
            preparedStatement.setString(2, entity.getNome());
            preparedStatement.setString(3, entity.getCpf());
            preparedStatement.setString(4, entity.getEndereco());
            preparedStatement.setString(5, entity.getTelefone());

            boolean val = preparedStatement.executeUpdate() > 0;

            if (val) {
                //select max(id_prod) from cliente;
                _log.log(2, Cliente.class.getName(), LogAcao.INCLUSAO);
            }

            //Ultimo Cliente Cadastrado
            //select max(id_prod) from cliente;
            return val;

        } finally {
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }

    }

    public boolean alterar(Cliente entity) throws SQLException, Exception {
        _log.log(2, Cliente.class.getName(), LogAcao.ALTERACAO);
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean remover(Cliente entity) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Cliente> consultar() throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Cliente consultarPorId(Integer id) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
