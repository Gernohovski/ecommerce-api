CREATE TABLE carrinhos (
    car_id BIGSERIAL PRIMARY KEY,
    car_data_expiracao TIMESTAMP,
    car_data_criacao TIMESTAMP,
    car_comprado BOOLEAN NOT NULL,
    clt_id BIGINT,
    CONSTRAINT fk_carrinho_cliente FOREIGN KEY (clt_id) REFERENCES clientes(clt_id)
);

CREATE TABLE itens_carrinho (
    itc_id BIGSERIAL PRIMARY KEY,
    car_id BIGINT,
    liv_id BIGINT,
    itc_quantidade INTEGER,
    CONSTRAINT fk_itemcarrinho_carrinho FOREIGN KEY (car_id) REFERENCES carrinhos(car_id),
    CONSTRAINT fk_itemcarrinho_livro FOREIGN KEY (liv_id) REFERENCES livros(liv_id)
);

CREATE TABLE estoques (
    est_id BIGSERIAL PRIMARY KEY
);

CREATE TABLE itens_estoque (
    ite_id BIGSERIAL PRIMARY KEY,
    est_id BIGINT,
    liv_id BIGINT,
    ite_quantidade INTEGER,
    CONSTRAINT fk_itemestoque_estoque FOREIGN KEY (est_id) REFERENCES estoques(est_id),
    CONSTRAINT fk_itemestoque_livro FOREIGN KEY (liv_id) REFERENCES livros(liv_id)
);

CREATE TABLE situacoes_pedido (
    stp_id BIGSERIAL PRIMARY KEY,
    stp_nome VARCHAR(255)
);

CREATE TABLE pedidos (
    ped_id BIGSERIAL PRIMARY KEY,
    stp_id BIGINT,
    car_id BIGINT,
    ped_data_pedido DATE,
    ers_id BIGINT,
    clt_id BIGINT,
    CONSTRAINT fk_pedido_situacao FOREIGN KEY (stp_id) REFERENCES situacoes_pedido(stp_id),
    CONSTRAINT fk_pedido_carrinho FOREIGN KEY (car_id) REFERENCES carrinhos(car_id),
    CONSTRAINT fk_pedido_endereco FOREIGN KEY (ers_id) REFERENCES enderecos_residencial(ers_id),
    CONSTRAINT fk_pedido_cliente FOREIGN KEY (clt_id) REFERENCES clientes(clt_id)
);

CREATE TABLE pedido_cartao (
    ped_id BIGINT,
    crc_id BIGINT,
    PRIMARY KEY (ped_id, crc_id),
    CONSTRAINT fk_pedido_cartao_pedido FOREIGN KEY (ped_id) REFERENCES pedidos(ped_id),
    CONSTRAINT fk_pedido_cartao_cartao FOREIGN KEY (crc_id) REFERENCES cartoes_credito(crc_id)
);

