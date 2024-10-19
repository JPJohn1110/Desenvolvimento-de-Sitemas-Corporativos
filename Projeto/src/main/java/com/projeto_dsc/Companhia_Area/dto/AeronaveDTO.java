package com.projeto_dsc.Companhia_Area.dto;

import com.projeto_dsc.Companhia_Area.entity.AeronaveEntity;
import com.projeto_dsc.Companhia_Area.entity.VooEntity;
import jakarta.persistence.Column;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class AeronaveDTO {

    private Long id;
    private String modelo;
    private String tipo;
    private Double pesoMaxDecol;
    private Double pesoVazio;
    private int capacidadeOcupantes;
    private Double velocidadeMedia;
    private Double combustivelMax;
    private Double consumoHora;
    private List<VooEntity> voos = new ArrayList<>();


    public AeronaveDTO(AeronaveEntity aeronave) {BeanUtils.copyProperties(aeronave, this);}
    public AeronaveDTO() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Double getPesoMaxDecol() {
        return pesoMaxDecol;
    }

    public void setPesoMaxDecol(Double pesoMaxDecol) {
        this.pesoMaxDecol = pesoMaxDecol;
    }

    public Double getPesoVazio() {
        return pesoVazio;
    }

    public void setPesoVazio(Double pesoVazio) {
        this.pesoVazio = pesoVazio;
    }

    public int getCapacidadeOcupantes() {
        return capacidadeOcupantes;
    }

    public void setCapacidadeOcupantes(int capacidadeOcupantes) {
        this.capacidadeOcupantes = capacidadeOcupantes;
    }

    public Double getVelocidadeMedia() {
        return velocidadeMedia;
    }

    public void setVelocidadeMedia(Double velocidadeMedia) {
        this.velocidadeMedia = velocidadeMedia;
    }

    public Double getCombustivelMax() {
        return combustivelMax;
    }

    public void setCombustivelMax(Double combustivelMax) {
        this.combustivelMax = combustivelMax;
    }

    public Double getConsumoHora() {
        return consumoHora;
    }

    public void setConsumoHora(Double consumoHora) {
        this.consumoHora = consumoHora;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<VooEntity> getVoos() {
        return voos;
    }

    public void setVoos(List<VooEntity> voos) {
        this.voos = voos;
    }
}
