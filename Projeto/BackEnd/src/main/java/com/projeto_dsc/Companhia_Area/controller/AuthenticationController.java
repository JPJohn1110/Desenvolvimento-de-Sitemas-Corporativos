/*package com.projeto_dsc.Companhia_Area.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto_dsc.Companhia_Area.dto.AuthenticationDTO;
import com.projeto_dsc.Companhia_Area.dto.cadastroDTO;
import com.projeto_dsc.Companhia_Area.entity.UsuarioEntity;
import com.projeto_dsc.Companhia_Area.entity.UsuarioRole;
import com.projeto_dsc.Companhia_Area.infra_security.TokenService;
import com.projeto_dsc.Companhia_Area.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;





@RestController
@RequestMapping("/auth")
public class AuthenticationController {
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private TokenService tokenService;
	

	@PostMapping("/login")	
	public ResponseEntity login(@RequestBody @Validated AuthenticationDTO data) {
		var usuarioSenha = new UsernamePasswordAuthenticationToken(data.email(), data.senha());
		var auth = this.authenticationManager.authenticate(usuarioSenha);

		var token = tokenService.generateToken((UsuarioEntity)auth.getPrincipal());

		return ResponseEntity.ok(token);	
	}
	
	@PostMapping("/cadastro")
	public ResponseEntity cadastro(@RequestBody @Validated cadastroDTO data) {
		if(this.usuarioRepository.findByEmail(data.email())!= null) return ResponseEntity.badRequest().build();
		
		String encrypedPassword = new BCryptPasswordEncoder().encode(data.senha());
		UsuarioEntity novoUsusario = new UsuarioEntity(data.email(), encrypedPassword, data.role(),  data.cpf(), data.codigoAcesso(), data.nome(), data.telefone()); 	 


		this.usuarioRepository.save(novoUsusario); 
		return ResponseEntity.ok().build();
	}
	

}*/
