package br.com.fatecmogi.controller;

import br.com.fatecmogi.service.IdiomaService;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/idiomas")
public class IdiomaController {

	@Inject
	IdiomaService idiomaService;

	@GetMapping
	public Response listar() {
		var idiomas = idiomaService.listar();
		return Response.status(Response.Status.OK).entity(idiomas).build();
	}

}
