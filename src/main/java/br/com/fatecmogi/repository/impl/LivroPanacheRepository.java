package br.com.fatecmogi.repository.impl;

import br.com.fatecmogi.controller.dto.livro.LivroFiltroDTO;
import br.com.fatecmogi.controller.dto.paginacao.PaginacaoDTO;
import br.com.fatecmogi.controller.response.CustomPage;
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
import java.util.Optional;
import java.util.stream.Collectors;

@ApplicationScoped
public class LivroPanacheRepository implements LivroRepository {

	@Inject
	RedisService redisService;

	@Inject
	PanacheLivroMapper panacheLivroMapper;

	@Override
	public CustomPage<Livro> findAll(LivroFiltroDTO filtro, PaginacaoDTO paginacao) {
		List<Livro> livros = panacheLivroMapper.from(filtrarLivros(filtro, paginacao));
		Long total = PanacheLivro.findAll().count();
		return CustomPage.<Livro>builder().content(livros).count(total.intValue()).build();
	}

	@Override
	public Livro update(Livro livro) {
		PanacheLivro panacheLivro = PanacheLivro.findById(livro.getId());
		panacheLivro.unreferenceDependecies();
		panacheLivro = panacheLivroMapper.update(panacheLivro, livro);
		panacheLivro.persist();
		return panacheLivroMapper.from(panacheLivro);
	}

	@Override
	public Optional<Livro> findById(Long id) {
		PanacheLivro panacheLivro = PanacheLivro.findById(id);
		if (panacheLivro == null) {
			return Optional.empty();
		}
		return Optional.of(panacheLivroMapper.from(panacheLivro));
	}

	@Override
	public List<Livro> findAll() {
		List<PanacheLivro> panacheLivros = PanacheLivro.findAll().list();
		return panacheLivroMapper.from(panacheLivros);
	}

	public List<PanacheLivro> filtrarLivros(LivroFiltroDTO filtro, PaginacaoDTO paginacao) {
		StringBuilder query = new StringBuilder(
				"SELECT DISTINCT l FROM PanacheLivro l JOIN l.categorias c JOIN l.idioma i WHERE 1=1");
		Map<String, Object> params = new HashMap<>();
		if (filtro.categoriaId != null) {
			query.append(" AND c.id = :categoriaId");
			params.put("categoriaId", filtro.categoriaId);
		}
		if (filtro.titulo != null) {
			query.append(" AND LOWER(titulo) LIKE LOWER(:titulo)");
			params.put("titulo", "%" + filtro.titulo + "%");
		}
		if (filtro.autoresId != null && !filtro.autoresId.isEmpty()) {
			query.append(" AND autor.id IN ("
					+ filtro.autoresId.stream().map(String::valueOf).collect(Collectors.joining(",")) + ")");
		}
		if (filtro.precoMin != null) {
			query.append(" AND valorVenda >= :precoMin");
			params.put("precoMin", filtro.precoMin);
		}
		if (filtro.precoMax != null) {
			query.append(" AND valorVenda <= :precoMax");
			params.put("precoMax", filtro.precoMax);
		}
		if (filtro.condicao != null && !filtro.condicao.isEmpty()) {
			query.append(" AND condicao = :condicao");
			params.put("condicao", filtro.condicao);
		}
		if (filtro.idioma != null && !filtro.idioma.isEmpty()) {
			query.append(" AND idioma.id IN ("
					+ filtro.idioma.stream().map(String::valueOf).collect(Collectors.joining(",")) + ")");
		}
		String orderBy = " ORDER BY " + filtro.sortBy + " "
				+ (filtro.sortDirection.equalsIgnoreCase("DESC") ? "DESC" : "ASC");
		return PanacheLivro.find(query + orderBy, params).page(paginacao.getPage(), paginacao.getSize()).list();
	}

	private String gerarChaveCache(LivroFiltroDTO filtro, PaginacaoDTO paginacao) {
		return "livros:" + "categoria=" + filtro.categoriaId + ":titulo="
				+ (filtro.titulo != null ? filtro.titulo.toLowerCase() : "null") + ":autores=" + filtro.autoresId
				+ ":precoMin=" + filtro.precoMin + ":precoMax=" + filtro.precoMax + ":condicao=" + filtro.condicao
				+ ":idioma=" + filtro.idioma + ":sortBy=" + filtro.sortBy + ":sortDirection=" + filtro.sortDirection
				+ ":pagina=" + paginacao.getPage() + ":tamanho=" + paginacao.getSize();
	}

}
