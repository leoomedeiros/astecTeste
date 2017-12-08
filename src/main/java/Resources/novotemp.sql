
CREATE TABLE CLIENTE (
id_cliente INT NOT NULL 
        GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1),
datas TIMESTAMP NOT NULL, 
nome VARCHAR(255) NOT NULL,
cpf VARCHAR(30) NOT NULL,
endereco VARCHAR(255),
telefone VARCHAR(30) NOT NULL,
PRIMARY KEY (id_cliente)
);


CREATE TABLE PRODUTO(
id_prod INT NOT NULL 
        GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1),
datas TIMESTAMP NOT NULL,
nome VARCHAR(255) NOT NULL,
categoria VARCHAR(100) NOT NULL ,
cor VARCHAR(100) NOT NULL,
tamanho INT NOT NULL ,
quantidade_estoque INT NOT NULL,
descr VARCHAR(255),
preco DOUBLE NOT NULL,
PRIMARY KEY (id_prod)
);

CREATE TABLE FILIAL (
id_filial INT NOT NULL 
        GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1),
nome_filial VARCHAR(50) NOT NULL, 
PRIMARY KEY (id_filial)
);

INSERT INTO FILIAL (nome_filial)
VALUES
('São Paulo'),
('Recife'),
('Porto Alegre');

SELECT * FROM FILIAL;

CREATE TABLE DEPARTAMENTO (
id_depar INT NOT NULL 
        GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1),
nome_depar VARCHAR(50) NOT NULL, 
PRIMARY KEY (id_depar)
);

INSERT INTO DEPARTAMENTO (nome_depar) VALUES
('Diretora'),
('Gerente de Produtos/Serviços (retaguarda)'),
('Gerente de Vendas'),
('Gerente de TI'),
('Funcionários da retaguarda'),
('Equipe de vendedores'),
('Equipe de suporte técnico');

SELECT * FROM DEPARTAMENTO;
SELECT * FROM Funcionario;


CREATE TABLE FUNCIONARIO (
id_funcionario INT NOT NULL 
        GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1),
datas TIMESTAMP NOT NULL,
id_filial INT NOT NULL,
id_depar INT NOT NULL,
nome VARCHAR(255) NOT NULL,
cargo VARCHAR(50) NOT NULL,
senha VARCHAR(20) NOT NULL,
FOREIGN KEY (id_filial) REFERENCES FILIAL(id_filial),
FOREIGN KEY (id_depar) REFERENCES DEPARTAMENTO(id_depar),
PRIMARY KEY (id_funcionario)
);


CREATE TABLE VENDA (
    id_venda INT NOT NULL 
          GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1),
    datas TIMESTAMP NOT NULL,
    id_cliente INT NOT NULL,
    valorTotal DOUBLE NOT NULL,
    FOREIGN KEY (id_cliente) REFERENCES CLIENTE(id_cliente),
    PRIMARY KEY (id_venda)
);


/*ITEM DE PRODUTOS OU CARRINHO*/  
CREATE TABLE ITEMVENDA (
    id_itemVenda INT NOT NULL 
        GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1),
    id_venda INT NOT NULL,
    id_prod INT NOT NULL,
    qtdVenda INT NOT NULL,
    FOREIGN KEY (id_prod) REFERENCES PRODUTO (id_prod),
    FOREIGN KEY (id_venda) REFERENCES VENDA (id_venda)
);


/*LOG DO FUNCIONÁRIO*/  
CREATE TABLE LOG_FUNCIONARIO (
    id INT NOT NULL 
        GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1),
    id_funcionario INT NOT NULL,
    acao VARCHAR (255) NOT NULL, -- Incluiu, Alterou, Removeu, Consultou
    id_registro INT NOT NULL,
    nm_tabela VARCHAR (255) NOT NULL,
    data_acao TIMESTAMP NOT NULL,
    FOREIGN KEY (id_funcionario) REFERENCES FUNCIONARIO (id_funcionario)
);

SELECT Funcionario.id_funcionario, Funcionario.nome, Departamento.nome_depar, Filial.nome_filial, Funcionario.cargo FROM(( Funcionario
                INNER JOIN Departamento ON Funcionario.id_depar = Departamento.id_depar)
                INNER JOIN Filial ON Funcionario.id_filial = Filial.id_filial);
SELECT id_funcionario, nome, id_depar, id_filial, cargo FROM Funcionario
SELECT Funcionario.id_funcionario, Funcionario.nome, Filial.nome_filial, Funcionario.cargo FROM Funcionario, INNER JOIN Filial ON Funcionario.id_filial = Fiilal.id_filial;/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Fernando
 * Created: 24/11/2017
 */

