UPDATE livros
SET liv_valor_venda = liv_valor_tabelado * (
    SELECT grp_margem_lucro / 100 + 1
    FROM grupos_precificacao gp
    WHERE gp.grp_id = livros.liv_grp_id
);
