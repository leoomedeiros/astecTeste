package br.com.astec.model.dao;

import br.com.astec.model.constants.LogAcao;
import br.com.astec.model.utils.ConnectionUtils;
import br.com.astec.model.entidades.Produto;
import br.com.astec.model.utils.LogFactory;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.ws.rs.client.Entity;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author rafael
 */
public class ProdutoDao extends AbstractDao<Produto> {

    //Id Funcionario Logado
    private final LogFactory _log = LogFactory.factory();
    java.util.Date utilDate = new java.util.Date();
    java.sql.Timestamp sq = new java.sql.Timestamp(utilDate.getTime());

    @Override
    public boolean incluir(Produto entity) throws SQLException, Exception {

        String sql = "INSERT INTO produto (datas, nome, categoria, cor, tamanho, "
                + "quantidade_estoque, descr, preco)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(sql);
            //é o código id do banco que por padrão 
            //não é setado (preparedStatement.setInt(1, novo.getCodigoBanco()));
            preparedStatement.setTimestamp(1, sq);
            preparedStatement.setString(2, entity.getNomeProduto());
            //preparedStatement.setInt(3, entity.getCodigoProduto());
            preparedStatement.setString(3, entity.getCategoria());
            preparedStatement.setString(4, entity.getCor());
            preparedStatement.setInt(5, entity.getTamanho());
            preparedStatement.setInt(6, entity.getQuantidade());
            preparedStatement.setString(7, entity.getDescricao());
            preparedStatement.setDouble(8, entity.getPreco());

            boolean val = preparedStatement.executeUpdate() > 0;

            if (val) {
                //select max(id_prod) from produto;
                _log.log(2, Produto.class.getName(), LogAcao.INCLUSAO);
            }

            //Ultimo Produto Cadastrado
            //select max(id_prod) from produto;
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

    @Override
    public Produto alterar(Produto entity, int id) throws SQLException, Exception {
        //_log.log(2, Produto.class.getName(), LogAcao.ALTERACAO);
        String sql = "UPDATE produto SET datas=?, nome=?, categoria=?, cor=?, tamanho=?, quantidade_estoque=?, descr=?, preco=?"
                + "WHERE (id_prod=?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setTimestamp(1, sq);//entity.getDtCadastro());
            preparedStatement.setString(2, entity.getNomeProduto());
            preparedStatement.setString(3, entity.getCategoria());
            preparedStatement.setString(4, entity.getCor());
            preparedStatement.setInt(5, entity.getTamanho());
            preparedStatement.setInt(6, entity.getQuantidade());
            preparedStatement.setString(7, entity.getDescricao());
            preparedStatement.setDouble(8, entity.getPreco());
            preparedStatement.setInt(9, id);

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

    @Override
    public boolean remover(int id) throws SQLException, Exception {
        String sql = "DELETE FROM produto WHERE (id_prod=?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            preparedStatement.execute();
        } finally {
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        throw new UnsupportedOperationException("6 Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Produto> consultarTodos() throws SQLException, Exception {
        //throw new UnsupportedOperationException("7 Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        List<Produto> listaProdutos = new ArrayList();
        String sql = "SELECT * FROM produto ORDER BY id_prod";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            result = preparedStatement.executeQuery();

            while (result.next()) {
                Produto consultado = new Produto();
                consultado.setId(result.getInt("id_prod"));
                consultado.setDtCadastro(result.getTimestamp("datas"));
                consultado.setNomeProduto(result.getString("nome"));
                consultado.setCategoria(result.getString("categoria"));
                consultado.setCor(result.getString("cor"));
                consultado.setTamanho(result.getInt("tamanho"));
                consultado.setQuantidade(result.getInt("quantidade_estoque"));
                consultado.setDescricao(result.getString("descr"));
                consultado.setPreco(result.getDouble("preco"));

                listaProdutos.add(consultado);

            }
            return listaProdutos;
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
    }

    @Override//método usado como suporte para excluir e alterar.
    public Produto consultarPorId(Integer codigoAltExc) throws SQLException, Exception {
        //throw new UnsupportedOperationException("8 Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        String sql = "SELECT * FROM produto WHERE id_prod=?";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, codigoAltExc);

            result = preparedStatement.executeQuery();

            while (result.next()) {
                Produto consultar = new Produto();
                consultar.setId(result.getInt("id_prod"));
                consultar.setDtCadastro(result.getTimestamp("datas"));
                consultar.setNomeProduto(result.getString("nome"));
                consultar.setCategoria(result.getString("categoria"));
                consultar.setCor(result.getString("cor"));
                consultar.setTamanho(result.getInt("tamanho"));
                consultar.setQuantidade(result.getInt("quantidade_estoque"));
                consultar.setDescricao(result.getString("descr"));
                consultar.setPreco(result.getDouble("preco"));

                return consultar;
            }
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

    @Override
    public List<Produto> consultarPorNome(String nomeConsultado) throws SQLException, Exception {
        //String sql = "SELECT * FROM produto WHERE nome=?";
        String sql = "select * from produto where nome like?";

        List<Produto> listaProdutos = new ArrayList();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        
        try {
            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, "%" + nomeConsultado + "%");

            result = preparedStatement.executeQuery();

            while (result.next()) {
                Produto consultado = new Produto();
                consultado.setId(result.getInt("id_prod"));
                consultado.setDtCadastro(result.getTimestamp("datas"));
                consultado.setNomeProduto(result.getString("nome"));
                consultado.setCategoria(result.getString("categoria"));
                consultado.setCor(result.getString("cor"));
                consultado.setTamanho(result.getInt("tamanho"));
                consultado.setQuantidade(result.getInt("quantidade_estoque"));
                consultado.setDescricao(result.getString("descr"));
                consultado.setPreco(result.getDouble("preco"));

                listaProdutos.add(consultado);

            }
            return listaProdutos;
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

    }
}
