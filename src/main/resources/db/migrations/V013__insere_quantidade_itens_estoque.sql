-- Insere primeiro estoque
INSERT INTO estoques DEFAULT VALUES;

-- Armazena dados de livros no primeiro estoque
INSERT INTO itens_estoque (est_id, liv_id, ite_quantidade) VALUES (1, 1, 10);
INSERT INTO itens_estoque (est_id, liv_id, ite_quantidade) VALUES (1, 2, 5);
INSERT INTO itens_estoque (est_id, liv_id, ite_quantidade) VALUES (1, 3, 8);
INSERT INTO itens_estoque (est_id, liv_id, ite_quantidade) VALUES (1, 4, 6);
INSERT INTO itens_estoque (est_id, liv_id, ite_quantidade) VALUES (1, 5, 7);