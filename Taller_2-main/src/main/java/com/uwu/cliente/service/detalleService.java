package com.uwu.cliente.service;

import java.util.List;

import com.uwu.cliente.Entity.detalle;

public interface detalleService {
    
    List<detalle> findAllDetalles();
    detalle getDetalleById(Long id);
    detalle saveDetalle(detalle detalle);
    detalle updateDetalle(Long id, detalle detalle);
    void deleteDetalle(Long id);

}
