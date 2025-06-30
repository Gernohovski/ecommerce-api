package br.com.fatecmogi.controller;

import br.com.fatecmogi.controller.dto.chatBot.SolicitarRecomendacaoCommand;
import br.com.fatecmogi.service.IAService;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/chat-bot")
public class ChatBotController {

	@Inject
	IAService iaService;

	@PostMapping
	public Response recomendar(@RequestBody SolicitarRecomendacaoCommand command) {
		var resposta = iaService.gerarRecomendacao(command);
		return Response.status(Response.Status.OK).entity(resposta).build();
	}

	@DeleteMapping("/{clienteId}")
	public Response deletarHistorico(@PathVariable("clienteId") Long clienteId) {
		iaService.deletarHistoricoCliente(clienteId);
		return Response.status(Response.Status.NO_CONTENT).build();
	}

}
