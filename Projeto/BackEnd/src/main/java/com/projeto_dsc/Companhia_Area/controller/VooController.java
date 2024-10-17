package com.projeto_dsc.Companhia_Area.controller;

import com.projeto_dsc.Companhia_Area.dto.VooDTO;
import com.projeto_dsc.Companhia_Area.service.VooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "/crud/voo")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class VooController {

    @Autowired
    private VooService vooService;

    @GetMapping
    public List<VooDTO> listarTodos(){
        return  vooService.listarTodos();
    }

    @GetMapping("/buscar")
    public List<VooDTO> buscarVoos(@RequestParam(required = false) String origem, @RequestParam(required = false) String destino, @RequestParam(required = false) String aeronave){
        return vooService.buscarVoos(origem, destino, aeronave);
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
