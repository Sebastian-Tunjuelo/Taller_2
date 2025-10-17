package com.uwu.cliente.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uwu.cliente.Entity.detalle;
import com.uwu.cliente.repository.detalleRepository;

@Service
public class detalleServiceImpl implements detalleService {

  @Autowired
  detalleRepository detalleRepository;

  @Override
  public List<detalle> findAllDetalles() {
    return detalleRepository.findAll();
  }

  @Override
  public detalle getDetalleById(Long id) {
    return detalleRepository.findById(id).get();
  }

  @Override
  public detalle saveDetalle(detalle detalle) {
    return detalleRepository.save(detalle);
  }

  @Override
  public detalle updateDetalle(Long id, detalle detalle) {
    detalle detalleDb = detalleRepository.findById(id).get();
    detalleDb.setCantidad(detalle.getCantidad());
    detalleDb.setDescuento_Unitario(detalle.getDescuento_Unitario());
    detalleDb.setProducto(detalle.getProducto());
    detalleDb.setValor(detalle.getValor());
    detalleDb.setSubtotal(detalle.getSubtotal());
    detalle.setTotal(detalle.getTotal());
    return detalleRepository.save(detalleDb);
  }

  @Override
  public void deleteDetalle(Long id) {
    detalleRepository.deleteById(id);
  }

  @Override
  public detalle calcular(detalle detalle) {
    float subtotal = detalle.getProducto().getP_unitario() * detalle.getCantidad();
    detalle.setSubtotal(subtotal);
    detalle.setTotal(subtotal - (detalle.getDescuento_Unitario() * detalle.getCantidad()));
    return detalleRepository.save(detalle);
  }

  @Override
  public List<detalle> findByFactudaId(Long factudaId) {
    return detalleRepository.findByFacturaId(factudaId);
  }

}
