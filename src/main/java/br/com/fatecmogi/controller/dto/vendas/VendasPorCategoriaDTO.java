package br.com.fatecmogi.controller.dto.vendas;

public class VendasPorCategoriaDTO {

	private String mes;

	private Long idCategoria;

	private String nomeCategoria;

	private Long quantidade;

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public Long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

	public Long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}

	public VendasPorCategoriaDTO(String anoMes, Long categoriaId, String nomeCategoria, Long totalVendido) {
		this.mes = anoMes;
		this.idCategoria = categoriaId;
		this.nomeCategoria = nomeCategoria;
		this.quantidade = totalVendido;
	}

	public VendasPorCategoriaDTO() {
	}

}
