package com.projeto_dsc.Companhia_Area.repository;

import com.projeto_dsc.Companhia_Area.dto.UsuarioDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import com.projeto_dsc.Companhia_Area.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
    UserDetails findByEmail(String email);

    UsuarioEntity findByCodigoAcesso(String codigoAcesso);

}
