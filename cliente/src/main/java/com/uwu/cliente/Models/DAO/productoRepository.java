package com.uwu.cliente.Models.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uwu.cliente.Models.Entity.producto;

//INTERFAZ Y DAO PRODUCTO PARA HABLAR CON LA BD

public interface productoRepository extends JpaRepository<producto, Long> {
    
}
