/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.astec.model.entidades;

import java.sql.Timestamp;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Fernando
 */
public class Funcionario extends AbstractEntity{
    private Integer id;
    private Timestamp dataDeCadastro;
    private String nome;
    private String usuario;
    private String departamento;
    private String filial;
    private String cargo;
    private String hashSenha;

    public Funcionario(Timestamp dataDeCadastro, String nome, String usuario, String departamento, String filial, String cargo, String hashSenha) {
        
        this.dataDeCadastro = dataDeCadastro;
        this.nome = nome;
        this.usuario = usuario;
        this.departamento = departamento;
        this.filial = filial;
        this.cargo = cargo;
        this.hashSenha = hashSenha;
    }

    public String getHashSenha() {
        return hashSenha;
    }

    public void setHashSenha(String hashSenha) {
        this.hashSenha = hashSenha;
    }

    

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
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

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
    
    public String getFilial(){
        return filial;
    }
    
    public void setFilial(String filial){
        this.filial = filial;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public boolean verificarSenha(String senhaAberta) {
        return BCrypt.checkpw(senhaAberta, hashSenha);
    }
}
