/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.astec.model.constants;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Usuário
 */
public enum LogAcao {
    
    CONSULTA("Consultou"), INCLUSAO("Incluiu"), ALTERACAO("Alterou"),
    REMOCAO("Removeu"),VENDA("Vendeu");
    
    private String valor;
    
    private LogAcao(String valor){
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
    
    
    public List<LogAcao> getList(){
        return Collections.unmodifiableList(Arrays.asList(values()));
    }
    
    
    
}
