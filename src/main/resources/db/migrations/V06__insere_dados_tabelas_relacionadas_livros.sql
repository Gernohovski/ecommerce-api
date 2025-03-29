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
('Grupo A', 20.00),
('Grupo B', 15.50),
('Grupo C', 25.75),
('Grupo D', 18.00),
('Grupo E', 10.00),
('Grupo F', 30.50),
('Grupo G', 22.00),
('Grupo H', 28.25),
('Grupo I', 12.00),
('Grupo J', 19.50);

INSERT INTO grupos_precificacao (grp_nome, grp_margem_lucro) VALUES
('Ouro', 30.00),
('Prata', 20.00),
('Bronze', 10.00);

INSERT INTO categorias_status (cts_nome) VALUES
('Ativo'),
('Inativo');

INSERT INTO livros (
    liv_ano_publicacao, liv_titulo, liv_editora,
    liv_edicao, liv_isbn, liv_numero_paginas, liv_sinopse,
    liv_altura, liv_largura, liv_peso, liv_profundidade,
    liv_codigo_barras, liv_grp_id, liv_valor_venda, liv_ativo
) VALUES
('2007', 'Harry Potter e a Pedra Filosofal', 1, 1, '9780747532743', 223,
    'O jovem Harry Potter descobre que é um bruxo e parte para uma escola de magia.',
    21.0, 14.0, 0.5, 2.0, '1234567890123', 1, 39.90, TRUE),
('1996', 'A Guerra dos Tronos', 2, 1, '9780553103540', 694,
    'Primeiro livro da série "As Crônicas de Gelo e Fogo", onde intriga e guerra dominam o reino.',
    24.0, 16.0, 1.2, 3.0, '2345678901234', 2, 49.90, TRUE),
('1954', 'O Senhor dos Anéis: A Sociedade do Anel', 3, 1, '9780618574940', 423,
    'Frodo Baggins recebe a missão de destruir o Um Anel para salvar a Terra-média.',
    22.5, 15.5, 0.8, 2.5, '3456789012345', 3, 59.90, TRUE),
('2001', 'Fundação', 4, 1, '9780553293353', 295,
    'Uma obra de Isaac Asimov que mistura ficção científica e filosofia sobre o futuro da humanidade.',
    21.5, 14.5, 0.7, 2.0, '4567890123456', 1, 29.90, TRUE),
('1936', 'Assassinato no Expresso do Oriente', 5, 1, '9780062073501', 256,
    'A detetive Hercule Poirot investiga um assassinato a bordo de um trem.',
    20.0, 13.5, 0.6, 1.8, '5678901234567', 2, 34.90, TRUE);


