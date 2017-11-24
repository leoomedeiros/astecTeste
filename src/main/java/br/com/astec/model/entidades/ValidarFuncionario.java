/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.astec.model.entidades;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fernando
 */
public class ValidarFuncionario {
   public boolean ehPalavra(Funcionario funcionario) {
        boolean d = true;
        List<Funcionario> lista = new ArrayList();
        lista.add(funcionario);
        for (Funcionario y : lista) {
            if (y.getNome().isEmpty() || !y.getNome().matches("[a-zA-Z\\s]+")) {
                d = false;
            } else if (y.getCargo().isEmpty() || !y.getCargo().matches("[a-zA-Z0-9\\s]+")) {
                d = false;
            } 
        }
        return d;
    }
//a validação dos campos numéricos é feita pela própria página web, mas vou deixar de exemplo.
    public boolean ehNumero(String numeros) {
        return numeros.matches("[0-9\\,\\.]+");
    }
 
}
