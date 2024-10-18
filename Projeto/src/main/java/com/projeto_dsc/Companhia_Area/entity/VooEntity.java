package com.projeto_dsc.Companhia_Area.entity;

import jakarta.persistence.*;
import org.springframework.beans.BeanUtils;

import com.projeto_dsc.Companhia_Area.dto.VooDTO;

import java.util.Objects;

@Entity
@Table (name = "VOO")
public class VooEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false)
    private String origem;

    @Column (nullable = false)
    private int numeroVoo;

    @Column (nullable = false)
    private String destino;

    @Column (nullable = false)
    private String duracao;

    @ManyToOne
    @JoinColumn(name = "aeronave_id")
    private AeronaveEntity aeronave;

    public VooEntity(VooDTO voo) {
        BeanUtils.copyProperties(voo, this);
    }

    public VooEntity() {

    }

    //Get e Set Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    //Get e Set origem
    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    //Get e Set destino
    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    //Get e Set duracao
    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    //Get e Set numero do VOo
    public int getNumeroVoo() {
        return numeroVoo;
    }

    public void setNumeroVoo(int numeroVoo) {
        this.numeroVoo = numeroVoo;
    }

    //Get e Set aeronave
    public AeronaveEntity getAeronave() {
        return aeronave;
    }

    public void setAeronave(AeronaveEntity aeronave) {
        this.aeronave = aeronave;
    }

    //Hash e equal
    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VooEntity that = (VooEntity) o;
        return id == that.id;
    }
}

 