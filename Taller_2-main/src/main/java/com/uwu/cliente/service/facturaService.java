package com.uwu.cliente.service;

import java.util.List;

import com.uwu.cliente.Entity.factura;

public interface facturaService {
    List<factura> findAllFacturas();

    factura getFacturaById(Long id);
    factura saveFactura(factura factura);
    factura updateFactura(Long id, factura factura);
    List<factura> findByClienteId(Long clienteId);
    void deleteFactura(Long id);
}
