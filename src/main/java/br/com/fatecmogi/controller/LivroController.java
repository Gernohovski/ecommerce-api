package br.com.fatecmogi.controller;

import br.com.fatecmogi.controller.dto.livro.LivroFiltroDTO;
import br.com.fatecmogi.controller.dto.paginacao.PaginacaoDTO;
import br.com.fatecmogi.service.LivroService;
import jakarta.inject.Inject;
import jakarta.ws.rs.BeanParam;
import jakarta.ws.rs.core.Response;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/livros")
public class LivroController {

	@Inject
	LivroService livroService;

	@GetMapping
	public Response listarComFiltros(@BeanParam LivroFiltroDTO filtro, @BeanParam PaginacaoDTO paginacao) {
		var livros = livroService.listarComFiltros(filtro, paginacao);
		return Response.ok(livros).build();
	}

}
