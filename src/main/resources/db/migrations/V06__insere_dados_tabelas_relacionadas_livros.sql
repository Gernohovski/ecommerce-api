INSERT INTO autores (aut_nome) VALUES
('J.K. Rowling'),
('George R.R. Martin'),
('J.R.R. Tolkien'),
('Isaac Asimov'),
('Agatha Christie'),
('Arthur C. Clarke'),
('Philip K. Dick'),
('Neil Gaiman'),
('H.G. Wells'),
('Stephen King'),
('Mark Twain'),
('Jane Austen'),
('Charles Dickens'),
('F. Scott Fitzgerald'),
('Ernest Hemingway'),
('William Shakespeare'),
('Leo Tolstoy'),
('Dostoevsky'),
('Franz Kafka'),
('Haruki Murakami'),
('Kurt Vonnegut'),
('Toni Morrison'),
('Gabriel García Márquez'),
('Orson Welles'),
('Margaret Atwood'),
('Khaled Hosseini'),
('John Steinbeck'),
('George Orwell'),
('J.D. Salinger'),
('Chimamanda Ngozi Adichie');

INSERT INTO categorias_livros (ctl_nome) VALUES
('Ação'),
('Aventura'),
('Romance'),
('Fantasia'),
('Terror'),
('Ficção Científica'),
('Mistério'),
('Inteligente'),
('Tragédia');

INSERT INTO editoras (edt_nome) VALUES
('Penguin Random House'),
('HarperCollins'),
('Simon & Schuster'),
('Hachette Livre'),
('Macmillan Publishers'),
('Oxford University Press'),
('Wiley'),
('Pearson Education'),
('Bloomsbury Publishing'),
('Scholastic'),
('Alfred A. Knopf'),
('Little, Brown and Company'),
('Cambridge University Press'),
('Routledge'),
('Springer'),
('Harvard University Press'),
('Maconel & Co'),
('Penguin Books'),
('Prentice Hall'),
('Viking Press');

INSERT INTO grupos_precificacao (grp_nome, grp_margem_lucro) VALUES
('Ouro', 30.00),
('Prata', 20.00),
('Bronze', 10.00);

INSERT INTO categorias_status (cts_nome) VALUES
('Ativo'),
('Inativo');

INSERT INTO livros (
    liv_aut_id, liv_ano_publicacao, liv_titulo, liv_editora, liv_edicao, liv_isbn,
    liv_numero_paginas, liv_sinopse, liv_altura, liv_largura, liv_peso, liv_profundidade,
    liv_codigo_barras, liv_grp_id, liv_valor_venda, liv_ativo, liv_capa
) VALUES
(
    1, '1997', 'Harry Potter e a Pedra Filosofal', 9, 1, '978-8532511010',
    208, 'Primeiro livro da saga Harry Potter, onde o jovem descobre ser um bruxo.',
    21.0, 14.0, 0.45, 3.0, '9788532511010', 1, 39.90, TRUE, 'D:/Documentos/LES/ecommerce-api/src/main/resources/images/harry-potter-1.jpg'
),
(
    2, '1996', 'A Guerra dos Tronos', 1, 1, '978-8556511015',
    592, 'O primeiro livro da série As Crônicas de Gelo e Fogo.',
    23.5, 16.0, 0.80, 5.0, '9788556511015', 2, 49.90, TRUE, 'D:/Documentos/LES/ecommerce-api/src/main/resources/images/guerra-dos-tronos.jpg'
),
(
    3, '1954', 'O Senhor dos Anéis: A Sociedade do Anel', 5, 1, '978-8544001020',
    576, 'A primeira parte da trilogia de O Senhor dos Anéis.',
    22.0, 15.0, 0.70, 4.5, '9788544001020', 1, 59.90, TRUE, 'D:/Documentos/LES/ecommerce-api/src/main/resources/images/senhor-aneis-1.jpg'
),
(
    4, '1950', 'Eu, Robô', 7, 1, '978-8535908887',
    320, 'Uma coletânea de contos de ficção científica de Isaac Asimov.',
    21.0, 14.0, 0.50, 3.5, '9788535908887', 3, 29.90, TRUE, 'D:/Documentos/LES/ecommerce-api/src/main/resources/images/eu-robo.jpg'
),
(
    5, '1934', 'Assassinato no Expresso do Oriente', 10, 1, '978-8528613838',
    288, 'Um dos mais famosos mistérios de Agatha Christie.',
    20.5, 13.5, 0.40, 3.0, '9788528613838', 2, 34.90, TRUE, 'D:/Documentos/LES/ecommerce-api/src/main/resources/images/assassinato-expresso.jpg'
);



