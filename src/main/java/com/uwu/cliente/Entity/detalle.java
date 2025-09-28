/*package com.uwu.cliente.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class detalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long nro_Item;
    @OneToOne
    @JoinColumn(name = "id_factura")
    private factura factura;
    @OneToMany
    @JoinColumn(name = "id_producto") 
    private producto producto;
    private int cantidad;
    private float valor, descuento_Unitario;

    public detalle(){}

    public detalle(long nro_Item, com.uwu.cliente.Entity.factura factura, com.uwu.cliente.Entity.producto producto,
            int cantidad, float valor, float descuento_Unitario) {
        this.nro_Item = nro_Item;
        this.factura = factura;
        this.producto = producto;
        this.cantidad = cantidad;
        this.valor = valor;
        this.descuento_Unitario = descuento_Unitario;
    }

    public long getNro_Item() {
        return nro_Item;
    }

    public void setNro_Item(long nro_Item) {
        this.nro_Item = nro_Item;
    }

    public factura getFactura() {
        return factura;
    }

    public void setFactura(factura factura) {
        this.factura = factura;
    }

    public producto getProducto() {
        return producto;
    }

    public void setProducto(producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public float getDescuento_Unitario() {
        return descuento_Unitario;
    }

    public void setDescuento_Unitario(float descuento_Unitario) {
        this.descuento_Unitario = descuento_Unitario;
    }

    
   

}
*/