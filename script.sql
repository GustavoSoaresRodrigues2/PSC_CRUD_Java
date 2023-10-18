-- Active: 1697581866223@@mysql-14dac390-bd-aiven.aivencloud.com@23087@defaultdb
USE defaultdb;
CREATE TABLE tb_pessoa(
	cod_pessoa INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(200) NOT NULL,
    fone VARCHAR(200) NOT NULL,
    email VARCHAR(200) NOT NULL,
    ativo TINYINT NOT NULL
);
INSERT tb_pessoa
    (nome, fone, email, ativo)
VALUES
    ('Ana', '77447744', 'ana@email.com', 1);

SELECT * FROM tb_pessoa;
