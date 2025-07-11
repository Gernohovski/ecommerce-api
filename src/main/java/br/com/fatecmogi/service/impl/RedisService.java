package br.com.fatecmogi.service.impl;

import br.com.fatecmogi.model.entity.livro.Livro;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.quarkus.logging.Log;
import io.quarkus.redis.datasource.ReactiveRedisDataSource;
import io.quarkus.redis.datasource.RedisDataSource;
import io.quarkus.redis.datasource.keys.ReactiveKeyCommands;
import io.quarkus.redis.datasource.value.ValueCommands;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ApplicationScoped
public class RedisService {

	private final ReactiveKeyCommands<String> keyCommands;

	private final ValueCommands<String, String> countCommands;

	private final ObjectMapper objectMapper;

	@Inject
	public RedisService(RedisDataSource ds, ReactiveRedisDataSource reactive, ObjectMapper objectMapper) {
		countCommands = ds.value(String.class);
		keyCommands = reactive.key();
		this.objectMapper = objectMapper;
	}

	public void set(String key, String value) {
		countCommands.set(key, value);
	}

	public String get(String key) {
		return countCommands.get(key);
	}

	public void delete(String key) {
		keyCommands.del(key);
	}

	public void salvarLivrosNoCache(String cacheKey, List<Livro> livros) {
		try {
			String json = objectMapper.writeValueAsString(livros);
			countCommands.set(cacheKey, json);
		}
		catch (Exception e) {
			Log.error("Erro ao cachear os livros");
		}
	}

	public List<Livro> buscarLivrosNoCache(String cacheKey) {
		cacheKey = cacheKey.toLowerCase();
		String cacheData = get(cacheKey);
		if (cacheData != null) {
			try {
				return Arrays.asList(objectMapper.readValue(cacheData, Livro[].class));
			}
			catch (Exception e) {
				Log.error("Erro ao buscar os livros no cache");
			}
		}
		return null;
	}

	public void salvarMensagemNoHistorico(Long clienteId, List<String> mensagens) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(mensagens);
			this.set("conversa:" + clienteId, json);
		}
		catch (Exception ignored) {
			Log.error("Erro ao salvar histórico do usuário");
		}
	}

	public List<String> getHistorico(Long clienteId) {
		String json = this.get("conversa:" + clienteId);
		if (json == null)
			return new ArrayList<>();
		try {
			ObjectMapper mapper = new ObjectMapper();
			String[] mensagens = mapper.readValue(json, String[].class);
			return mensagens != null ? new ArrayList<>(Arrays.asList(mensagens)) : new ArrayList<>();
		}
		catch (Exception e) {
			Log.error("Erro ao buscar histórico do usuário");
			return new ArrayList<>();
		}
	}

	public void deletarHistoricoCliente(Long clienteId) {
		this.delete("conversa:" + clienteId);
		Log.info("Histórico do usuário apagado com sucesso");
	}

}
