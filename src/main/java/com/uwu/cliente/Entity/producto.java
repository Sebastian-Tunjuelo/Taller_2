package com.uwu.cliente.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.PositiveOrZero;

@Entity
@Table(name = "producto")
public class producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private long id;
    private String nombre;
    private String descripcion;
    @PositiveOrZero(message = "PUES DEJEMOSLO GRATIS PERO NI MODO QUE LES DEMOS PLATA")
    private double p_unitario;
    @PositiveOrZero(message = "COMO VAMOS A VENDER ALGO QUE NO TENEMOS Y ADEMAS DEBEMOS (SI SOY)")
    private int stock;

    //@OneToMany(mappedBy = "producto")
    //private List<detalle> detalles;

    public producto() {
    }

    public producto(long id, String nombre, String descripcion,double p_unitario, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.p_unitario = p_unitario;
        this.stock = stock;
    }

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

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }


}
