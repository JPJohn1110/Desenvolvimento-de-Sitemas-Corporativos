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
@Table (name = "VOO")
public class VooEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false)
    private String origem;

    @Column (nullable = false)
    private String destino;

    @Column (nullable = false)
    private String duracao;

    public VooEntity(VooDTO voo) {
        BeanUtils.copyProperties(voo, this);
    }

    public VooEntity() {

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
        return duracao;
    }

    public void setHoraSaida(String duracao) {
        this.duracao = duracao;
    }


}

 