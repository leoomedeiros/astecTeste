/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Fernando
 * Created: 10/11/2017
 */

CREATE TABLE CLIENTE (
id_cliente INT NOT NULL 
        GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1),
datas TIMESTAMP NOT NULL, 
nome VARCHAR(255) NOT NULL,
cpf VARCHAR(14) NOT NULL,
endereco VARCHAR(255),
telefone VARCHAR(30) NOT NULL,
PRIMARY KEY (id_cliente)
);

INSERT INTO cliente 
VALUES (default, '1960-01-01 23:03:20', 'Jose', '333.333.333-64', 'Rua final 10', '98765-4321');