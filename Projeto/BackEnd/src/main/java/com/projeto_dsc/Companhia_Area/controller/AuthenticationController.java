package com.projeto_dsc.Companhia_Area.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto_dsc.Companhia_Area.dto.AuthenticationDTO;
import com.projeto_dsc.Companhia_Area.dto.cadastroDTO;
import com.projeto_dsc.Companhia_Area.entity.UsuarioEntity;
import com.projeto_dsc.Companhia_Area.infra_security.TokenService;
import com.projeto_dsc.Companhia_Area.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Validated AuthenticationDTO data) {
        try {
            var usuarioSenha = new UsernamePasswordAuthenticationToken(data.email(), data.senha());
            var auth = this.authenticationManager.authenticate(usuarioSenha);
            var token = tokenService.generateToken((UsuarioEntity) auth.getPrincipal());
            return ResponseEntity.ok(token);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login falhou: " + e.getMessage());
        }
    }

    @PostMapping("/cadastro")
    public ResponseEntity<Void> cadastro(@RequestBody @Validated cadastroDTO data) {
        if (this.usuarioRepository.findByEmail(data.email()).isPresent()) {
            return ResponseEntity.badRequest().build();
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.senha());
        UsuarioEntity novoUsuario = new UsuarioEntity(data.email(), encryptedPassword, data.role(), data.cpf(), data.codigoAcesso(), data.nome(), data.telefone());

        this.usuarioRepository.save(novoUsuario);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
