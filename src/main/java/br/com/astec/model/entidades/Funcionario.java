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
public class Funcionario extends AbstractEntity{
    private Integer id;
    private Timestamp dataDeCadastro;
    private String nome;
    private int departamento;
    private int filial;
    private String cargo;
    private String senha;

    public Funcionario(int SIZE, Timestamp sq, String nome, int iDepart, int iFilial, String cargo, String senha) {
        this.id = SIZE;
        this.dataDeCadastro = sq;
        this.nome = nome;
        this.departamento = iDepart;
        this.filial = iFilial;
        this.cargo = cargo;
        this.senha = senha;
    }

    public Funcionario() {
        
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

    public int getDepartamento() {
        return departamento;
    }

    public void setDepartamento(int departamento) {
        this.departamento = departamento;
    }
    
    public int getFilial(){
        return filial;
    }
    
    public void setFilial(int filial){
        this.filial = filial;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
