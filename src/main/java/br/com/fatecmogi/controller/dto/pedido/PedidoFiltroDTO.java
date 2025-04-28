package br.com.fatecmogi.controller.dto.pedido;

import jakarta.ws.rs.QueryParam;

import java.util.List;

public class PedidoFiltroDTO {

	@QueryParam("situacoesId")
	public List<String> situacoesId;

	@QueryParam("clienteId")
	public Long clienteId;

	@QueryParam("sortBy")
	public String sortBy = "dataPedido";

	@QueryParam("sortDirection")
	public String sortDirection = "DESC";

}
