package br.com.fatecmogi.service.impl;

import br.com.fatecmogi.controller.dto.carrinho.AdicionarItemCarrinhoCommand;
import br.com.fatecmogi.controller.dto.carrinho.AlterarQuantidadeItemCommand;
import br.com.fatecmogi.controller.dto.carrinho.CarrinhoDTO;
import br.com.fatecmogi.controller.dto.carrinho.RemoverCarrinhoCommand;
import br.com.fatecmogi.controller.mapper.CarrinhoMapper;
import br.com.fatecmogi.controller.mapper.ItemCarrinhoMapper;
import br.com.fatecmogi.model.entity.pedido.Carrinho;
import br.com.fatecmogi.model.exception.cliente.ClienteNaoEncontratoException;
import br.com.fatecmogi.model.exception.itemCarrinho.ItemCarrinhoNaoEncontradoException;
import br.com.fatecmogi.model.exception.livro.LivroNaoEncontradoException;
import br.com.fatecmogi.model.repository.CarrinhoRepository;
import br.com.fatecmogi.model.repository.ClienteRepository;
import br.com.fatecmogi.model.repository.ItemCarrinhoRepository;
import br.com.fatecmogi.model.repository.LivroRepository;
import br.com.fatecmogi.service.CarrinhoService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@ApplicationScoped
public class CarrinhoServiceImpl implements CarrinhoService {

	@Inject
	CarrinhoRepository carrinhoRepository;

	@Inject
	ItemCarrinhoMapper itemCarrinhoMapper;

	@Inject
	CarrinhoMapper carrinhoMapper;

	@Inject
	ClienteRepository clienteRepository;

	@Inject
	LivroRepository livroRepository;

	@Inject
	ItemCarrinhoRepository itemCarrinhoRepository;

	@Override
	@Transactional
	public CarrinhoDTO adicionarItem(AdicionarItemCarrinhoCommand command, Long clienteId) {
		var cliente = clienteRepository.findById(clienteId).orElseThrow(ClienteNaoEncontratoException::new);
		var livro = livroRepository.findById(command.getLivroId()).orElseThrow(LivroNaoEncontradoException::new);
		var carrinhoValido = getCarrinhoValido(clienteId);
		var itemCarrinho = itemCarrinhoMapper.from(command);
		itemCarrinho.setLivro(livro);
		if (carrinhoValido == null) {
			var carrinho = Carrinho.builder().itens(List.of(itemCarrinho)).cliente(cliente).build();
			return carrinhoMapper.from(carrinhoRepository.salvar(carrinho));
		}
		var semLivro = carrinhoValido.getItens()
			.stream()
			.noneMatch(item -> item.getLivro().getId().equals(command.getLivroId()));
		if (!semLivro) {
			var itemAdicionado = carrinhoValido.getItens()
				.stream()
				.filter(item -> item.getLivro().getId().equals(command.getLivroId()))
				.findFirst();
			if (itemAdicionado.isPresent()) {
				var item = itemAdicionado.get();
				return alterarQuantidade(AlterarQuantidadeItemCommand.builder()
					.itemId(item.getId())
					.quantidade(item.getQuantidade() + 1)
					.build());
			}
		}
		itemCarrinho.setCarrinho(carrinhoValido);
		carrinhoValido.addItem(itemCarrinho);
		carrinhoValido.atualizar();
		return carrinhoMapper.from(carrinhoRepository.atualizar(carrinhoValido));
	}

	@Override
	@Transactional
	public CarrinhoDTO removerItem(RemoverCarrinhoCommand command, Long clienteId) {
		clienteRepository.findById(clienteId).orElseThrow(ClienteNaoEncontratoException::new);
		var carrinhoValido = getCarrinhoValido(clienteId);
		carrinhoValido.removeItem(command.getItemId());
		carrinhoValido.atualizar();
		return carrinhoMapper.from(carrinhoRepository.atualizar(carrinhoValido));
	}

	@Override
	@Transactional
	public CarrinhoDTO getCarrinho(Long clienteId) {
		var cliente = clienteRepository.findById(clienteId).orElseThrow(ClienteNaoEncontratoException::new);
		var carrinhoValido = getCarrinhoValido(clienteId);
		if (carrinhoValido == null) {
			var carrinho = Carrinho.builder().cliente(cliente).build();
			return carrinhoMapper.from(carrinhoRepository.salvar(carrinho));
		}
		return carrinhoMapper.from(carrinhoValido);
	}

	@Override
	@Transactional
	public CarrinhoDTO alterarQuantidade(AlterarQuantidadeItemCommand command) {
		var itemCarrinho = itemCarrinhoRepository.findById(command.getItemId())
			.orElseThrow(ItemCarrinhoNaoEncontradoException::new);
		itemCarrinho.setQuantidade(command.getQuantidade());
		var carrinho = itemCarrinhoRepository.update(itemCarrinho);
		return carrinhoMapper.from(carrinho);
	}

	@Transactional
	public Carrinho getCarrinhoValido(Long clienteId) {
		var carrinhosCliente = carrinhoRepository.findAllByClienteId(clienteId);
		return carrinhosCliente.stream()
			.filter(carrinhoCliente -> carrinhoCliente.getDataExpiracao().isAfter(LocalDateTime.now())
					&& !carrinhoCliente.isComprado())
			.findFirst()
			.orElse(null);
	}

}
