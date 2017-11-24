/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.astec.model.dao;

import br.com.astec.model.entidades.ItemVenda;
import br.com.astec.model.entidades.LogFuncionario;
import br.com.astec.model.entidades.Produto;
import br.com.astec.model.entidades.Venda;
import br.com.astec.model.utils.RSConverter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Usuário
 */
public class VendaDao extends AbstractDao<Venda> {

    @Override
    public boolean incluir(Venda entity) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Produto alterar(Venda entity, int id) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean remover(int id) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Venda> consultarTodos() throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Produto> consultarPorId(Integer id) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Produto> consultarPorNome(String nomeConsultado) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<LogFuncionario> consultaPorDatas(String dataInicial, String dataFinal) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<Venda> consultaVendaPorDatas(String dataInicial, String dataFinal) throws SQLException, Exception {
            

        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date dataIn = sdf1.parse(dataInicial + " 00:00:00");
        Timestamp ts1 = new Timestamp(dataIn.getTime());

        Date dataFi = sdf1.parse(dataFinal + " 23:59:59");
        Timestamp ts2 = new Timestamp(dataFi.getTime());

        
        
        List<Venda> listaVenda = new ArrayList<>();
        




        String sql = "SELECT * FROM VENDA " + 
                "WHERE datas BETWEEN ? AND ?)";
        
        Connection con = getConnection();
        
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setTimestamp(1, ts1);
        stm.setTimestamp(2, ts2);
        
        ResultSet rs = stm.executeQuery();
        
        while (rs.next()) {            
            listaVenda.add(RSConverter.toVenda(rs));
        }
        
        return listaVenda;
        
    }
}
    

