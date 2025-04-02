package br.com.fatecmogi.controller;

import br.com.fatecmogi.service.AutorService;
import br.com.fatecmogi.service.CategoriasLivrosService;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/categorias-livros")
public class CategoriasLivrosController {

    @Inject
    CategoriasLivrosService categoriasLivrosService;

    @GetMapping
    public Response listar() {
        var categorias = categoriasLivrosService.listar();
        return Response.status(Response.Status.OK).entity(categorias).build();
    }
}
