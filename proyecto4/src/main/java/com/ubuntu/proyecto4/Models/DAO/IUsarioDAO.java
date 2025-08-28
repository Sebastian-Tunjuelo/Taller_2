package com.ubuntu.proyecto4.Models.DAO;

//Usuario Data Access Object Interfaz

import java.util.List;

import com.ubuntu.proyecto4.Models.Entity.usuario;



public interface  IUsarioDAO {
 
    
    public List<usuario> findAll();
}
