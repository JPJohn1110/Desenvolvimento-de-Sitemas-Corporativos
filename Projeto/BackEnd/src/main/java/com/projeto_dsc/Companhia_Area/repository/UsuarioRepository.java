package com.projeto_dsc.Companhia_Area.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.security.core.userdetails.UserDetails;

import com.projeto_dsc.Companhia_Area.entity.UsuarioEntity;
import java.util.List;


public interface UsuarioRepository extends JpaRepository <UsuarioEntity, Long> {
	//UserDetails	 findByEmail(String email);

}
