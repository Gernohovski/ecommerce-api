ALTER TABLE enderecos_entrega ADD eet_temporario BOOLEAN;
ALTER TABLE enderecos_cobranca ADD ecb_temporario BOOLEAN;
ALTER TABLE enderecos_residencial ADD ers_temporario BOOLEAN;
ALTER TABLE cartoes_credito ADD crc_temporario BOOLEAN;

UPDATE enderecos_entrega SET eet_temporario = FALSE WHERE eet_temporario IS NULL;
UPDATE enderecos_cobranca SET ecb_temporario = FALSE WHERE ecb_temporario IS NULL;
UPDATE enderecos_residencial SET ers_temporario = FALSE WHERE ers_temporario IS NULL;
UPDATE cartoes_credito SET crc_temporario = FALSE WHERE crc_temporario IS NULL;