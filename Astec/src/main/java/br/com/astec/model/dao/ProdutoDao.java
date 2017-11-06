package br.com.astec.model.dao;

import br.com.astec.model.constants.LogAcao;
import br.com.astec.model.utils.ConnectionUtils;
import br.com.astec.model.entidades.Produto;
import br.com.astec.model.utils.LogFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author rafael
 */
public class ProdutoDao extends AbstractDao<Produto>{
    //Id Funcionario Logado
    private final LogFactory _log = LogFactory.factory();
    
    @Override
    public boolean incluir(Produto entity) throws SQLException, Exception{
        java.util.Date utilDate = new java.util.Date();
        java.sql.Timestamp sq = new java.sql.Timestamp(utilDate.getTime());
        
        String sql = "INSERT INTO produto (datas, nome, codigo_produto, categoria, cor, tamanho, quantidade_estoque, descr, preco)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(sql);
            //preparedStatement.setInt(1, novo.getCodigoBanco());
            preparedStatement.setTimestamp(1, sq);
            preparedStatement.setString(2, entity.getNomeProduto());
            preparedStatement.setInt(3, entity.getCodigoProduto());
            preparedStatement.setString(4, entity.getCategoria());
            preparedStatement.setString(5, entity.getCor());
            preparedStatement.setInt(6, entity.getTamanho());
            preparedStatement.setInt(7, entity.getQuantidade());
            preparedStatement.setString(8, entity.getDescricao());
            preparedStatement.setDouble(9, entity.getPreco());

           boolean val = preparedStatement.executeUpdate() > 0;
           
           if(val){
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
    public boolean alterar(Produto entity) throws SQLException, Exception {
         _log.log(2, Produto.class.getName(), LogAcao.ALTERACAO);
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean remover(Produto entity) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Produto> consultar() throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Produto consultarPorId(Integer id) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
}
