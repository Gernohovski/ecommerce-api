package br.com.fatecmogi.controller;

import br.com.fatecmogi.controller.dto.livro.EditarLivroCommand;
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

	@PutMapping("/{id}")
	public Response atualizar(@PathVariable("id") Long id, @RequestBody EditarLivroCommand command) {
		var livroAtualizado = livroService.atualizar(id, command);
		return Response.ok(livroAtualizado).build();
	}

	@GetMapping("/{id}")
	public Response buscar(@PathVariable("id") Long id) {
		var livro = livroService.buscar(id);
		return Response.ok(livro).build();
	}

}
