package com.projeto_dsc.Companhia_Area.repository;

import com.projeto_dsc.Companhia_Area.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository <UsuarioEntity, Long> {

}
