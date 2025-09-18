package com.uwu.cliente.service;

import java.util.List;

import com.uwu.cliente.Entity.producto;

public interface productoService {
      List<producto> findAllProductos();
    producto getProductoById(Long id);
    producto saveProducto(producto cliente);
    producto updaProducto (Long id,producto cliente);
    void deleteProducto (Long id);
}

