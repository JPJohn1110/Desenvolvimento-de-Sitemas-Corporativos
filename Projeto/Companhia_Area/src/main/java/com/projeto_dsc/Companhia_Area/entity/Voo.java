package com.projeto_dsc.Companhia_Area.entity;

import org.springframework.beans.BeanUtils;

import com.projeto_dsc.Companhia_Area.dto.VooDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "Voo")
public class Voo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false)
    private String origem;

    @Column (nullable = false)
    private String destino;

    @Column (nullable = false)
    private String horaSaida;

    @Column (nullable = false)
    private String horaChegada;

    public Voo(VooDTO vooDTO) {
        BeanUtils.copyProperties(vooDTO, this);
    }

    public Voo() {
    }

    //Getter e Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(String horaSaida) {
        this.horaSaida = horaSaida;
    }

    public String getHoraChegada() {
        return horaChegada;
    }

    public void setHoraChegada(String horaChegada) {
        this.horaChegada = horaChegada;
    }



}

 