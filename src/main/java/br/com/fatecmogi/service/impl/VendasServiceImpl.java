package br.com.fatecmogi.service.impl;

import br.com.fatecmogi.controller.dto.vendas.FiltrarVendasCommand;
import br.com.fatecmogi.controller.dto.vendas.VendasPorCategoriaDTO;
import br.com.fatecmogi.controller.dto.vendas.SerieLinhaResponseDTO;
import br.com.fatecmogi.controller.dto.vendas.VendasResponseDTO;
import br.com.fatecmogi.model.repository.ClienteRepository;
import br.com.fatecmogi.model.repository.PedidoRepository;
import br.com.fatecmogi.service.VendasService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.*;
import java.util.stream.Collectors;

@ApplicationScoped
public class VendasServiceImpl implements VendasService {

	@Inject
	private PedidoRepository pedidoRepository;

	@Inject
	private ClienteRepository clienteRepository;

	@Override
	public VendasResponseDTO filtrarVendas(FiltrarVendasCommand command) {
		var vendasPorCategoria = pedidoRepository.buscarVendasPorPeriodo(command.getConvertedDataInicio(),
				command.getConvertedDataFim(), command.getCategoriasId());
		if (vendasPorCategoria == null || vendasPorCategoria.isEmpty()) {
			return VendasResponseDTO.builder()
				.series(Collections.emptyList())
				.categories(Collections.emptyList())
				.build();
		}
        //Levanta o número total de vendas no período e na categoria informados
		int totalVendas = vendasPorCategoria.stream()
			.mapToInt(venda -> Integer.parseInt(venda.getQuantidade().toString()))
			.sum();
        //Coleta todos os meses únicos presentes nos dados de vendas e os ordena de forma crescente
		List<String> mesesOrdenados = vendasPorCategoria.stream()
			.map(VendasPorCategoriaDTO::getMes)
			.distinct()
			.sorted()
			.collect(Collectors.toList());
        //Monta o mapa que relaciona categoria com mês e quantidade
		Map<String, Map<String, Long>> categoriaMesQuantidade = new HashMap<>();
		for (VendasPorCategoriaDTO vendaCategoria : vendasPorCategoria) {
			categoriaMesQuantidade.computeIfAbsent(vendaCategoria.getNomeCategoria(), k -> new HashMap<>())
				.put(vendaCategoria.getMes(), vendaCategoria.getQuantidade());
		}
        //Constrói as "séries" do gráfico. Cada série representa uma linha no gráfico
        List<SerieLinhaResponseDTO> series = categoriaMesQuantidade.entrySet().stream().map(entry -> {
            List<Double> data = mesesOrdenados.stream()
                    //Para cada mês na lista de meses ordenados, busca a quantidade de vendas.
                    .map(mes -> entry.getValue().getOrDefault(mes, 0L).doubleValue())
                    .collect(Collectors.toList());
            //Constrói o objeto SerieLinhaResponseDTO para esta categoria.
            return SerieLinhaResponseDTO.builder()
                    .name(entry.getKey())//Nome da categoria
                    .data(data) //Quantidade de vendas no mês
                    .build();
        }).collect(Collectors.toList());

        return VendasResponseDTO.builder()
			.series(series)
			.categories(mesesOrdenados)
			.numeroVendas(totalVendas)
			.build();
	}

}
