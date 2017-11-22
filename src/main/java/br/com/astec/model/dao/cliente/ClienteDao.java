/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.astec.model.dao.cliente;

import br.com.astec.model.constants.LogAcao;
import br.com.astec.model.entidades.Cliente;
import br.com.astec.model.utils.ConnectionUtils;
import static br.com.astec.model.utils.ConnectionUtils.getConnection;
import br.com.astec.model.utils.LogFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fernando
 */
public class ClienteDao {
    
    //Id Funcionario Logado
    private final LogFactory _log = LogFactory.factory();
    java.util.Date utilDate = new java.util.Date();
    java.sql.Timestamp sq = new java.sql.Timestamp(utilDate.getTime());

    public boolean incluir(Cliente entity) throws SQLException, Exception {

        String sql = "INSERT INTO cliente (datas, nome, cpf, endereco, telefone)"
                + " VALUES (?, ?, ?, ?, ?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setTimestamp(1, sq);
            preparedStatement.setString(2, entity.getNome());
            preparedStatement.setString(3, entity.getCpf());
            preparedStatement.setString(4, entity.getEndereco());
            preparedStatement.setString(5, entity.getTelefone());

            boolean val = preparedStatement.executeUpdate() > 0;

            if (val) {
                LogFactory.log(2, Cliente.class.getName(), LogAcao.INCLUSAO);
            }
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

    public Cliente alterar(Cliente entity, int id) throws SQLException, Exception {
        String sql = "UPDATE cliente SET datas=?, nome=?, cpf=?, endereco=?, telefone=?"
                + "WHERE (id_cliente=?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setTimestamp(1, sq);
            preparedStatement.setString(2, entity.getNome());
            preparedStatement.setString(3, entity.getCpf());
            preparedStatement.setString(4, entity.getEndereco());
            preparedStatement.setString(5, entity.getTelefone());
            preparedStatement.setInt(6, id);

            preparedStatement.executeUpdate();

            return entity;

        } finally {

            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    public boolean remover(int id) throws SQLException, Exception {
        String sql = "DELETE FROM cliente WHERE id_cliente=?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            preparedStatement.execute();
            return true;
        } finally {
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    public List<Cliente> consultarTodos() throws SQLException, Exception {
        List<Cliente> listaClientes = new ArrayList();
        String sql = "SELECT * FROM cliente";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            result = preparedStatement.executeQuery();

            while (result.next()) {
                Cliente consultado = new Cliente();
                consultado.setId(result.getInt("id_cliente"));
                consultado.setDataDeCadastro(result.getTimestamp("datas"));
                consultado.setNome(result.getString("nome"));
                consultado.setCpf(result.getString("cpf"));
                consultado.setEndereco(result.getString("endereco"));
                consultado.setTelefone(result.getString("telefone"));

                listaClientes.add(consultado);

            }
            return listaClientes;
        } catch (SQLException e){
            e.getMessage();
            
        } 
        finally {
            if (result != null && !result.isClosed()) {
                result.close();
            }
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } return listaClientes;
    }

   
    public List<Cliente> consultarPorId(Integer codigoAltExc) throws SQLException, Exception {
       
        String sql = "SELECT * FROM cliente WHERE id_cliente=?";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        List<Cliente> temNalista = new ArrayList();
        try {
            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, codigoAltExc);

            result = preparedStatement.executeQuery();

            while (result.next()) {
                Cliente consultar = new Cliente();
                consultar.setId(result.getInt("id_cliente"));
                consultar.setNome(result.getString("nome"));
                consultar.setCpf(result.getString("cpf"));
                consultar.setEndereco(result.getString("endereco"));
                consultar.setTelefone(result.getString("telefone"));
                
                temNalista.add(consultar);

            } return temNalista;
        } catch (SQLException e){
            e.getMessage();
            
        } finally {
            if (result != null && !result.isClosed()) {
                result.close();
            }
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } return temNalista;
    }

    
    public List<Cliente> consultarPorNome(String nomeConsultado) throws SQLException, Exception {
        String sql = "select * from cliente where nome like?";

        List<Cliente> listaClientes = new ArrayList();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        
        try {
            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, "%" + nomeConsultado + "%");

            result = preparedStatement.executeQuery();

            while (result.next()) {
                Cliente consultado = new Cliente();
                consultado.setId(result.getInt("id_prod"));
                consultado.setNome(result.getString("nome"));
                consultado.setCpf(result.getString("cpf"));
                consultado.setEndereco(result.getString("endereco"));
                consultado.setTelefone(result.getString("telefone"));

                listaClientes.add(consultado);

            }
            return listaClientes;
        } catch (SQLException e){
            e.getMessage();
            
        } finally {
            if (result != null && !result.isClosed()) {
                result.close();
            }
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } return listaClientes;
    } 
}

