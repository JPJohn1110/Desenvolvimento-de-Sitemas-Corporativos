package com.projeto_dsc.Companhia_Area.entity;

import com.projeto_dsc.Companhia_Area.dto.AeronaveDTO;
import jakarta.persistence.*;
import org.springframework.beans.BeanUtils;

@Entity
@Table (name = "Aeronave")
public class AeronaveEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false)
    private String modelo;

    @Column (nullable = false)
    private int capacidade;

    @Column (nullable = false)
    private int assentosPrimeiraClasse;

    @Column (nullable = false)
    private int assentosSegundaClasse;

    @Column (nullable = false)
    private int portaEmbarque;

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

    public AeronaveEntity(AeronaveDTO aeronave) {
        BeanUtils.copyProperties(aeronave, this);
    }

    public AeronaveEntity() {
    }

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

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }
}
