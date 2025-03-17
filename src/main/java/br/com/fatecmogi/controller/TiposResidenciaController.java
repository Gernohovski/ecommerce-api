package br.com.fatecmogi.controller;

import br.com.fatecmogi.service.TiposResidenciaService;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/tiposResidencia")
public class TiposResidenciaController {

	@Inject
	TiposResidenciaService tiposResidenciaService;

	@GetMapping
	public Response listar() {
		var tiposResidencia = tiposResidenciaService.findAll();
		return Response.status(Response.Status.OK).entity(tiposResidencia).build();
	}

}
