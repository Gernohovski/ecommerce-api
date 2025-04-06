CREATE TABLE cupons_promocionais (
    cpp_id BIGSERIAL PRIMARY KEY,
    cpp_porcentagem_desconto DOUBLE PRECISION,
    cpp_data_expiracao TIMESTAMP,
    cpp_codigo VARCHAR(255)
);
