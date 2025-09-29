package com.uwu.cliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.uwu.cliente.Entity.detalle;

@Repository
public interface detalleRepository extends JpaRepository<detalle,Long> {
    
}
