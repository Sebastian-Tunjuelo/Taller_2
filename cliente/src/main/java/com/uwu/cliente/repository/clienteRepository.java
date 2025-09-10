package com.uwu.cliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uwu.cliente.Entity.cliente;
@Repository
public interface clienteRepository extends JpaRepository<cliente,Long> {
    
}
