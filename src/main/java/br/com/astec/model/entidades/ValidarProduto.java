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
 * @author rafael
 */
public class ValidarProduto {

    public boolean ehPalavra(Produto produto) {
        boolean d = true;
        List<Produto> lista = new ArrayList();
        lista.add(produto);
        for (Produto y : lista) {
            if (y.getNomeProduto().isEmpty() || !y.getNomeProduto().matches("[a-zA-Z\\s]+")) {
                d = false;
            } else if (y.getCategoria().isEmpty() || !y.getCategoria().matches("[a-zA-Z\\s]+")) {
                d = false;
            } else if (y.getCor().isEmpty() || !y.getCor().matches("[a-zA-Z\\s]+")) {
                d = false;
            } else if (y.getDescricao().isEmpty() || !y.getDescricao().matches("[a-zA-Z\\s]+")) {
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
