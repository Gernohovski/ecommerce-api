package br.com.fatecmogi.controller;

import br.com.fatecmogi.controller.dto.frete.CalcularFreteCommand;
import br.com.fatecmogi.service.FreteService;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/fretes")
public class FreteController {

	@Inject
	FreteService freteService;

	@PostMapping
	public Response calcularFrete(@RequestBody CalcularFreteCommand command) {
		var frete = freteService.calcularFrete(command);
		return Response.status(Response.Status.OK).entity(frete).build();
	}

}
