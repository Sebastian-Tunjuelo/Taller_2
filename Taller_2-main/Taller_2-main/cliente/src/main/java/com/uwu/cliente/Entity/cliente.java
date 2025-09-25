package com.uwu.cliente.Entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "clientes")
public class cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_cliente")
    @NotBlank(message="EL ID NO PUEDE ESTAR VACÍO")
    @Size(min = 6, max = 12, message="El ID DEBE CONTENER SER ENTRE 6 Y 12 CARACTERES")
    private long id;

    private String nombre;
    private String apellido;

    @Email(message="EL CORREO DEBE SER VALIDO")
    private String correo;
    @Column(name = "create_at")
    @Temporal(TemporalType.DATE)
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    
    private Date CreateAt;

    public cliente(){}

    public cliente(long id, String nombre, String apellido, String correo, Date createAt) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        CreateAt = createAt;
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

    public Date getCreateAt() {
        return CreateAt;
    }

    public void setCreateAt(Date createAt) {
        CreateAt = createAt;
    }

    

    
}
