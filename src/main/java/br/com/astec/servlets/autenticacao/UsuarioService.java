/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.astec.servlets.autenticacao;

import br.com.astec.model.dao.funcionario.FuncionarioDao;
import br.com.astec.model.entidades.Funcionario;
import java.sql.SQLException;

/**
 *
 * @author fernando.tsuda
 */
public class UsuarioService {

    //private static final Map<String, UsuarioSistema> USUARIOS_CADASTRADOS;

    /*static {
        USUARIOS_CADASTRADOS
                = new LinkedHashMap<String, UsuarioSistema>();
        USUARIOS_CADASTRADOS.put("rale",
                new UsuarioSistema("Ralé da Silva",
                        "rale", "abcd1234", Arrays.asList("BASICO")));
        USUARIOS_CADASTRADOS.put("fodinha",
                new UsuarioSistema("Fodinha de Souza",
                        "fodinha", "abcd1234", Arrays.asList("BASICO", "ADMIN")));
        USUARIOS_CADASTRADOS.put("fodao",
                new UsuarioSistema("Fodao di Caprio",
                        "fodao", "abcd1234", Arrays.asList("BASICO", "ADMIN", "GOD")));
    }*/
    public Funcionario autenticar(String username, String senha) throws SQLException, Exception {
        Funcionario usuario = new Funcionario();

        try {
                FuncionarioDao autenticar = new FuncionarioDao();
                autenticar.loginFuncionario(username, senha);
                return usuario;
        } catch (Exception e) {
            e.getMessage();
        }

        return null;
        
    }

    public boolean usuarioAutorizado(Funcionario usuario){
            //String funcionalidade) {
        if (usuario.getDepartamento().equalsIgnoreCase("diretoria")){//temPapel("BASICO")) {
            return true;
        } //else if (usuario.getDepartamento().equalsIgnoreCase("diretoria")){//usuario.temPapel("ADMIN")) {
            //return true;
        //}
        return false;
    }
}
