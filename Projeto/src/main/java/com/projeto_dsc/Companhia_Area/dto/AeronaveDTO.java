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

    //Construtores
    public AeronaveDTO(AeronaveEntity aeronave) {BeanUtils.copyProperties(aeronave, this);}
    public AeronaveDTO() {}

    //Get e Set id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    //Get e Set modelo
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    //Get e Set PesoMaxDecol
    public Double getPesoMaxDecol() {
        return pesoMaxDecol;
    }

    public void setPesoMaxDecol(Double pesoMaxDecol) {
        this.pesoMaxDecol = pesoMaxDecol;
    }

    //Get e Set PesoVazio
    public Double getPesoVazio() {
        return pesoVazio;
    }

    public void setPesoVazio(Double pesoVazio) {
        this.pesoVazio = pesoVazio;
    }

    //Get e Set CapacidadeOcupantes
    public int getCapacidadeOcupantes() {
        return capacidadeOcupantes;
    }

    public void setCapacidadeOcupantes(int capacidadeOcupantes) {
        this.capacidadeOcupantes = capacidadeOcupantes;
    }

    //Get e Set VelocidadeMedia
    public Double getVelocidadeMedia() {
        return velocidadeMedia;
    }

    public void setVelocidadeMedia(Double velocidadeMedia) {
        this.velocidadeMedia = velocidadeMedia;
    }

    //Get e Set CombustivelMax
    public Double getCombustivelMax() {
        return combustivelMax;
    }

    public void setCombustivelMax(Double combustivelMax) {
        this.combustivelMax = combustivelMax;
    }

    //Get e Set ConsumoHora
    public Double getConsumoHora() {
        return consumoHora;
    }

    public void setConsumoHora(Double consumoHora) {
        this.consumoHora = consumoHora;
    }

    //Get e Set Tipo
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    //Get e Set voos
    public List<VooEntity> getVoos() {
        return voos;
    }

    public void setVoos(List<VooEntity> voos) {
        this.voos = voos;
    }
}
