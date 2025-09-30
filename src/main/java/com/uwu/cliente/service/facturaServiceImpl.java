package com.uwu.cliente.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.uwu.cliente.Entity.factura;

@Service
public class facturaServiceImpl implements facturaService{

    @Override
    public List<factura> findAllFacturas() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllFacturas'");
    }

    @Override
    public factura getFacturaById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getFacturaById'");
    }

    @Override
    public factura saveFactura(factura factura) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveFactura'");
    }

    @Override
    public factura updateFactura(Long id, factura factura) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateFactura'");
    }

    @Override
    public List<factura> findByClienteId(Long clienteId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByClienteId'");
    }

    @Override
    public void deleteFactura(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteFactura'");
    }
    
}
