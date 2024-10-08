package com.projeto_dsc.Companhia_Area.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.projeto_dsc.Companhia_Area.entity.UsuarioEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
    UserDetails findByEmail(String email);
}
