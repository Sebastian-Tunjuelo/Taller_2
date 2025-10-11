package com.uwu.cliente.Entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.PositiveOrZero;


@Entity
public class factura {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_factura")
    private Long nro_Venta;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private cliente cliente;
   @PositiveOrZero(message = "no pueden ser valores negativos")
    private float subtotal, descuento_Total, valor_total;
    @Column(name = "fecha_compra")
    private Date fecha_Compra;

    //mappedBy indica que la relación es bidireccional y especifica qué campo en la entidad relacionada es el papá de la relación.
    @OneToMany(mappedBy = "factura")
    private List<detalle>detalles;


    public factura(){}


    public factura(Long nro_Venta, cliente cliente, float subtotal, float descuento_Total,
            float valor_total, Date fecha_Compra, List<detalle> detalles) {
        this.nro_Venta = nro_Venta;
        this.cliente = cliente;
        this.subtotal = subtotal;
        this.descuento_Total = descuento_Total;
        this.valor_total = valor_total;
        this.fecha_Compra = fecha_Compra;
        this.detalles = detalles;
    }


    public Long getNro_Venta() {
        return nro_Venta;
    }


    public void setNro_Venta(Long nro_Venta) {
        this.nro_Venta = nro_Venta;
    }


    public cliente getCliente() {
        return cliente;
    }


    public void setCliente(cliente cliente) {
        this.cliente = cliente;
    }


    public float getSubtotal() {
        return subtotal;
    }


    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }


    public float getDescuento_Total() {
        return descuento_Total;
    }


    public void setDescuento_Total(float descuento_Total) {
        this.descuento_Total = descuento_Total;
    }


    public float getValor_total() {
        return valor_total;
    }


    public void setValor_total(float valor_total) {
        this.valor_total = valor_total;
    }


    public Date getFecha_Compra() {
        return fecha_Compra;
    }


    public void setFecha_Compra(Date fecha_Compra) {
        this.fecha_Compra = fecha_Compra;
    }


    public List<detalle> getDetalles() {
        return detalles;
    }


    public void setDetalles(List<detalle> detalles) {
        this.detalles = detalles;
    }

}
