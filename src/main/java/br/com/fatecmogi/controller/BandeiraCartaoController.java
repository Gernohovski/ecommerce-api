package br.com.fatecmogi.controller;

import br.com.fatecmogi.service.BandeirasCartaoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/bandeirasCartao")
public class BandeiraCartaoController {

	@Inject
	BandeirasCartaoService bandeirasCartaoService;

	@GetMapping
	public Response listar() {
		var bandeirasCartao = bandeirasCartaoService.findAll();
		return Response.status(Response.Status.OK).entity(bandeirasCartao).build();
	}

}
