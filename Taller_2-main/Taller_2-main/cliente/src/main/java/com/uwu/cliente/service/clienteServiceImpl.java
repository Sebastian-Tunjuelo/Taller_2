package com.uwu.cliente.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uwu.cliente.Entity.cliente;
import com.uwu.cliente.repository.clienteRepository;

@Service
public class clienteServiceImpl implements clienteService {

    //inyetamos repositorio
    @Autowired
    clienteRepository clienteRepository;
    //estos metodos como save upda son del jpa
    @Override
    public List<cliente> findAllClientes() {
       return clienteRepository.findAll();
    }

    @Override
    public cliente saveCliente(cliente cliente) {
        return clienteRepository.save(cliente);
    }

     @Override
    public cliente getClienteById(Long id) {
       return clienteRepository.findById(id).get();
    }

    @Override
    public cliente updaCliente(Long id, cliente cliente) {
        //obtenemos valor de cliente
        cliente clienteDb=clienteRepository.findById(id).get();
        
        return clienteRepository.save(clienteDb);
    }

    @Override
    public void deleteCliente(Long id) {
        clienteRepository.deleteById(id);
    }

   
    
}
