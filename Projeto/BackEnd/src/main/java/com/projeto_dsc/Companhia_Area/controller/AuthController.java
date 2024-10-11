package com.projeto_dsc.Companhia_Area.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {
    @GetMapping("/index")
    public String paginaInicial() {
        return "index";  // Retorna a página principal
    }

    @GetMapping("/cadastro")
    public String paginaCadastrar() {
        return "cadastro";
    }

    @GetMapping("/login")
    public String paginaLogin() {
        return "login";
    }

    @GetMapping("/aeronave")
    public String paginaAeronave() {
        return "aeronave";
    }

    @GetMapping("/voo")
    public String paginaVoo() {
        return "voo";
    }

    @GetMapping("/teste")
    public String paginateste() {
        return "teste";
    }
}
