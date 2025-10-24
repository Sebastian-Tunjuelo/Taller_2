package com.uwu.cliente.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uwu.cliente.Entity.factura;

@Repository
public interface facturaRepository extends JpaRepository<factura,Long> {
    
}
