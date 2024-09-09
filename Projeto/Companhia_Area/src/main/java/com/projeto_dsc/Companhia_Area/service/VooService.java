package com.projeto_dsc.Companhia_Area.service;

import com.projeto_dsc.Companhia_Area.dto.VooDTO;
import com.projeto_dsc.Companhia_Area.entity.VooEntity;
import com.projeto_dsc.Companhia_Area.repository.VooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class VooService {
    @Autowired
    private VooRepository voo;

    public List<VooDTO> listarTodos() {
        List<VooEntity> voos = voo.findAll();
        return voos.stream().map(VooDTO::new).toList();
    }

    public void inserir(VooDTO voo) {
        VooEntity vooEntity = new VooEntity(voo);
        this.voo.save(vooEntity);
    }

    public VooDTO alterar(VooDTO voo) {
        VooEntity vooEntity = new VooEntity(voo);
        return new VooDTO(this.voo.save(vooEntity));
    }

    public void excluir(Long id) {
        VooEntity vooEntity = this.voo.findById(id).get();
        this.voo.delete(vooEntity);
    }

    public VooDTO buscarPorId(Long id) {
        VooEntity vooEntity = this.voo.findById(id).get();
        return new VooDTO(vooEntity);
    }
}
