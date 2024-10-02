package com.projeto_dsc.Companhia_Area.infra_security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Service;

import com.projeto_dsc.Companhia_Area.entity.UsuarioEntity;

@Service
public class TokenService {
	
	@Value("${api.security.token.secret	}")
	private String secret;

	public String generateToken(UsuarioEntity usuarioEntity){

		try {
			Algorithm algorithm = Algorithm.HMAC256(secret);

			String token = JWT.create()
					.withIssuer("companhia-aerea")
					.withSubject(usuarioEntity.getCodigoAcesso)
					.withExpiresAt(genExpirationDate())
					.sign(algorithm);
			
			return token;

		}catch(JWTCreationException exception){
			throw new RuntimeException("ERROR WHILE GENERATION TOKEN", exception);


		}
	}

 

	public String validateToken(String token){
		try {
			Algorithm algorithm = Algorithm.HMAC256(secret);
			return JWT.require(algorithm)
					.withIssuer("companhia-aerea")
					.build()
					.verify(token)
					.getSubject();
			
		} catch (JWTVerificationException exception){
			return "";
		}

	}

	private Instant genExpirationDate(){
		return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
	}


}
