package com.uwu.cliente.service;

import java.util.List;
import java.util.Objects;

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
//obtenemos valor de cliente
        producto productoDb = productoRepository.findById(id).get();
        //validaciones
        //   valor no nulo                        o        informacion vacia  
        if (Objects.nonNull(producto.getNombre()) &&!"".equalsIgnoreCase(producto.getNombre())) {
            productoDb.setNombre(producto.getNombre());
        }
         if (Objects.nonNull(producto.getDescripcion()) &&!"".equalsIgnoreCase(producto.getDescripcion())) {
            productoDb.setDescripcion(producto.getDescripcion());
        }
          if (Objects.nonNull(producto.getP_unitario())) {
            productoDb.setP_unitario(producto.getP_unitario());
        }
        if (Objects.nonNull(producto.getStock()))  {
            productoDb.setStock(producto.getStock());
        }
         
        return productoRepository.save(productoDb);
    }
    
    @Override
    public void deleteProducto(Long id) {
        productoRepository.deleteById(id);
    }

    @Override

    public producto getProductoById(Long id){
        return productoRepository.findById(id).get();
    }
    
}

