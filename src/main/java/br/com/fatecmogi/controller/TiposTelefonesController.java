package br.com.fatecmogi.controller;

import br.com.fatecmogi.service.TiposTelefoneService;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/tiposTelefones")
public class TiposTelefonesController {

	@Inject
	TiposTelefoneService tiposTelefoneService;

	@GetMapping
	public Response listar() {
		var tiposTelefones = tiposTelefoneService.findAll();
		return Response.status(Response.Status.OK).entity(tiposTelefones).build();
	}

}
