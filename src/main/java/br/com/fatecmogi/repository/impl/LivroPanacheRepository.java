package br.com.fatecmogi.repository.impl;

import br.com.fatecmogi.controller.dto.livro.LivroFiltroDTO;
import br.com.fatecmogi.controller.dto.paginacao.PaginacaoDTO;
import br.com.fatecmogi.model.entity.livro.Livro;
import br.com.fatecmogi.model.repository.LivroRepository;
import br.com.fatecmogi.repository.mapper.PanacheLivroMapper;
import br.com.fatecmogi.repository.table.PanacheLivro;
import br.com.fatecmogi.service.impl.RedisService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class LivroPanacheRepository implements LivroRepository {

	@Inject
	RedisService redisService;

	@Inject
	PanacheLivroMapper panacheLivroMapper;

	@Override
	public List<Livro> findAll(LivroFiltroDTO filtro, PaginacaoDTO paginacao) {
		String cacheKey = gerarChaveCache(filtro, paginacao);
		List<Livro> livrosCacheados = redisService.buscarLivrosNoCache(cacheKey);
		if (livrosCacheados != null) {
			return livrosCacheados;
		}
		List<Livro> livros = panacheLivroMapper.from(filtrarLivros(filtro, paginacao));
		redisService.salvarLivrosNoCache(cacheKey, livros);
		return livros;
	}

	public List<PanacheLivro> filtrarLivros(LivroFiltroDTO filtro, PaginacaoDTO paginacao) {
		StringBuilder query = new StringBuilder("1=1");
		Map<String, Object> params = new HashMap<>();
		if (filtro.categoriaId != null) {
			query.append(" AND categoria.id = :categoriaId");
			params.put("categoriaId", filtro.categoriaId);
		}
		if (filtro.titulo != null) {
			query.append(" AND titulo like :titulo");
			params.put("titulo", "%" + filtro.titulo + "%");
		}
		if (filtro.autoresId != null && !filtro.autoresId.isEmpty()) {
			query.append(" AND autor.id IN (:autoresId)");
			params.put("autoresId", filtro.autoresId);
		}
		if (filtro.precoMin != null) {
			query.append(" AND preco >= :precoMin");
			params.put("precoMin", filtro.precoMin);
		}
		if (filtro.precoMax != null) {
			query.append(" AND preco <= :precoMax");
			params.put("precoMax", filtro.precoMax);
		}
		if (filtro.condicao != null && !filtro.condicao.isEmpty()) {
			query.append(" AND condicao = :condicao");
			params.put("condicao", filtro.condicao);
		}
		if (filtro.idioma != null && !filtro.idioma.isEmpty()) {
			query.append(" AND idioma = :idioma");
			params.put("idioma", filtro.idioma);
		}
		String orderBy = " ORDER BY " + filtro.sortBy + " "
				+ (filtro.sortDirection.equalsIgnoreCase("DESC") ? "DESC" : "ASC");
		return PanacheLivro.find(query + orderBy, params).page(paginacao.getPage(), paginacao.getSize()).list();
	}

	private String gerarChaveCache(LivroFiltroDTO filtro, PaginacaoDTO paginacao) {
		return "livros:" + "categoria=" + filtro.categoriaId + "titulo=" + filtro.titulo + ":autores="
				+ filtro.autoresId + ":precoMin=" + filtro.precoMin + ":precoMax=" + filtro.precoMax + ":condicao="
				+ filtro.condicao + ":idioma=" + filtro.idioma + ":sortBy=" + filtro.sortBy + ":sortDirection="
				+ filtro.sortDirection + ":pagina=" + paginacao.getPage() + ":tamanho=" + paginacao.getSize();
	}

}
