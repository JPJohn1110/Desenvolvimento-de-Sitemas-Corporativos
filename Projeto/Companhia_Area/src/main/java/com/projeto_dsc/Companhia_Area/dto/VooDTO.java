package com.projeto_dsc.Companhia_Area.dto;

import org.springframework.beans.BeanUtils;
import com.projeto_dsc.Companhia_Area.entity.VooEntity;

public class VooDTO {

	private Long id;
    private String origem;
    private String destino;
    private String duracao;

	public VooDTO(VooEntity voo) {
		BeanUtils.copyProperties(voo, this);
    }

	public VooDTO(){

	}

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

	//Getters e Setters

}
