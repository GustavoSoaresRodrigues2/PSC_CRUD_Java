CREATE DATABASE 20232_usjt_psc_segunda_pessoasv2;
USE 20232_usjt_psc_segunda_pessoasv2;
CREATE TABLE tb_pessoa(
	cod_pessoa INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(200) NOT NULL,
    fone VARCHAR(200) NOT NULL,
    email VARCHAR(200) NOT NULL,
    ativo TINYINT NOT NULL
);
INSERT tb_pessoa(nome, fone, email, ativo)
VALUES
('Ana', '77447744', 'ana@email.com', 1);

SELECT * FROM tb_pessoa;