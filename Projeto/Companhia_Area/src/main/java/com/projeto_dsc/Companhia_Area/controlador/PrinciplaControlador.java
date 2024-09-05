package com.projeto_dsc.Companhia_Area.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PrinciplaControlador {
    @GetMapping("/administrativo")
    public String acessarPrincipal() {
        return "administrativo/index";
    }
}
