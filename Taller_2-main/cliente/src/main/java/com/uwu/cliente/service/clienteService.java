package com.uwu.cliente.service;

import java.util.List;

import com.uwu.cliente.Entity.cliente;
//definir metodos implementados de la capa de servicio
public interface clienteService {
    List<cliente> findAllClientes();
    cliente saveCliente (cliente cliente);
    cliente getClienteById(Long id);
    cliente updaCliente (Long id,cliente cliente);
    void deleteCliente (Long id);
}
