package br.com.fatecmogi.controller;

import br.com.fatecmogi.controller.dto.cupom.GerarCupomPromocionalCommand;
import br.com.fatecmogi.service.CupomService;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/cupons")
public class CupomController {

	@Inject
	CupomService cupomService;

	@PostMapping
	public Response cadastrar(@RequestBody GerarCupomPromocionalCommand command) {
		var cupom = cupomService.gerarCupom(command);
		return Response.status(Response.Status.CREATED).entity(cupom).build();
	}

	@GetMapping("/{codigo}")
	public Response buscar(@PathVariable("codigo") String codigo) {
		var cupom = cupomService.buscarCupom(codigo);
		return Response.status(Response.Status.OK).entity(cupom).build();
	}

}
