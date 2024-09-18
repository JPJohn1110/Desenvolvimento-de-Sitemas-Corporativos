package com.projeto_dsc.Companhia_Area.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projeto_dsc.Companhia_Area.dto.UsuarioDTO;
import com.projeto_dsc.Companhia_Area.entity.UsuarioEntity;
import com.projeto_dsc.Companhia_Area.service.UsuarioService;

@Controller
@CrossOrigin("*")
@RequestMapping(value = "/usuario")
public class UsuarioController {

	
	@Autowired
	private UsuarioService usuarioService;

//FAZER CADASTRO

    @GetMapping("/cadastrar")
    public String cadastrar() {
		return "cadastrar"; // Retorna o nome do arquivo HTML (sem extensão)
    }

// FIM DE CADASTRO

//FAZER LOGIN

	 @GetMapping("/login")
    public String mostrarFormularioLogin() {
        return "login"; // Retorna o template HTML de login
    }

    @PostMapping("/login")
    public String processarLogin(
            @RequestParam String login,
            @RequestParam String senha,
            @RequestParam(required = false) String manterConectado,
            Model model) {

        // Verifica as credenciais (exemplo simples, sem lógica real de autenticação)
        if ("usuario".equals(login) && "senha123".equals(senha)) {
            // Se o login for bem-sucedido
            model.addAttribute("mensagem", "Login realizado com sucesso!");
            return "dashboard"; // Direciona para a página inicial ou dashboard
        } else {
            // Se falhar
            model.addAttribute("mensagem", "Login ou senha inválidos.");
            return "login"; // Retorna à página de login com mensagem de erro
        }
    }

//FIM DE LOGIN

//ABRIR O INDEX

@GetMapping("/index")
    public String index() {
		return "index"; // Retorna o nome do arquivo HTML (sem extensão)
    }

//FIM


	@GetMapping
	public List<UsuarioDTO> listarTodos(){
		return usuarioService.listarTodos();
	}

	@PostMapping
	public void inserir(@RequestBody UsuarioDTO usuario){
		usuarioService.inserir(usuario);
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


	@RequestMapping("/cadastrar")
	 @PostMapping
    public String cadastrarUsuario(@ModelAttribute UsuarioDTO usuario) {
        usuarioService.inserir(usuario);
        return "Cadastro realizado com sucesso!";
    }


}

