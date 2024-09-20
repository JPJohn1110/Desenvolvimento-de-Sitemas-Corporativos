package com.projeto_dsc.Companhia_Area.dto;

import com.projeto_dsc.Companhia_Area.entity.AeronaveEntity;
import org.springframework.beans.BeanUtils;

public class AeronaveDTO {
    private Long id;
    private String modelo;
    private int capacidade;
    private int assentosPrimeiraClasse;
    private int assentosSegundaClasse;
    private int portaEmbarque;

    public AeronaveDTO(AeronaveEntity aeronave) {
        BeanUtils.copyProperties(aeronave, this);
    }

    public AeronaveDTO() {
    }

    public Long getId() {
        return id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public int getAssentosPrimeiraClasse() {
        return assentosPrimeiraClasse;
    }

    public void setAssentosPrimeiraClasse(int assentosPrimeiraClasse) {
        this.assentosPrimeiraClasse = assentosPrimeiraClasse;
    }

    public int getAssentosSegundaClasse() {
        return assentosSegundaClasse;
    }

    public void setAssentosSegundaClasse(int assentosSegundaClasse) {
        this.assentosSegundaClasse = assentosSegundaClasse;
    }

    public int getPortaEmbarque() {
        return portaEmbarque;
    }

    public void setPortaEmbarque(int portaEmbarque) {
        this.portaEmbarque = portaEmbarque;
    }


}
