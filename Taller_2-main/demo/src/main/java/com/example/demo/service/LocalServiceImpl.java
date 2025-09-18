package com.example.demo.service;

import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Local;
import com.example.demo.repository.LocalRepository;

@Service
public class LocalServiceImpl implements LocalService{
    //inyectar repositorio
    @Autowired
    LocalRepository localRepository;

    @Override
    public List<Local> findAllLocals() {
      return localRepository.findAll();
    }
    //estos metodos como save upda son del jpa
    @Override
    public Local saveLocal(Local local) {
        return localRepository.save(local);
    }

    @Override
    public Local updateLocal(Long id, Local local) {
        //obtenemos el valor a actualizar
        Local localDb= localRepository.findById(id).get();
        //validaciones
        //   valor no nulo                 o        informacion vacia   
        if (Objects.nonNull(local.getCode()) &&!"".equalsIgnoreCase(local.getCode())) {
            localDb.setCode(local.getCode());
        }
          if (Objects.nonNull(local.getFloor()) &&!"".equalsIgnoreCase(local.getFloor())) {
            localDb.setFloor(local.getFloor());
        }
          if (Objects.nonNull(local.getName()) &&!"".equalsIgnoreCase(local.getName())) {
            localDb.setName(local.getName());
        }
        return localRepository.save(localDb);
    }

    @Override
    public void deleteLocal(Long id) {
       localRepository.deleteById(id);
    }
    
}
