package com.projeto_dsc.Companhia_Area.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.projeto_dsc.Companhia_Area.entity.VooEntity;

import java.util.List;

public interface VooRepository extends JpaRepository <VooEntity, Long>	{
    List<VooEntity> findByDestinoContainingIgnoreCase(String destino);
    List<VooEntity> findByOrigemContainingIgnoreCase(String origem);
    List<VooEntity> findByAeronaveModeloContainingIgnoreCase(String modelo);
}
