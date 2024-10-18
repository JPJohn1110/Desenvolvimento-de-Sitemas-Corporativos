package com.projeto_dsc.Companhia_Area.dto;

import com.projeto_dsc.Companhia_Area.entity.AeronaveEntity;
import com.projeto_dsc.Companhia_Area.repository.VooRepository;
import com.projeto_dsc.Companhia_Area.service.VooService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Setter
@Getter
public class PlanejamentoDTO {
    private String modelo;
    private Double autonomia;
    private Double pesoDisponivel;
    private int primeiraClasse;
    private int economicaClasse;
    private int quantidade;

    public PlanejamentoDTO(AeronaveEntity aeronave, int quantidade) {
        this.modelo = aeronave.getModelo();
        this.autonomia = aeronave.autonomia();
        this.pesoDisponivel = aeronave.pesoDisponivel();
        this.primeiraClasse = aeronave.primeiraClasse();
        this.economicaClasse = aeronave.economicaClasse();
        this.quantidade = quantidade;
    }
}
