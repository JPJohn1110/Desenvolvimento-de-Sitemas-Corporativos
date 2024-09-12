package com.projeto_dsc.Companhia_Area.controller;

import com.projeto_dsc.Companhia_Area.dto.VooDTO;
import com.projeto_dsc.Companhia_Area.service.VooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "/voo")
public class VooController {

    @Autowired
    private VooService vooService;

    @GetMapping
    public List<VooDTO> listarTodos(){
        return  vooService.listarTodos();
    }

    @PostMapping
    public void inserir(@RequestBody VooDTO vooDTO){
        vooService.inserir(vooDTO);
    }

    @PutMapping
    public void alterar(@RequestBody VooDTO vooDTO){
        vooService.alterar(vooDTO);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id){
        vooService.excluir(id);
    }
}
