package com.uwu.cliente.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.uwu.cliente.Entity.producto;
import com.uwu.cliente.repository.productoRepository;

@Service
public class productoServiceImpl implements productoService {

    @Autowired

    productoRepository productoRepository;

    @Override
    public List<producto> findAllProductos() {
        return productoRepository.findAll();
    }

    @Override
    public producto saveProducto(producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public producto updaProducto(Long id, producto producto) {
        producto productoDb = productoRepository.findById(id).get();
        productoDb.setNombre(producto.getNombre());
        productoDb.setDescripcion(producto.getDescripcion());
        productoDb.setP_unitario(producto.getP_unitario());
        productoDb.setStock(producto.getStock());
        return productoRepository.save(productoDb);
    }

    @Override
    public void deleteProducto(Long id) {
        productoRepository.deleteById(id);
    }

    

    @Override

    public producto getProductoById(Long id) {
        return productoRepository.findById(id).get();
    }

    @Override
    public producto hideProducto(Long id, producto producto) {
        
        
        producto.setEstado(false);

        return productoRepository.save(producto);
    }
}
