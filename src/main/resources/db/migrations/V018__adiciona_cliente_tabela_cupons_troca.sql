ALTER TABLE cupons_troca
ADD cpt_clt_id BIGINT,
ADD CONSTRAINT fk_cupons_troca_cliente FOREIGN KEY (cpt_clt_id) REFERENCES clientes (clt_id);
