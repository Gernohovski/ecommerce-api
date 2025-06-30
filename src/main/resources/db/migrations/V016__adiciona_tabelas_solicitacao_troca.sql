CREATE TABLE itens_troca (
    ita_id BIGSERIAL PRIMARY KEY,
    ita_quantidade INTEGER,
    itp_id BIGINT,
        CONSTRAINT fk_itens_devolucao_itens_pedido
        FOREIGN KEY (itp_id)
        REFERENCES itens_pedido (itp_id)
);

CREATE TABLE solicitacoes_troca (
    stc_id BIGSERIAL PRIMARY KEY,
    ped_id BIGINT,
    CONSTRAINT fk_solicitacoes_troca_pedido
        FOREIGN KEY (ped_id)
        REFERENCES pedidos (ped_id)
);

CREATE TABLE itens_troca_solicitacao_troca (
    stc_id BIGINT NOT NULL,
    ita_id BIGINT NOT NULL,
    PRIMARY KEY (stc_id, ita_id),
    CONSTRAINT fk_icst_solicitacao
        FOREIGN KEY (stc_id)
        REFERENCES solicitacoes_troca (stc_id),
    CONSTRAINT fk_icst_item_troca
        FOREIGN KEY (ita_id)
        REFERENCES itens_troca (ita_id)
);
