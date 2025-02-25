package br.com.fatecmogi.controller;

import br.com.fatecmogi.service.TiposLogradouroService;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/tiposLogradouro")
public class TiposLogradouroController {

    @Inject
    TiposLogradouroService tiposLogradouroService;

    @GetMapping
    public Response listar() {
        var tiposLogradouro = tiposLogradouroService.findAll();
        return Response.status(Response.Status.OK).entity(tiposLogradouro).build();
    }

}
