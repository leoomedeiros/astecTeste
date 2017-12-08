/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.astec.model.dao;

import br.com.astec.model.entidades.LogFuncionario;
import br.com.astec.model.entidades.Produto;
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
public class LogDao extends AbstractDao<LogFuncionario>{
    
    java.util.Date utilDate = new java.util.Date();
    java.sql.Timestamp sq = new java.sql.Timestamp(utilDate.getTime());
    
    @Override
    public boolean incluir(LogFuncionario entity) throws SQLException {
        
        
        
        String sql = "INSERT INTO log_funcionario (id_funcionario, acao,"
                + "id_registro, nm_tabela, data_acao,qntd)"
                + " VALUES (?, ?, ?, ?, ?, ?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, entity.getIdFunc());
            preparedStatement.setString(2, entity.getAcao());
            preparedStatement.setInt(3, entity.getIdItem());
            preparedStatement.setString(4, entity.getNomeTabela());
            preparedStatement.setTimestamp(5, sq);
            if (entity.getClass().getSimpleName().equalsIgnoreCase(Produto.class.getSimpleName())) {
                preparedStatement.setInt(6, entity.getQntd());
                
            }else{
                preparedStatement.setInt(6, 1);
            }
 

            boolean val = preparedStatement.executeUpdate() > 0;

           
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
    public Produto alterar(LogFuncionario entity, int id) {
        throw new UnsupportedOperationException("2 Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean remover(int id) {
        throw new UnsupportedOperationException("3 Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<LogFuncionario> consultarTodos() {
        throw new UnsupportedOperationException("4 Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Produto> consultarPorId(Integer id) {
        throw new UnsupportedOperationException("5 Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List<Produto> consultarPorNome(String nomeConsultado) {
        throw new UnsupportedOperationException("6 Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public List<LogFuncionario> consultaPorDatas(String dataInicial, String dataFinal) throws SQLException, Exception {
        
        
        List<LogFuncionario> lista = new ArrayList<>();
        


        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date dataIn = sdf1.parse(dataInicial + " 00:00:00");
        Timestamp ts1 = new Timestamp(dataIn.getTime());



        Date dataFi = sdf1.parse(dataFinal + " 23:59:59");
        Timestamp ts2 = new Timestamp(dataFi.getTime());

        String sql = "SELECT * FROM LOG_FUNCIONARIO " + 
                "WHERE DATA_ACAO BETWEEN ? AND ?";
        
        Connection con = getConnection();
        
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setTimestamp(1, ts1);
        stm.setTimestamp(2, ts2);
        
        ResultSet rs = stm.executeQuery();
        
        while (rs.next()) {            
            lista.add(RSConverter.toFuncLog(rs));
        }
        
        return lista;
            
        }
    }

    

