package com.projeto_dsc.Companhia_Area.dto;

import org.springframework.beans.BeanUtils;
import com.projeto_dsc.Companhia_Area.entity.Voo;

public class VooDTO {

	private Long id;
    private String origem;
    private String destino;
    private String horaSaida;
    private String horaChegada;

	public VooDTO(Voo voo) {
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


	//Getters e Setters


}
