INSERT INTO situacoes_pedido (stp_nome) VALUES
('troca-recebida');

CREATE TABLE itens_pedido (
    itp_id BIGSERIAL PRIMARY KEY,
    car_id BIGINT,
    liv_id BIGINT,
    ped_id BIGINT,
    itp_quantidade INTEGER,
    itp_valor NUMERIC(10,2),
    CONSTRAINT fk_item_pedido_carrinho FOREIGN KEY (car_id) REFERENCES carrinhos(car_id),
    CONSTRAINT fk_item_pedido_livro FOREIGN KEY (liv_id) REFERENCES livros(liv_id),
    CONSTRAINT fk_item_pedido_pedido FOREIGN KEY (ped_id) REFERENCES pedidos(ped_id)
);