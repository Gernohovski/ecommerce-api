CREATE TABLE solicitacoes_troca (
    stc_id BIGSERIAL PRIMARY KEY,
    ped_id BIGINT,
    CONSTRAINT fk_solicitacoes_troca_pedido
        FOREIGN KEY (ped_id)
        REFERENCES pedidos (ped_id)
);

CREATE TABLE itens_pedido_solicitacao_troca (
    stc_id BIGINT NOT NULL,
    itp_id BIGINT NOT NULL,
    PRIMARY KEY (stc_id, itp_id),
    CONSTRAINT fk_icst_solicitacao
        FOREIGN KEY (stc_id)
        REFERENCES solicitacoes_troca (stc_id),
    CONSTRAINT fk_icst_item_pedido
        FOREIGN KEY (itp_id)
        REFERENCES itens_pedido (itp_id)
);
