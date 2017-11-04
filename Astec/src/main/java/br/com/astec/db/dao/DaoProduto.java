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
    
    

    public static void inserir(Produto novo)
            throws SQLException, Exception {
        java.util.Date utilDate = new java.util.Date();
        java.sql.Timestamp sq = new java.sql.Timestamp(utilDate.getTime());
        
        String sql = "INSERT INTO produto VALUES (dafault, 1960-01-01 23:03:20, ?, ?, ?, ?, ?, ?, ?, ?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, novo.getCodigoBanco());
            preparedStatement.setTimestamp(2, sq);
            preparedStatement.setString(3, novo.getNomeProduto());
            preparedStatement.setInt(4, novo.getCodigoProduto());
            preparedStatement.setString(5, novo.getCategoria());
            preparedStatement.setString(6, novo.getCor());
            preparedStatement.setInt(7, novo.getTamanho());
            preparedStatement.setInt(8, novo.getQuantidade());
            preparedStatement.setString(9, novo.getDescricao());
            preparedStatement.setDouble(10, novo.getPreco());

            connection.createStatement().executeQuery(sql);
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
