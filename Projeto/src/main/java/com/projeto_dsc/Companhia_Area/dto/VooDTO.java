package com.projeto_dsc.Companhia_Area.dto;

import com.projeto_dsc.Companhia_Area.entity.AeronaveEntity;
import org.springframework.beans.BeanUtils;
import com.projeto_dsc.Companhia_Area.entity.VooEntity;

public class VooDTO {

	private Long id;
    private String origem;
    private String destino;
    private String duracao;
	private int numeroVoo;
	private AeronaveEntity aeronave;

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

	public String getDuracao() {
		return duracao;
	}

	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}

	public int getNumeroVoo() {
		return numeroVoo;
	}

	public void setNumeroVoo(int numeroVoo) {
		this.numeroVoo = numeroVoo;
	}

	public AeronaveEntity getAeronave() {
		return aeronave;
	}

	public void setAeronave(AeronaveEntity aeronave) {
		this.aeronave = aeronave;
	}

	//Getters e Setters

}
