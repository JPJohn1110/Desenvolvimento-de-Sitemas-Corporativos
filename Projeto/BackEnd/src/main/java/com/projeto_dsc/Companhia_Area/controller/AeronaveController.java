package com.projeto_dsc.Companhia_Area.controller;

import com.projeto_dsc.Companhia_Area.dto.AeronaveDTO;
import com.projeto_dsc.Companhia_Area.dto.PlanejamentoDTO;
import com.projeto_dsc.Companhia_Area.service.AeronaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping(value = "/crud/aeronave")
public class AeronaveController {

    @Autowired
    private AeronaveService aeronaveService;

    @GetMapping
    public List<AeronaveDTO> listarTodos(){
        return aeronaveService.listarTodos();
    }

    @GetMapping("/plano")
    public List<PlanejamentoDTO> listarPlanejamentos(){
        return aeronaveService.listarPlanejamentos();
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
    public ResponseEntity<String> atualizar(@RequestBody AeronaveDTO aeronaveDTO){
        try {
            aeronaveService.alterar(aeronaveDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body("Aeronave atualizada com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao atualizar a aeronave: " + e.getMessage());
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir(@PathVariable Long id){
        try {
            aeronaveService.excluir(id);
            return ResponseEntity.status(HttpStatus.CREATED).body("Aeronave excluida com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao excluir a aeronave: " + e.getMessage());
        }
    }
}
