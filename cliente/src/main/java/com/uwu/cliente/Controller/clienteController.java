package com.uwu.cliente.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.uwu.cliente.Models.DAO.clienteRepository;
import com.uwu.cliente.Models.Entity.cliente;

@Controller
@RequestMapping("/cliente")
public class clienteController {

private final clienteRepository clienteRepository;

public clienteController(com.uwu.cliente.Models.DAO.clienteRepository clienteRepository) {
    this.clienteRepository = clienteRepository;
}

@GetMapping("/nuevo")
public String nuevoCliente(Model model){
    model.addAttribute("cliente", new cliente());

    return "/nuevo/usuario";

}
}

