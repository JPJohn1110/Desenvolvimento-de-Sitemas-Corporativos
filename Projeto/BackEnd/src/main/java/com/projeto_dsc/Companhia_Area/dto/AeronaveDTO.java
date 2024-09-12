package com.projeto_dsc.Companhia_Area.dto;

import com.projeto_dsc.Companhia_Area.entity.AeronaveEntity;
import org.springframework.beans.BeanUtils;

public class AeronaveDTO {
    private Long id;
    private String modelo;
    private int capacidade;

    public AeronaveDTO(AeronaveEntity aeronave) {
        BeanUtils.copyProperties(aeronave, this);
    }

    public AeronaveDTO() {
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
