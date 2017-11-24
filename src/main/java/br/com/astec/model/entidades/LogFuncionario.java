/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.astec.model.entidades;

import java.util.Date;

/**
 *
 * @author Usuário
 */
public class LogFuncionario extends AbstractEntity{
    

    private Integer id;
    private Integer idFunc;
    private String acao;
    private String nomeTabela;
    private Integer idItem;
    private Date dataAcao;
    private Integer qntd;

    public LogFuncionario(Integer id, Integer idFunc, String acao, String nomeTabela, Integer idItem, Date dataAcao, Integer qntd) {
        this.id = id;
        this.idFunc = idFunc;
        this.acao = acao;
        this.nomeTabela = nomeTabela;
        this.idItem = idItem;
        this.dataAcao = dataAcao;
        this.qntd = qntd;
    }



    public LogFuncionario(Integer id,Integer idFunc, String acao, String nomeTabela, Integer idItem,Date dataAcao) {
        this.id = id;
        this.idFunc = idFunc;
        this.acao = acao;
        this.nomeTabela = nomeTabela;
        this.idItem = idItem;
        this.dataAcao = dataAcao;
    }
    public Integer getQntd() {
        return qntd;
    }

    public void setQntd(Integer qntd) {
        this.qntd = qntd;
    }

    public LogFuncionario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Integer getIdFunc() {
        return idFunc;
    }

    public void setIdFunc(Integer idFunc) {
        this.idFunc = idFunc;
    }

    
    public Date getDataAcao() {
        return dataAcao;
    }

    public void setDataAcao(Date dataAcao) {
        this.dataAcao = dataAcao;
    }

        
    
    public Integer getIdItem() {
        return idItem;
    }

    public void setIdItem(Integer id_item) {
        this.idItem = id_item;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public String getNomeTabela() {
        return nomeTabela;
    }

    public void setNomeTabela(String nomeTabela) {
        this.nomeTabela = nomeTabela;
    }

    
    
   
    
}
