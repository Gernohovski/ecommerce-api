package br.com.fatecmogi.service.impl;

import br.com.fatecmogi.service.SenhaService;
import jakarta.enterprise.context.ApplicationScoped;
import org.mindrot.jbcrypt.BCrypt;

@ApplicationScoped
public class SenhaServiceImpl implements SenhaService {

	@Override
	public String encriptarSenha(String senha) {
		return BCrypt.hashpw(senha, BCrypt.gensalt());
	}

	@Override
	public boolean validarSenha(String senha, String senhaSalva) {
		return BCrypt.checkpw(senha, senhaSalva);
	}

}
