package com.example.demo.service;
import java.util.List;
import com.example.demo.entity.Local;

//definir metodos implementados de la capa de servicio
public interface LocalService {
    List<Local> findAllLocals();
    Local saveLocal(Local local);
    Local updateLocal(Long id, Local local);
    void deleteLocal(Long id);
}
