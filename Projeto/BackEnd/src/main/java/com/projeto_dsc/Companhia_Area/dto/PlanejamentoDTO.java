package com.projeto_dsc.Companhia_Area.dto;

import com.projeto_dsc.Companhia_Area.entity.AeronaveEntity;

public class PlanejamentoDTO {

    private String modelo;
    private Double autonomia;
    private Double pesoDisponivel;
    private int primeiraClasse;
    private int economicaClasse;

    public PlanejamentoDTO(AeronaveEntity aeronave) {
        this.modelo = aeronave.getModelo();
        this.autonomia = aeronave.autonomia();
        this.pesoDisponivel = aeronave.pesoDisponivel();
        this.primeiraClasse = aeronave.primeiraClasse();
        this.economicaClasse = aeronave.economicaClasse();
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Double getAutonomia() {
        return autonomia;
    }

    public void setAutonomia(Double autonomia) {
        this.autonomia = autonomia;
    }

    public Double getPesoDisponivel() {
        return pesoDisponivel;
    }

    public void setPesoDisponivel(Double pesoDisponivel) {
        this.pesoDisponivel = pesoDisponivel;
    }

    public int getPrimeiraClasse() {
        return primeiraClasse;
    }

    public void setPrimeiraClasse(int primeiraClasse) {
        this.primeiraClasse = primeiraClasse;
    }

    public int getEconomicaClasse() {
        return economicaClasse;
    }

    public void setEconomicaClasse(int economicaClasse) {
        this.economicaClasse = economicaClasse;
    }
}
