package com.projeto_dsc.Companhia_Area.infra_security;

import org.springframework.stereotype.Service;

import com.projeto_dsc.Companhia_Area.entity.UsuarioEntity;

@Service
public class TokenService {
	
	@Value("${api.security.token.secret}")
	private String secret;

	public String generateToken(UsuarioEntity usuarioEntity){

		try {
			Algorithm algorithm = Algorithm.HMAC256;

		}catch(){

		}
	}
}
