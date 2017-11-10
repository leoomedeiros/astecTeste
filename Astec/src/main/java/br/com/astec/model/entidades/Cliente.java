/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.astec.model.entidades;

import java.sql.Timestamp;



/**
 *
 * @author Fernando
 */
public class Cliente extends AbstractEntity {

    private Integer id;
    private Timestamp dataDeCadastro;
    private String nome;
    private String cpf;
    private String endereco;
    private String telefone;

    public Cliente(Timestamp dataDeCadastro, String nome, String cpf, String endereco, String telefone) {
        this.dataDeCadastro = dataDeCadastro;
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getDataDeCadastro() {
        return dataDeCadastro;
    }

    public void setDataDeCadastro(Timestamp dataDeCadastro) {
        this.dataDeCadastro = dataDeCadastro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

}
