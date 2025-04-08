package br.com.fatecmogi.model.enums;

public enum SituacaoDoPedido {

	APROVACAO_DE_PAGAMENTO("aprovacao-de-pagamento"), PAGAMENTO_RECUSADO("pagamento-recusado"),
	PENDENTE_DE_ENVIO("pendente-de-envio"), EM_TRANSITO("em-transito"), PEDIDO_CANCELADO("pedido-cancelado"),
	PEDIDO_NAO_ENTREGUE("pedido-nao-entregue"), PEDIDO_RECEBIDO("pedido-recebido"),
	PEDIDO_FINALIZADO("pedido-finalizado"), SOLICITACAO_DE_TROCA("solicitacao-de-troca"),
	TROCA_APROVADA("troca-aprovada"), TROCA_RECUSADA("troca-recusada"), TROCA_FINALIZADA("troca-finalizada");

	private final String situacao;

	SituacaoDoPedido(String situacao) {
		this.situacao = situacao;
	}

	public String getSituacao() {
		return situacao;
	}

}
