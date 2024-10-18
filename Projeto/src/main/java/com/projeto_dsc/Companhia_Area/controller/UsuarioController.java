package com.projeto_dsc.Companhia_Area.controller;

import com.projeto_dsc.Companhia_Area.dto.UsuarioDTO;
import com.projeto_dsc.Companhia_Area.entity.UsuarioEntity;
import com.projeto_dsc.Companhia_Area.entity.UsuarioRole;
import com.projeto_dsc.Companhia_Area.repository.UsuarioRepository;
import com.projeto_dsc.Companhia_Area.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
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
		try {
			usuarioService.inserir(usuario);
			return ResponseEntity.status(HttpStatus.CREATED).body("Usuario cadastrado com suceso.");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao cadastrar.");
		}
	}

	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String> alterar(@RequestBody UsuarioDTO usuario){
		UsuarioEntity user = usuarioRepository.findByCodigoAcesso(usuario.getCodigoAcesso());

		Long id = user.getId();
		if (id == null) {
			return ResponseEntity.badRequest().build();
		}

		if (this.usuarioRepository.findByEmail(usuario.getEmail()) != null) {
			System.out.println("entrou");
			return ResponseEntity.badRequest().build();
		}

		String email = user.getEmail();
		if (email != null) {
			return ResponseEntity.badRequest().build();
		}


		try {
			String encryptedPassword = new BCryptPasswordEncoder().encode(usuario.getSenha());
			usuario.setSenha(encryptedPassword);
			usuario.setId(id);
			usuario.setRole(user.getRole());
			usuarioService.alterar(usuario);
			return ResponseEntity.ok("Usuario alterado com sucesso.");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao alterar.");
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable("id") Long id_){
		usuarioService.excluir(id_);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/buscar")
	public List<UsuarioDTO> buscarPorRole(@RequestParam(required = false) UsuarioRole role){
		return usuarioService.buscarPorRole(role);
	}

	@GetMapping("/buscar/email")
	public ResponseEntity<?> buscarPorEmail(@RequestParam(required = false) String email){
		String nome = usuarioService.buscarPorEmail(email);

		if (nome == null) {
			return ResponseEntity.notFound().build(); // Retorna 404 se não encontrar
		}
		return ResponseEntity.ok(Collections.singletonMap("nome", nome));
	}

}

