package com.projeto_dsc.Companhia_Area.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projeto_dsc.Companhia_Area.dto.AeronaveDTO;
import jakarta.persistence.*;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Table (name = "Aeronave")
public class AeronaveEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String modelo;

    @Column(nullable = false)
    private String tipo;

    @Column(nullable = false)
    private Double pesoMaxDecol;

    @Column(nullable = false)
    private Double pesoVazio;

    @Column(nullable = false)
    private int capacidadeOcupantes;

    @Column(nullable = false)
    private Double velocidadeMedia;

    @Column(nullable = false)
    private Double combustivelMax;

    @Column(nullable = false)
    private Double consumoHora;

    @OneToMany (mappedBy = "aeronave", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<VooEntity> voos = new ArrayList<>();

    public AeronaveEntity() {
    }
    public AeronaveEntity(AeronaveDTO aeronave) {BeanUtils.copyProperties(aeronave, this);}

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

    public Double autonomia(){
        Double tempoVoo = this.combustivelMax / this.consumoHora;
        return tempoVoo * this.velocidadeMedia;
    }

    public Double pesoDisponivel(){
        return this.pesoMaxDecol - this.pesoVazio;
    }
    
    public int primeiraClasse(){
        if (this.capacidadeOcupantes <= 20) {
            return this.capacidadeOcupantes;
        }
        return (int) (this.capacidadeOcupantes * 0.4);
    }

    public int economicaClasse(){
        if (this.capacidadeOcupantes < 20) {
            return 0;
        }
        return this.capacidadeOcupantes - primeiraClasse();
    }


    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AeronaveEntity that = (AeronaveEntity) o;
        return id == that.id;
    }
}