package com.projeto_dsc.Companhia_Area.dto;

import com.projeto_dsc.Companhia_Area.entity.UsuarioRole;

public record cadastroDTO(String email, String senha, UsuarioRole role, String cpf, String codigoAcesso, String nome, String telefone ) {

}
