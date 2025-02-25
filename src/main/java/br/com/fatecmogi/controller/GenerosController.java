package br.com.fatecmogi.controller;

import br.com.fatecmogi.service.GenerosService;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/generos")
public class GenerosController {

    @Inject
    GenerosService generosService;

    @GetMapping
    public Response listar() {
        var generos = generosService.findAll();
        return Response.status(Response.Status.OK).entity(generos).build();
    }

}
