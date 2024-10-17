package com.projeto_dsc.Companhia_Area.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.projeto_dsc.Companhia_Area.entity.VooEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VooRepository extends JpaRepository <VooEntity, Long>	{
    List<VooEntity> findByDestinoContainingIgnoreCase(String destino);
    List<VooEntity> findByOrigemContainingIgnoreCase(String origem);
    List<VooEntity> findByAeronaveModeloContainingIgnoreCase(String modelo);

    @Query("SELECT COUNT(v) FROM VooEntity v WHERE v.aeronave.modelo = :modelo")
    int countVoosByAeronaveModelo(@Param("modelo") String modelo);
}
