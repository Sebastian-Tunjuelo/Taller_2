package com.uwu.cliente.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

        //esta es la url en la que esta
        @GetMapping("/nuevo_cliente")
        public String mostrarFormularioRegistroCliente(Model model){
            cliente cliente=new cliente();
            model.addAttribute("titulo", "parece que si sirvio :)");
            model.addAttribute("cliente", cliente);
            //esta es la url a la que va
            return "crearClientes";
        }

        @PostMapping("")
        //modelatrribute se usa para vincular datos de un formulario y trae el objeto completo
        public String guardarCliente(@ModelAttribute("cliente") cliente cliente){
            clienteService.saveCliente(cliente);
            return "redirect:/cliente/";
        }

        @GetMapping("/editar/{id}")
        //pathvariable extrae los valores directamente desde la url
        public String mostarFormularioEditarCliente(@PathVariable Long id,Model model){
            model.addAttribute("cliente", clienteService.getClienteById(id));
            return "editarCliente";
        }

        @PostMapping("/editar/{id}")
        public String actualizarCliente(@PathVariable Long id, @ModelAttribute("cliente") cliente cliente){
            clienteService.updaCliente(id, cliente);
            return "redirect:/cliente/";
        }

        @GetMapping("/{id}")
        public String eliminarCliente(@PathVariable Long id){
            clienteService.deleteCliente(id);
            return "redirect:/cliente/";
        }

}


