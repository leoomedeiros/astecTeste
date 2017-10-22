/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.astec.model.venda;

import br.com.astec.model.produto.Produto;

/**
 *
 * @author Fernando
 */
public class ItemVenda {
    private Integer id;
    private Produto produto;
    private Venda idvenda;
    private Integer qdeVendida;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Venda getIdvenda() {
        return idvenda;
    }

    public void setIdvenda(Venda idvenda) {
        this.idvenda = idvenda;
    }

    public Integer getQdeVendida() {
        return qdeVendida;
    }

    public void setQdeVendida(Integer qdeVendida) {
        this.qdeVendida = qdeVendida;
    }
}
