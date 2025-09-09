package com.uwu.cliente.service;

import java.util.List;

import com.uwu.cliente.Entity.producto;

public interface productoServise {
      List<producto> findAllProductos();
    producto saveProducto(producto cliente);
    producto updaProducto (Long id,producto cliente);
    void deleteProducto (Long id);
}
