package com.uwu.cliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uwu.cliente.Entity.producto;
@Repository
public interface productoRepository extends JpaRepository<producto,Long> {
    
}
