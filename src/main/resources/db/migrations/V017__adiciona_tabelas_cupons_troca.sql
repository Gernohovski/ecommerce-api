CREATE TABLE cupons_troca (
    cpt_id BIGSERIAL PRIMARY KEY,
    cpt_valor_desconto  NUMERIC(10,2),
    cpt_codigo VARCHAR(255)
);
