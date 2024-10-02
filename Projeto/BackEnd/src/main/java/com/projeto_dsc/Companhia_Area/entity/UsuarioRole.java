package com.projeto_dsc.Companhia_Area.entity;

public enum UsuarioRole {

	ADMIN("admin"),
	USUARIO("usuario");
	
	private String role;

	UsuarioRole(String role){
		this.role=role;

	}

	public String getRole(){
		return role;

	}

}
