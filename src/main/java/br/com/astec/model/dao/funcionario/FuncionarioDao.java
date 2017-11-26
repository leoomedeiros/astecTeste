/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.astec.model.dao.funcionario;

import br.com.astec.model.constants.LogAcao;
import br.com.astec.model.entidades.Funcionario;
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
public class FuncionarioDao {
    
    //Id Funcionario Logado
    private final LogFactory _log = LogFactory.factory();
    java.util.Date utilDate = new java.util.Date();
    java.sql.Timestamp sq = new java.sql.Timestamp(utilDate.getTime());
    
    //autenticar via banco
    public List<Funcionario> loginFuncionario(String username, String senha) throws SQLException, Exception{
        String sql = "select depar, usuario, senha from funcionario";
        
        List<Funcionario>usuarioLogado = new ArrayList();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;

        try {
            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            
            result = preparedStatement.executeQuery();
            
            while (result.next()) {
                Funcionario consultado = new Funcionario();
                //consultado.setFilial(result.getString("filial"));
                consultado.setDepartamento(result.getString("depar"));
                //consultado.setNome(result.getString("nome"));
                consultado.setUsuario(result.getString("usuario"));
                //consultado.setCargo(result.getString("cargo"));
                consultado.setHashSenha(result.getString("senha"));
                

                usuarioLogado.add(consultado);

            }
            return usuarioLogado;
            
        } catch (SQLException e) {
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
        }
        return null;
    }

    public boolean incluir(Funcionario entity) throws SQLException, Exception {

        String sql = "INSERT INTO funcionario (datas, filial, depar, nome, usuario, cargo, senha)"
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setTimestamp(1, sq);
            preparedStatement.setString(2, entity.getFilial());
            preparedStatement.setString(3, entity.getDepartamento());
            preparedStatement.setString(4, entity.getNome());
            preparedStatement.setString(5, entity.getUsuario());
            preparedStatement.setString(6, entity.getCargo());
            preparedStatement.setString(7, entity.getHashSenha());

            boolean val = preparedStatement.executeUpdate() > 0;

            if (val) {
                LogFactory.log(2, Funcionario.class.getName(), LogAcao.INCLUSAO);
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

    public static Funcionario alterar(Funcionario entity, int id) throws SQLException, Exception {
        java.util.Date utilDate = new java.util.Date();
        java.sql.Timestamp sq = new java.sql.Timestamp(utilDate.getTime());
        
        String sql = "UPDATE Funcionario SET nome=?, depar=?, usuario=?, filial=?, cargo=?"
                + "WHERE (id_funcionario=?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, entity.getNome());
            preparedStatement.setString(2, entity.getDepartamento());
            preparedStatement.setString(3, entity.getUsuario());
            preparedStatement.setString(4, entity.getFilial());
            preparedStatement.setString(5, entity.getCargo());
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

    public static boolean remover(int id) throws SQLException, Exception {
        java.util.Date utilDate = new java.util.Date();
        java.sql.Timestamp sq = new java.sql.Timestamp(utilDate.getTime());
        
        String sql = "DELETE FROM Funcionario WHERE id_funcionario=?";
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

    public static List<Funcionario> consultarTodos() throws SQLException, Exception {
        java.util.Date utilDate = new java.util.Date();
        java.sql.Timestamp sq = new java.sql.Timestamp(utilDate.getTime());
        List<Funcionario> listaFuncionario = new ArrayList();
        String sql = "SELECT * FROM Funcionario";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            result = preparedStatement.executeQuery();

            while (result.next()) {
                Funcionario consultado = new Funcionario();
                consultado.setId(result.getInt("id_funcionario"));  
                consultado.setNome(result.getString("nome"));
                consultado.setUsuario(result.getString("usuario"));
                consultado.setDepartamento(result.getString("depar"));
                consultado.setFilial(result.getString("filial"));
                consultado.setCargo(result.getString("cargo"));


                listaFuncionario.add(consultado);

            }
            return listaFuncionario;
        } catch (SQLException e) {
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
        }
        return listaFuncionario;
    }

    public static List<Funcionario> consultarPorId(Integer codigoAltExc) throws SQLException, Exception {
        java.util.Date utilDate = new java.util.Date();
        java.sql.Timestamp sq = new java.sql.Timestamp(utilDate.getTime());
        String sql = "SELECT * FROM funcionario WHERE id_funcionario=?";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        List<Funcionario> temNalista = new ArrayList();
        try {
            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, codigoAltExc);

            result = preparedStatement.executeQuery();

            while (result.next()) {
                Funcionario consultar = new Funcionario();
                consultar.setId(result.getInt("id_funcionario"));
                consultar.setNome(result.getString("nome"));
                consultar.setUsuario(result.getString("usuario"));
                consultar.setDepartamento(result.getString("depar"));
                consultar.setFilial(result.getString("filial"));
                consultar.setCargo(result.getString("cargo"));
                

                temNalista.add(consultar);

            }
            return temNalista;
        } catch (SQLException e) {
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
        }
        return temNalista;
    }

    public static List<Funcionario> consultarPorNome(String nomeConsultado) throws SQLException, Exception {
        String sql = "select * from Funcionario where nome like ?";
        java.util.Date utilDate = new java.util.Date();
        java.sql.Timestamp sq = new java.sql.Timestamp(utilDate.getTime());
        
        List<Funcionario> listaFuncionario = new ArrayList();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;

        try {
            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, "%" +nomeConsultado+ "%");

            result = preparedStatement.executeQuery();
           
            while (result.next()) {

                Funcionario consultado = new Funcionario();
                consultado.setId(result.getInt("id_funcionario"));
                //consultado.setDataDeCadastro(result.getTimestamp("datas"));
                consultado.setNome(result.getString("nome"));
                consultado.setUsuario(result.getString("usuario"));
                consultado.setDepartamento(result.getString("depar"));
                consultado.setFilial(result.getString("filial"));
                consultado.setCargo(result.getString("cargo"));
         
                listaFuncionario.add(consultado);

            }
            return listaFuncionario;
        } catch (SQLException e) {
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
        }
        return listaFuncionario;
    }
}
