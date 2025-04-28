INSERT INTO situacoes_pedido (stp_nome) VALUES
('devolucao-solicitada'),
('devolucao-aprovada'),
('devolucao-recusada'),
('devolucao-recebida'),
('devolucao-finalizada');

CREATE TABLE solicitacoes_devolucao (
    std_id BIGSERIAL PRIMARY KEY,
    ped_id BIGINT,
    CONSTRAINT fk_solicitacoes_devolucao_pedido
        FOREIGN KEY (ped_id)
        REFERENCES pedidos (ped_id)
);

CREATE TABLE itens_pedido_solicitacao_devolucao (
    std_id BIGINT NOT NULL,
    itp_id BIGINT NOT NULL,
    PRIMARY KEY (std_id, itp_id),
    CONSTRAINT fk_icst_solicitacao
        FOREIGN KEY (std_id)
        REFERENCES solicitacoes_devolucao (std_id),
    CONSTRAINT fk_icst_item_pedido
        FOREIGN KEY (itp_id)
        REFERENCES itens_pedido (itp_id)
);


