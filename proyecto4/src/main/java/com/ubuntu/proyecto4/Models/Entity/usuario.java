package com.ubuntu.proyecto4.Models.Entity;


import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="USUARIO")
public class usuario implements Serializable {


//Generar e Identificar ID En La Base de Datos
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
     private long id;

     //@Column() se utiliza para modificar o dar parametros especificos a las columnas.

     private String nombre;
     private String apellido;
     private String correo;
     @Column(name = "create_at")
     @Temporal(TemporalType.DATE)
     private Date CreateAt;
   

   //Constructor Vacío
   public usuario(){}
   
   //Constructor
   public usuario(String nombre, String apellido, String correo, long id, Date fecha){
    this.nombre = nombre;
    this.apellido = apellido;
    this.correo = correo;
    this.id = id;
    this.CreateAt = fecha;
   }

   public String getNombre(){

    return nombre;
   }
   public String getApellido(){
    return apellido;
   }
   public String getCorreo(){
    return correo;
   }
   public long getId(){
     return id;
   }
    public Date getCreateAt() {
        return CreateAt;
    }
   public void setNombre(String nombre){
        this.nombre = nombre;
   }
   public void setApellido(String apellido){
        this.apellido = apellido;
   }
   public void setCorreo(String correo){
        this.correo = correo;
   }
   public void setId(long id){
     this.id = id;
   }

    public void setCreateAt(Date CreateAt) {
        this.CreateAt = CreateAt;
    }

   

}