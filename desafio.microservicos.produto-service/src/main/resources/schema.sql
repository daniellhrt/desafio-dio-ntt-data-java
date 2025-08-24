-- src/main/resources/schema.sql

-- Cria a tabela 'produto' se ela não existir
-- As colunas devem corresponder exatamente aos campos da sua classe Produto.
CREATE TABLE IF NOT EXISTS produto (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(255),
    descricao VARCHAR(255),
    preco DOUBLE,
    PRIMARY KEY (id)
);