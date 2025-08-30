package com.uwu.cliente.Models.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uwu.cliente.Models.Entity.cliente;

//INTERFAZ Y DAO CLIENTE PARA HABLAR CON LA BD

public interface clienteRepository extends JpaRepository<cliente, Long> {

} 
