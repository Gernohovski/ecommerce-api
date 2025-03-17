package br.com.fatecmogi.controller;

import br.com.fatecmogi.controller.dto.endereco.CadastrarEnderecoClienteCommand;
import br.com.fatecmogi.controller.dto.endereco.EditarEnderecoClienteCommand;
import br.com.fatecmogi.service.EnderecoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/enderecos")
public class EnderecoController {

    @Inject
    EnderecoService enderecoService;

    @PostMapping
    public Response salvar(@RequestBody CadastrarEnderecoClienteCommand command) {
        var endereco = enderecoService.salvar(command);
        return Response.status(Response.Status.CREATED).entity(endereco).build();
    }

    @PutMapping("/{id}")
    public Response atualizar(@PathVariable("id") Long id, @RequestBody EditarEnderecoClienteCommand command) {
        var endereco = enderecoService.atualizar(id, command);
        return Response.status(Response.Status.OK).entity(endereco).build();
    }

    @DeleteMapping("/{id}/{tipoEndereco}")
    public Response deletar(@PathVariable("id") Long id, @PathVariable("tipoEndereco") String tipoEndereco) {
        enderecoService.deletar(id, tipoEndereco);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @PutMapping("/{id}/{clienteId}/{tipoEndereco}")
    public Response tornarPrincipal(@PathVariable("id") Long id, @PathVariable("clienteId") Long clienteId, @PathVariable("tipoEndereco") String tipoEndereco) {
        enderecoService.tornarPrincipal(id, tipoEndereco, clienteId);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

}
