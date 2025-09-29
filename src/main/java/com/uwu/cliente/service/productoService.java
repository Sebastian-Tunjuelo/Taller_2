package com.uwu.cliente.service;

import java.util.List;

import com.uwu.cliente.Entity.producto;

public interface productoService {
    List<producto> findAllProductos();

    producto getProductoById(Long id);

    producto saveProducto(producto producto);

    producto updaProducto(Long id, producto producto);

    producto hideProducto(Long id, producto producto);

    void deleteProducto(Long id);
}
