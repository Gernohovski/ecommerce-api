package br.com.fatecmogi.controller;

import br.com.fatecmogi.controller.dto.cliente.*;
import br.com.fatecmogi.service.ClienteService;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/clientes")
public class ClienteController {

	@Inject
	ClienteService clienteService;

	@PostMapping
	public Response salvar(@RequestBody CadastrarClienteCommand command) {
		var cliente = clienteService.salvar(command);
		return Response.status(Response.Status.CREATED).entity(cliente).build();
	}

	@PutMapping("/{id}")
	public Response atualizar(@PathVariable("id") Long id, @RequestBody EditarClienteCommand command) {
		var cliente = clienteService.atualizar(id, command);
		return Response.status(Response.Status.OK).entity(cliente).build();
	}

	@PutMapping("/{id}/senhas")
	public Response atualizarSenha(@PathVariable("id") Long id, @RequestBody EditarSenhaClienteCommand command) {
		var cliente = clienteService.atualizarSenha(id, command);
		return Response.status(Response.Status.OK).entity(cliente).build();
	}

	@GetMapping("/{id}")
	public Response buscar(@PathVariable("id") Long id) {
		var cliente = clienteService.buscar(id);
		return Response.status(Response.Status.OK).entity(cliente).build();
	}

	@DeleteMapping("/{id}")
	public Response deletar(@PathVariable("id") Long id) {
		clienteService.deletar(id);
		return Response.status(Response.Status.NO_CONTENT).build();
	}

	@PutMapping("/{id}/inativar")
	public Response inativar(@PathVariable("id") Long id) {
		var cliente = clienteService.inativar(id);
		return Response.status(Response.Status.OK).entity(cliente).build();
	}

	@PutMapping("/login")
	public Response login(@RequestBody FazerLoginCommand command) {
		var cliente = clienteService.login(command);
		return Response.status(Response.Status.OK).entity(cliente).build();
	}

	@GetMapping
	public Response filtrar(@RequestParam int size, @RequestParam int page,
			@RequestParam(required = false) String termoPesquisa) {
		var command = FiltrarClienteCommand.builder().size(size).page(page).termoPesquisa(termoPesquisa).build();
		var clientes = clienteService.filtrarPaginacao(command);
		return Response.status(Response.Status.OK).entity(clientes).build();
	}

}
