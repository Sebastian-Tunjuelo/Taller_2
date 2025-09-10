package com.uwu.cliente.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "producto")
public class producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private String descripcion;
    private double p_unitario;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public double getP_unitario() {
        return p_unitario;
    }
    public void setP_unitario(double p_unitario) {
        this.p_unitario = p_unitario;
    }
    public producto(long id, String nombre, String descripcion, double p_unitario) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.p_unitario = p_unitario;
    }

}
