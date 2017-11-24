/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.astec.model.utils;

/**
 *
 * @author Usuário
 */
import br.com.astec.model.entidades.Produto;
import br.com.astec.model.dao.ProdutoDao;
import br.com.astec.model.entidades.ItemVenda;
import br.com.astec.model.entidades.LogFuncionario;
import br.com.astec.model.entidades.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Usuário
 */
public final class RSConverter {

    private RSConverter() {
    }
    
    public static LogFuncionario toFuncLog(ResultSet rs) throws SQLException{
        
        
        Date dataAcao = new Date (rs.getTimestamp("data_acao").getTime());
        
        return new LogFuncionario(rs.getInt("id"),
                rs.getInt("id_funcionario"),
                rs.getString("acao"),
                rs.getString("nm_tabela"),
                rs.getInt("id_registro"),
                dataAcao);
        
        
        
    }
    public static LogFuncionario toFuncLogProduto(ResultSet rs) throws SQLException, Exception{
    
            
        ProdutoDao pD = new ProdutoDao();
        
        List<Produto> listaP = pD.consultarTodos();
        String nome="";
        for (Produto produto : listaP) {
            if(produto.getId()==rs.getInt("id_registro")){
                nome=produto.getNomeProduto();
            }
        }
        
        
        Date dataAcao = new Date (rs.getTimestamp("data_acao").getTime());
        
        return new LogFuncionario(rs.getInt("id"),
                rs.getInt("id_funcionario"),
                rs.getString("acao"),
                nome,
                rs.getInt("id_registro"),
                dataAcao,
                rs.getInt("qntd"));
        
        
        
    }
    public static Venda toVenda(ResultSet rs) throws SQLException, Exception{
    
        
        String sql = "SELECT * FROM ITEMVENDA"
                + "WHERE id_venda = ";
        
        Connection con = ConnectionUtils.getConnection();
        PreparedStatement stm = con.prepareStatement(sql);
        

        List<ItemVenda> listaItens = new ArrayList<>();
        
        ResultSet rsItemVenda = stm.executeQuery();
        
        while (rsItemVenda.next()) {            
            listaItens.add(RSConverter.toItemVenda(rsItemVenda));
        }
        
        Date dataCompra = new Date (rs.getTimestamp("datas").getTime());
        
        return new Venda(rs.getInt("id"),
                rs.getInt("id_cliente"),
                dataCompra,
                rs.getDouble("valorTotal"),
                listaItens);
        
        
        
    }
    public static ItemVenda toItemVenda(ResultSet rs) throws SQLException, Exception{
    
        
        return new ItemVenda(rs.getInt("id_itemVenda"),
                rs.getInt("id_prod"),
                rs.getInt("id_venda"),
                rs.getInt("qtdVenda"));
        
        
        
    }
    
}
