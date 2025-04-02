package br.com.fatecmogi.controller;

import br.com.fatecmogi.service.CondicaoService;
import br.com.fatecmogi.service.IdiomaService;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/condicoes")
public class CondicaoController {

    @Inject
    CondicaoService condicaoService;

    @GetMapping
    public Response listar() {
        var condicoes = condicaoService.listar();
        return Response.status(Response.Status.OK).entity(condicoes).build();
    }

}
