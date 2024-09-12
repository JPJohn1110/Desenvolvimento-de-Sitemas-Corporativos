package com.projeto_dsc.Companhia_Area.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.projeto_dsc.Companhia_Area.entity.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository <UsuarioEntity, Long> {

}
