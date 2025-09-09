package com.uwu.cliente.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uwu.cliente.Entity.cliente;
import com.uwu.cliente.service.clienteService;

@Controller
@RequestMapping("/cliente")
public class clienteController {
        //inyetmos el servicio
        @Autowired
        clienteService clienteService;

        @GetMapping({"", "/"})
        public String listaClientes(Model model){
            model.addAttribute("titulo", "uwu que si sirva si dios quiere y lo permite amen");
            model.addAttribute("clientes", clienteService.findAllClientes());
            return "cliente";
        }

        @GetMapping("/nuevo_cliente")
        public String mostrarFormularioRegistroCliente(Model model){
            cliente cliente=new cliente();
            model.addAttribute("titulo", "parece que si sirvio :)");
            model.addAttribute("cliente", cliente);
            return "crearClientes";
        }

        @PostMapping("")
        public String guardarCliente(@ModelAttribute("cliente") cliente cliente){
            clienteService.saveCliente(cliente);
            return "redirect:/cliente/";
        }

 

}


