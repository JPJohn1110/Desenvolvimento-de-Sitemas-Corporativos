package com.projeto_dsc.Companhia_Area.controller;

import com.projeto_dsc.Companhia_Area.dto.UsuarioDTO;
import com.projeto_dsc.Companhia_Area.repository.UsuarioRepository;
import com.projeto_dsc.Companhia_Area.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping(value = "/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping
		public List<UsuarioDTO> listarTodos(){
			return usuarioService.listarTodos();
		}

		@PostMapping
		@ResponseStatus(HttpStatus.OK)
		public ResponseEntity<String> inserir(@RequestBody UsuarioDTO usuario){
			if (this.usuarioRepository.findByEmail(usuario.getEmail()) != null) {
				return ResponseEntity.badRequest().build();
			}

			try {
				String encryptedPassword = new BCryptPasswordEncoder().encode(usuario.getSenha());
				usuario.setSenha(encryptedPassword);
				usuarioService.inserir(usuario);
				return ResponseEntity.status(HttpStatus.CREATED).body("Usuario cadastrado com suceso.");
			} catch (Exception e) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao cadastrar.");
			}
		}

		@PutMapping
		public UsuarioDTO alterar(@RequestBody UsuarioDTO usuario){
			return usuarioService.alterar(usuario);
		}

		@DeleteMapping("/{id}")
		public ResponseEntity<Void> excluir(@PathVariable("id") Long id_){
			usuarioService.excluir(id_);
			return ResponseEntity.ok().build();
		}

}

