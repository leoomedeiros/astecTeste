/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Fernando
 * Created: 14/10/2017
 */


INSERT INTO produto 
VALUES (default, '1960-01-01 23:03:20', 'velho pra caralho', 'masculino', 'preto', 39, 2, 'esportivo', 150);
select depar, usuario, senha,id_funcionario from funcionario"
                + "where usuario='leo' AND senha='leo';

select max(id_prod) from produto;

select id_prod from produto where id_prod=(Select max(id_prod) from produto);