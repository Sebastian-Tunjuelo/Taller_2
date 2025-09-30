package com.uwu.cliente.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uwu.cliente.Entity.factura;
import com.uwu.cliente.repository.facturaRepository;

@Service
public class facturaServiceImpl implements facturaService{

    @Autowired
    facturaRepository facturaRepository;

    @Override
    public List<factura> findAllFacturas() {
       return facturaRepository.findAll();
    }

    @Override
    public factura getFacturaById(Long id) {
        return facturaRepository.findById(id).get();
    }

    @Override
    public factura saveFactura(factura factura) {
       return facturaRepository.save(factura);
    }

    @Override
    public factura updateFactura(Long id, factura factura) {
        factura facturaDb =facturaRepository.findById(id).get();
        facturaDb.setCliente(factura.getCliente());
        facturaDb.setDescuento_Total(factura.getDescuento_Total());
        facturaDb.setDetalles(factura.getDetalles());
        facturaDb.setFecha_Compra(factura.getFecha_Compra());
        facturaDb.setSubtotal(factura.getSubtotal());
        facturaDb.setValor_total(factura.getValor_total());
     return facturaRepository.save(facturaDb);
    }


    @Override
    public void deleteFactura(Long id) {
       facturaRepository.deleteById(id);
    }
    
}
