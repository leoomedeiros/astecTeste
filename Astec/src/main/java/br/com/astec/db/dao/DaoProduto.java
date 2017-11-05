package br.com.astec.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import br.com.astec.db.utils.ConnectionUtils;
import br.com.astec.model.produto.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author rafael
 */
public class DaoProduto extends Produto{
    
    

    public void inserir(Produto novo)
            throws SQLException, Exception {
        java.util.Date utilDate = new java.util.Date();
        java.sql.Timestamp sq = new java.sql.Timestamp(utilDate.getTime());
        
        String sql = "INSERT INTO produto (datas, nome, codigo_produto, categoria, cor, tamanho, quantidade_estoque, descr, preco)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            //preparedStatement.setInt(1, novo.getCodigoBanco());
            preparedStatement.setTimestamp(1, sq);
            preparedStatement.setString(2, novo.getNomeProduto());
            preparedStatement.setInt(3, novo.getCodigoProduto());
            preparedStatement.setString(4, novo.getCategoria());
            preparedStatement.setString(5, novo.getCor());
            preparedStatement.setInt(6, novo.getTamanho());
            preparedStatement.setInt(7, novo.getQuantidade());
            preparedStatement.setString(8, novo.getDescricao());
            preparedStatement.setDouble(9, novo.getPreco());

            preparedStatement.executeUpdate();
            
        } finally {
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    
}
