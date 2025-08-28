package com.ubuntu.proyecto4.Models.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ubuntu.proyecto4.Models.Entity.usuario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


//Usuario Data Access Object Implementacion

@Repository
public class usuarioDAOImp implements IUsarioDAO{

    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    @Override
    public List<usuario> findAll() {
        
        return em.createQuery("from Usuario").getResultList();
    }
    

}
