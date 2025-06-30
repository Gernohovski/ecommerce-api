INSERT INTO situacoes_pedido (stp_nome) VALUES
('devolucao-solicitada'),
('devolucao-aprovada'),
('devolucao-recusada'),
('devolucao-recebida'),
('devolucao-finalizada');

CREATE TABLE itens_devolucao (
    itd_id BIGSERIAL PRIMARY KEY,
    itd_quantidade INTEGER,
    itp_id BIGINT,
        CONSTRAINT fk_itens_devolucao_itens_pedido
            FOREIGN KEY (itp_id)
            REFERENCES itens_pedido (itp_id)
);

CREATE TABLE solicitacoes_devolucao (
    std_id BIGSERIAL PRIMARY KEY,
    ped_id BIGINT,
    CONSTRAINT fk_solicitacoes_devolucao_pedido
        FOREIGN KEY (ped_id)
        REFERENCES pedidos (ped_id)
);

CREATE TABLE itens_devolucao_solicitacao_devolucao (
    std_id BIGINT NOT NULL,
    itd_id BIGINT NOT NULL,
    PRIMARY KEY (std_id, itd_id),
    CONSTRAINT fk_icst_solicitacao
        FOREIGN KEY (std_id)
        REFERENCES solicitacoes_devolucao (std_id),
    CONSTRAINT fk_icst_item_devolucao
        FOREIGN KEY (itd_id)
        REFERENCES itens_devolucao (itd_id)
);


