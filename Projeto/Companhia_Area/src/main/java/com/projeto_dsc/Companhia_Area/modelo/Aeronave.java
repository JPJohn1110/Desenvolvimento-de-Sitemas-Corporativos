package com.projeto_dsc.Companhia_Area.modelo;

public class Aeronave {
    private String modelo;
    private int capacidade;
    private long id;
    public Aeronave(String modelo, int capacidade, long id) {
        this.modelo = modelo;
        this.capacidade = capacidade;
        this.id = id;
    }
    public String getModelo() {
        return modelo;
    }
    public int getCapacidade() {
        return capacidade;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }
}
