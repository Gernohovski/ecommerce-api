package br.com.fatecmogi.controller;

import br.com.fatecmogi.service.AutorService;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/autores")
public class AutorController {

    @Inject
    AutorService autorService;

    @GetMapping
    public Response listar() {
        var autores = autorService.listar();
        return Response.status(Response.Status.OK).entity(autores).build();
    }
}
