package com.projeto_dsc.Companhia_Area.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import com.projeto_dsc.Companhia_Area.dto.VooDTO;

import java.util.Objects;

@Getter
@Setter
@Entity
@Table (name = "VOO")
public class VooEntity {

    //Get e Set Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Get e Set origem
    @Column (nullable = false)
    private String origem;

    //Get e Set numero do VOo
    @Column (nullable = false)
    private int numeroVoo;

    //Get e Set destino
    @Column (nullable = false)
    private String destino;

    //Get e Set duracao
    @Column (nullable = false)
    private Double distancia;

    //Get e Set aeronave
    @ManyToOne
    @JoinColumn(name = "aeronave_id")
    private AeronaveEntity aeronave;

    public VooEntity(VooDTO voo) {
        BeanUtils.copyProperties(voo, this);
    }

    public VooEntity() {

    }

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

 