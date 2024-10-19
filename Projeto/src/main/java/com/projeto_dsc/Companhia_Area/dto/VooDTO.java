package com.projeto_dsc.Companhia_Area.dto;

import com.projeto_dsc.Companhia_Area.entity.AeronaveEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;
import com.projeto_dsc.Companhia_Area.entity.VooEntity;

@Setter
@Getter
public class VooDTO {

	private Long id;
    private String origem;
    private String destino;
    private Double distancia;
	private int numeroVoo;
	private AeronaveEntity aeronave;

	public VooDTO(VooEntity voo) {
		BeanUtils.copyProperties(voo, this);
    }

	public VooDTO(){

	}


}
