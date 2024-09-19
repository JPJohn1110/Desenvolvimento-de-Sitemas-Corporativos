package com.projeto_dsc.Companhia_Area.controller;

import com.projeto_dsc.Companhia_Area.dto.UsuarioDTO;
import com.projeto_dsc.Companhia_Area.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

	
	@Autowired
	private UsuarioService usuarioService;

		@GetMapping
		public List<UsuarioDTO> listarTodos(){
			return usuarioService.listarTodos();
		}

		@PostMapping
		@ResponseStatus(HttpStatus.OK)
		public ResponseEntity<String> inserir(@RequestBody UsuarioDTO usuario){
			try {
            // Chame o serviço para inserir o usuário no banco de dados
            usuarioService.inserir(usuario);

			return ResponseEntity.ok("Usuário cadastrado com sucesso!");

        } catch (Exception e) {
            // Em caso de erro, retorne uma resposta de erro (HTTP 500 Internal Server Error)
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao cadastrar o usuário.");
        }

		}

		@PutMapping
		public UsuarioDTO alterar(@RequestBody UsuarioDTO usuario){
			return usuarioService.alterar(usuario);
		}

		@DeleteMapping("/{id}")
		public ResponseEntity<Void> excluir(@PathVariable("id") Long id){
			usuarioService.excluir(id);
			return ResponseEntity.ok().build();
		}

}

