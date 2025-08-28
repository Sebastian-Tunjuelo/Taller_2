package com.uwu.cliente.Models.Entity;

import jakarta.persistence.Entity;

@Entity
public class producto {
    private long id;
    private String nombre;
    private String descripcion;
    private double p_unitario;

}
