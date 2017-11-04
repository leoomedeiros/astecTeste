/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.astec.model.produto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.GregorianCalendar;


public class Produto implements Serializable{
    private int codigoBanco;
    private Timestamp dtCadastro;
    private String nomeProduto;
    private int codigoProduto;
    private String categoria;
    private String cor;
    private int tamanho;
    private int quantidade;
    
    public int getCodigoBanco() {
        return codigoBanco;
    }

    public void setCodigoBanco(int codigoBanco) {
        this.codigoBanco = codigoBanco;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public int getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(int codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Produto(int codigoBanco, Timestamp dtCadastro, String nomeProduto, int codigoProduto, 
            String categoria, String cor, int tamanho, int quantidade, 
            String descricao, double preco) {
        this.codigoBanco = codigoBanco;
        this.dtCadastro = dtCadastro;
        this.nomeProduto = nomeProduto;
        this.codigoProduto = codigoProduto;
        this.categoria = categoria;
        this.cor = cor;
        this.tamanho = tamanho;
        this.quantidade = quantidade;
        this.descricao = descricao;
        this.preco = preco;
    }

    public Timestamp getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(Timestamp dtCadastro) {
        this.dtCadastro = dtCadastro;
    }
    
    public Produto (){
        
    }
    private String descricao;
    private double preco;
}

    