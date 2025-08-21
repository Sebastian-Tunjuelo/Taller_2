package com.example.demo.Controllers;

public class Nombre {
    private String nombre="";

    public Nombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }
}