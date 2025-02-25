CREATE TABLE bandeiras_cartao (
    bnc_id BIGSERIAL PRIMARY KEY,
    bnc_nome VARCHAR(20) NOT NULL
);

CREATE TABLE tipos_telefone (
    tpf_id BIGSERIAL PRIMARY KEY,
    tpf_nome VARCHAR(20) NOT NULL
);

CREATE TABLE tipos_logradouro (
    tpl_id BIGSERIAL PRIMARY KEY,
    tpl_nome VARCHAR(20) NOT NULL
);

CREATE TABLE tipos_residencia (
    tpr_id BIGSERIAL PRIMARY KEY,
    tpr_nome VARCHAR(20) NOT NULL
);

CREATE TABLE generos (
    gen_id BIGSERIAL PRIMARY KEY,
    gen_nome VARCHAR(20) NOT NULL
);

CREATE TABLE telefones (
    tlf_id BIGSERIAL PRIMARY KEY,
    tlf_ddd VARCHAR(10) NOT NULL,
    tlf_telefone VARCHAR(20) NOT NULL,
    tlf_tpf_id BIGINT,
    FOREIGN KEY (tlf_tpf_id) REFERENCES tipos_telefone(tpf_id)
);

CREATE TABLE clientes (
    clt_id BIGSERIAL PRIMARY KEY,
    clt_gen_id BIGINT,
    clt_nome VARCHAR(100) NOT NULL,
    clt_data_nascimento DATE,
    clt_cpf VARCHAR(14) NOT NULL,
    clt_email VARCHAR(50) NOT NULL,
    clt_senha VARCHAR(255) NOT NULL,
    clt_ativo BOOLEAN NOT NULL,
    clt_tlf_id BIGINT,
    FOREIGN KEY (clt_gen_id) REFERENCES generos(gen_id),
    FOREIGN KEY (clt_tlf_id) REFERENCES telefones(tlf_id)
);

CREATE TABLE cartoes_credito (
    crc_id BIGSERIAL PRIMARY KEY,
    crc_numero VARCHAR(30) NOT NULL,
    crc_nome_impresso VARCHAR(100) NOT NULL,
    crc_bnc_id BIGINT,
    crc_codigo_segurança VARCHAR(10) NOT NULL,
    crc_clt_id BIGINT,
    FOREIGN KEY (crc_bnc_id) REFERENCES bandeiras_cartao(bnc_id),
    FOREIGN KEY (crc_clt_id) REFERENCES clientes(clt_id)
);

CREATE TABLE enderecos_cobranca (
    ecb_id BIGSERIAL PRIMARY KEY,
    ecb_tpr_id BIGINT,
    ecb_tpl_id BIGINT,
    ecb_logradouro VARCHAR(200) NOT NULL,
    ecb_numero VARCHAR(20) NOT NULL,
    ecb_bairro VARCHAR(100) NOT NULL,
    ecb_estado VARCHAR(50) NOT NULL,
    ecb_cidade VARCHAR(100) NOT NULL,
    ecb_pais VARCHAR(100) NOT NULL,
    ecb_cep VARCHAR(20) NOT NULL,
    ecb_observacoes TEXT,
    ecb_frase_identificacao VARCHAR(150),
    ecb_clt_id BIGINT,
    FOREIGN KEY (ecb_tpr_id) REFERENCES tipos_residencia(tpr_id),
    FOREIGN KEY (ecb_tpl_id) REFERENCES tipos_logradouro(tpl_id),
    FOREIGN KEY (ecb_clt_id) REFERENCES clientes(clt_id)
);

CREATE TABLE enderecos_entrega (
    eet_id BIGSERIAL PRIMARY KEY,
    eet_tpr_id BIGINT,
    eet_tpl_id BIGINT,
    eet_logradouro VARCHAR(200) NOT NULL,
    eet_numero VARCHAR(20) NOT NULL,
    eet_bairro VARCHAR(100) NOT NULL,
    eet_estado VARCHAR(50) NOT NULL,
    eet_cidade VARCHAR(100) NOT NULL,
    eet_pais VARCHAR(100) NOT NULL,
    eet_cep VARCHAR(20) NOT NULL,
    eet_observacoes TEXT,
    eet_frase_identificacao VARCHAR(150),
    eet_clt_id BIGINT,
    FOREIGN KEY (eet_tpr_id) REFERENCES tipos_residencia(tpr_id),
    FOREIGN KEY (eet_tpl_id) REFERENCES tipos_logradouro(tpl_id),
    FOREIGN KEY (eet_clt_id) REFERENCES clientes(clt_id)
);

CREATE TABLE enderecos_residencial (
    ers_id BIGSERIAL PRIMARY KEY,
    ers_tpr_id BIGINT,
    ers_tpl_id BIGINT,
    ers_logradouro VARCHAR(200) NOT NULL,
    ers_numero VARCHAR(20) NOT NULL,
    ers_bairro VARCHAR(100) NOT NULL,
    ers_estado VARCHAR(50) NOT NULL,
    ers_cidade VARCHAR(100) NOT NULL,
    ers_pais VARCHAR(100) NOT NULL,
    ers_cep VARCHAR(20) NOT NULL,
    ers_observacoes TEXT,
    ers_frase_identificacao VARCHAR(150),
    ers_clt_id BIGINT,
    FOREIGN KEY (ers_tpr_id) REFERENCES tipos_residencia(tpr_id),
    FOREIGN KEY (ers_tpl_id) REFERENCES tipos_logradouro(tpl_id),
    FOREIGN KEY (ers_clt_id) REFERENCES clientes(clt_id)
);
