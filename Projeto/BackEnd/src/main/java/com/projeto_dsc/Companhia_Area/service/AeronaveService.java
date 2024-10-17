package com.projeto_dsc.Companhia_Area.service;

import com.projeto_dsc.Companhia_Area.dto.AeronaveDTO;
import com.projeto_dsc.Companhia_Area.dto.PlanejamentoDTO;
import com.projeto_dsc.Companhia_Area.dto.UsuarioDTO;
import com.projeto_dsc.Companhia_Area.entity.AeronaveEntity;
import com.projeto_dsc.Companhia_Area.repository.AeronaveRepository;
import com.projeto_dsc.Companhia_Area.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AeronaveService {
    @Autowired
    AeronaveRepository aeronaveRepository;

    public List<AeronaveDTO> listarTodos() {
        List<AeronaveEntity> aeronave = aeronaveRepository.findAll();
        return  aeronave.stream().map(AeronaveDTO::new).toList();
    }

    public List<PlanejamentoDTO> listarPlanejamentos() {
        List<AeronaveEntity> aeronave = aeronaveRepository.findAll();
        return  aeronave.stream().map(PlanejamentoDTO::new).toList();
    }

    public void  inserir(AeronaveDTO aeronave) {
        AeronaveEntity aeronaveEntity = new AeronaveEntity(aeronave);
        aeronaveRepository.save(aeronaveEntity);
    }

    public AeronaveDTO alterar(AeronaveDTO aeronave) {
        AeronaveEntity aeronaveEntity = new AeronaveEntity(aeronave);
        return new AeronaveDTO(aeronaveRepository.save(aeronaveEntity));
    }

    public void excluir(Long id) {
        AeronaveEntity aeronave = aeronaveRepository.findById(id).get();
        aeronaveRepository.delete(aeronave);
    }

    public AeronaveDTO buscarPorId(Long id) {
        AeronaveEntity aeronave = aeronaveRepository.findById(id).get();
        return new AeronaveDTO(aeronave);
    }
}
