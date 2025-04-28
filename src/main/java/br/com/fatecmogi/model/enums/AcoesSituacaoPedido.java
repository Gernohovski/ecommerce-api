package br.com.fatecmogi.model.enums;

import io.quarkus.logging.Log;

public enum AcoesSituacaoPedido {

	RECUSAR_PAGAMENTO("Recusar pagamento", SituacaoDoPedido.PAGAMENTO_RECUSADO),
	APROVAR_PAGAMENTO("Aprovar pagamento", SituacaoDoPedido.PENDENTE_DE_ENVIO),
	REALIZAR_ENVIO("Realizar envio", SituacaoDoPedido.EM_TRANSITO),
	CONFIRMAR_RECEBIMENTO("Confirmar recebimento", SituacaoDoPedido.PEDIDO_RECEBIDO),
	CONFIRMAR_NAO_RECEBIMENTO("Confirmar não recebimento", SituacaoDoPedido.PEDIDO_NAO_ENTREGUE),
	PEDIDO_NAO_ENTREGUE("Realizar novo envio", SituacaoDoPedido.EM_TRANSITO),
	PEDIDO_RECEBIDO("Finalizar pedido", SituacaoDoPedido.PEDIDO_FINALIZADO),
	SOLICITAR_TROCA("Solicitar troca", SituacaoDoPedido.SOLICITACAO_DE_TROCA),
	RECUSAR_TROCA("Recusar troca", SituacaoDoPedido.TROCA_RECUSADA),
	APROVAR_TROCA("Aprovar troca", SituacaoDoPedido.TROCA_APROVADA),
	TROCA_RECEBIDA("Confirmar recebimento troca", SituacaoDoPedido.TROCA_RECEBIDA),
	DESCARTAR("Descartar", SituacaoDoPedido.TROCA_FINALIZADA),
	ADICIONAR_AO_ESTOQUE("Adicionar ao estoque", SituacaoDoPedido.TROCA_FINALIZADA),
	SOLICITAR_DEVOLUCAO("Solicitar devolução", SituacaoDoPedido.SOLICITACAO_DEVOLUCAO),
	APROVAR_DEVOLUCAO("Aprovar devolução", SituacaoDoPedido.DEVOLUCAO_APROVADA),
	RECUSAR_DEVOLUCAO("Recusar devolução", SituacaoDoPedido.DEVOLUCAO_RECUSADA),
	DEVOLUCAO_RECEBIDA("Confirmar recebimento devolução", SituacaoDoPedido.DEVOLUCAO_RECEBIDA),
	DEVOLUCAO_FINALIZADA("Finalizar devolução", SituacaoDoPedido.DEVOLUCAO_FINALIZADA),
	ADICIONAR_DEVOLUCAO_AO_ESTOQUE("Adicionar ao estoque", SituacaoDoPedido.DEVOLUCAO_FINALIZADA),
	DESCARTAR_DEVOLUCAO("Descartar", SituacaoDoPedido.DEVOLUCAO_FINALIZADA);

	private final String acao;

	private final SituacaoDoPedido situacaoDoPedido;

	AcoesSituacaoPedido(String acao, SituacaoDoPedido situacaoDoPedido) {
		this.acao = acao;
		this.situacaoDoPedido = situacaoDoPedido;
	}

	public String getAcao() {
		return acao;
	}

	public SituacaoDoPedido getSituacaoDoPedido() {
		return situacaoDoPedido;
	}

	public static AcoesSituacaoPedido getAcaoPedido(String acao) {
		for (AcoesSituacaoPedido acoes : values()) {
			if (acoes.getAcao().equalsIgnoreCase(acao.trim())) {
				return acoes;
			}
		}
		Log.error("Ação não encontrada: " + acao);
		return null;
	}

}
