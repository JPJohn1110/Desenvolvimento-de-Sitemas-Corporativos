package com.projeto_dsc.Companhia_Area.repository;

import com.projeto_dsc.Companhia_Area.entity.UsuarioRole;
import org.springframework.data.jpa.repository.JpaRepository;
import com.projeto_dsc.Companhia_Area.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
    UserDetails findByEmail(String email);
    UsuarioEntity findByCodigoAcesso(String codigoAcesso);
    @Query("SELECT u.nome FROM UsuarioEntity u WHERE u.email = ?1")
    String findNomeByEmail(String email);
    List<UsuarioEntity> findByRole(UsuarioRole role);
}
