/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.astec.model.entidades;

/**
 *
 * @author Fernando
 */
public class ItemVenda extends AbstractEntity{
    private Integer id;
    private Integer idProduto;
    private Integer idvenda;
    private Integer qdeVendida;

    public ItemVenda(Integer id, Integer produto, int idvenda, Integer qdeVendida) {
        this.id = id;
        this.idProduto = produto;
        this.idvenda = idvenda;
        this.qdeVendida = qdeVendida;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProdutoId() {
        return idProduto;
    }

    public void setProdutoId(Integer produto) {
        this.idProduto = produto;
    }

    public int getIdvenda() {
        return idvenda;
    }

    public void setIdvenda(int idvenda) {
        this.idvenda = idvenda;
    }

    public Integer getQdeVendida() {
        return qdeVendida;
    }

    public void setQdeVendida(Integer qdeVendida) {
        this.qdeVendida = qdeVendida;
    }
}
