ALTER TABLE cartoes_credito ADD crc_principal BOOLEAN DEFAULT FALSE;
ALTER TABLE enderecos_residencial ADD ers_principal BOOLEAN DEFAULT FALSE;
ALTER TABLE enderecos_cobranca ADD ecb_principal BOOLEAN DEFAULT FALSE;
ALTER TABLE enderecos_entrega ADD eet_principal BOOLEAN DEFAULT FALSE;