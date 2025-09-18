package com.uwu.cliente.Entity;
import java.time.LocalDateTime;
import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "clientes")
public class cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private String apellido;
    private String correo;
    @Column(name = "create_at")
    private LocalDateTime CreateAt;

    public cliente(){}

    public cliente(LocalDateTime CreateAt, String apellido, String correo, long id, String nombre) {
        this.CreateAt = CreateAt;
        this.apellido = apellido;
        this.correo = correo;
        this.id = id;
        this.nombre = nombre;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public LocalDateTime getCreateAt() {
        return CreateAt;
    }

    public void setCreateAt(LocalDateTime CreateAt) {
        this.CreateAt = CreateAt;
    }

    
}
