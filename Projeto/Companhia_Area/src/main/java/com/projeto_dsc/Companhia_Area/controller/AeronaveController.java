package com.projeto_dsc.Companhia_Area.controller;

import com.projeto_dsc.Companhia_Area.dto.AeronaveDTO;
import com.projeto_dsc.Companhia_Area.service.AeronaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "/aeronave")
public class AeronaveController {

    @Autowired
    private AeronaveService aeronaveService;

    @GetMapping
    public List<AeronaveDTO> listarTodos(){
        return aeronaveService.listarTodos();
    }

    @PostMapping
    public void inserir(@RequestBody AeronaveDTO aeronaveDTO){
        aeronaveService.inserir(aeronaveDTO);
    }

    @PutMapping
    public void atualizar(@RequestBody AeronaveDTO aeronaveDTO){
        aeronaveService.alterar(aeronaveDTO);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id){
        aeronaveService.excluir(id);
    }
}
