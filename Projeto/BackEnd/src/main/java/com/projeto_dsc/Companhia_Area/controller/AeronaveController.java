package com.projeto_dsc.Companhia_Area.controller;

import com.projeto_dsc.Companhia_Area.dto.AeronaveDTO;
import com.projeto_dsc.Companhia_Area.service.AeronaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping(value = "/aeronave")
public class AeronaveController {

    @Autowired
    private AeronaveService aeronaveService;

    @GetMapping
    public List<AeronaveDTO> listarTodos(){
        return aeronaveService.listarTodos();
    }

    @PostMapping
    public ResponseEntity<String> inserir(@RequestBody AeronaveDTO aeronaveDTO){
        try {
            aeronaveService.inserir(aeronaveDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body("Aeronave cadastrado com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao cadastrar a aeronave: " + e.getMessage());
        }
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
