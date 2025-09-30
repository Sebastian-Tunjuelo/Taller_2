package com.uwu.cliente.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class detalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long nro_Item;

    @ManyToOne
    @JoinColumn(name = "id_factura")
    private factura factura;

    @ManyToOne
    @JoinColumn(name = "id_producto") 
    private producto producto;

    private float cantidad,valor, descuento_Unitario,subtotal,total;

    public detalle(){}

    public detalle(long nro_Item, factura factura, producto producto,
            float cantidad, float valor, float descuento_Unitario ,float subtotal, float total) {
        this.nro_Item = nro_Item;
        this.factura = factura;
        this.producto = producto;
        this.cantidad = cantidad;
        this.valor = valor;
        this.descuento_Unitario = descuento_Unitario;
        this.subtotal= subtotal;
        this.total=total;
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

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
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

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }


}
