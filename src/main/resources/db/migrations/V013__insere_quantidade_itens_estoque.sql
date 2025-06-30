-- Insere primeiro estoque
INSERT INTO estoques DEFAULT VALUES;

-- Armazena dados de livros no primeiro estoque
INSERT INTO itens_estoque (est_id, liv_id, ite_quantidade) VALUES (1, 1, 20);
INSERT INTO itens_estoque (est_id, liv_id, ite_quantidade) VALUES (1, 2, 10);
INSERT INTO itens_estoque (est_id, liv_id, ite_quantidade) VALUES (1, 3, 0);
INSERT INTO itens_estoque (est_id, liv_id, ite_quantidade) VALUES (1, 4, 20);
INSERT INTO itens_estoque (est_id, liv_id, ite_quantidade) VALUES (1, 5, 35);