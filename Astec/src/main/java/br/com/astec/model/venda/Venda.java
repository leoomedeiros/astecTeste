/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.astec.model.venda;

import br.com.astec.model.cliente.Cliente;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Fernando
 */
public class Venda {

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public List<ItemVenda> getListaItem() {
        return listaItem;
    }

    public void setListaItem(List<ItemVenda> listaItem) {
        this.listaItem = listaItem;
    }
    private Integer id;
    private Cliente cliente;
    private Date dataCompra;
    private Double valorTotal;
    private List<ItemVenda> listaItem = new ArrayList<ItemVenda>();
}
