package com.projeto_dsc.Companhia_Area.repository;

import com.projeto_dsc.Companhia_Area.entity.AeronaveEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AeronaveRepository extends JpaRepository<AeronaveEntity, Long> {
    List<AeronaveEntity> findByModelo(String modelo);
}
