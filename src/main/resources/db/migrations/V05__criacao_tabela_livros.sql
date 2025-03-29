CREATE TABLE autores (
    aut_id BIGSERIAL PRIMARY KEY,
    aut_nome VARCHAR(255) NOT NULL
);

CREATE TABLE categorias_livros (
    ctl_id BIGSERIAL PRIMARY KEY,
    ctl_nome VARCHAR(255) NOT NULL
);

CREATE TABLE editoras (
    edt_id BIGSERIAL PRIMARY KEY,
    edt_nome VARCHAR(255) NOT NULL
);

CREATE TABLE grupos_precificacao (
    grp_id BIGSERIAL PRIMARY KEY,
    grp_nome VARCHAR(255) NOT NULL,
    grp_margem_lucro NUMERIC(10,2) NOT NULL
);

CREATE TABLE livros (
    liv_id BIGSERIAL PRIMARY KEY,
    liv_aut_id BIGINT REFERENCES autores(aut_id),
    liv_ano_publicacao VARCHAR(4),
    liv_titulo VARCHAR(255) NOT NULL,
    liv_editora BIGINT REFERENCES editoras(edt_id),
    liv_edicao INT,
    liv_isbn VARCHAR(20),
    liv_numero_paginas INT,
    liv_sinopse TEXT,
    liv_altura NUMERIC(10,2),
    liv_largura NUMERIC(10,2),
    liv_peso NUMERIC(10,2),
    liv_profundidade NUMERIC(10,2),
    liv_codigo_barras VARCHAR(50),
    liv_grp_id BIGINT REFERENCES grupos_precificacao(grp_id),
    liv_valor_venda NUMERIC(10,2),
    liv_capa TEXT,
    liv_ativo BOOLEAN DEFAULT FALSE
);

CREATE TABLE livros_categorias (
    liv_id BIGINT REFERENCES livros(liv_id) ON DELETE CASCADE,
    ctl_id BIGINT REFERENCES categorias_livros(ctl_id) ON DELETE CASCADE,
    PRIMARY KEY (liv_id, ctl_id)
);

CREATE TABLE categorias_status (
    cts_id BIGSERIAL PRIMARY KEY,
    cts_nome VARCHAR(255) NOT NULL
);

CREATE TABLE registro_status_livro (
    rsl_id BIGSERIAL PRIMARY KEY,
    rsl_liv_id BIGINT REFERENCES livros(liv_id) ON DELETE CASCADE,
    rsl_justificativa TEXT,
    rsl_cts_id BIGINT REFERENCES categorias_status(cts_id),
    rsl_data_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
