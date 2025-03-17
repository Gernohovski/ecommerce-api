package br.com.fatecmogi.service;

public interface SenhaService {

	String encriptarSenha(String senha);

	boolean validarSenha(String senha, String senhaSalva);

}
