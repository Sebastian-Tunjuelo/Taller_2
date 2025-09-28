package com.uwu.cliente.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uwu.cliente.Entity.cliente;
import com.uwu.cliente.service.clienteService;
//import com.uwu.cliente.service.productoService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/cliente")
public class clienteController {
    // inyetmos el servicio
    @Autowired
    clienteService clienteService;

    // @Autowired
    // productoService productoService;

    @GetMapping({ "", "/" })
    public String listaClientes(Model model) {
        model.addAttribute("titulo", "uwu que si sirva si dios quiere y lo permite amen");
        model.addAttribute("clientes", clienteService.findAllClientes());
        // model.addAttribute("productos", productoService.findAllProductos());
        return "cliente";
    }

    // esta es la url en la que esta
    @GetMapping("/nuevo_cliente")
    public String mostrarFormularioRegistroCliente(Model model) {
        cliente cliente = new cliente();
        model.addAttribute("titulo", "parece que si sirvio :)");
        model.addAttribute("cliente", cliente);
        // esta es la url a la que va
        return "crearClientes";
    }

    @PostMapping("")
    // modelatrribute se usa para vincular datos de un formulario y trae el objeto
    // completo
    public String guardarCliente(@Valid @ModelAttribute("cliente") cliente cliente, BindingResult result) {
        // Valid valida el objeto 'cliente' usando las reglas de entidad
        // valid tambien activa las validaciones de las entidades
        // BindingResult: guarda los errores de validación que encuentre @Valid.
        if (result.hasErrors()) {
            return "crearClientes"; // Vuelve al formulario mostrando los errores
        }

        cliente.setCreateAt(new java.util.Date());// todo culpa de samuel
        clienteService.saveCliente(cliente);
        return "redirect:/cliente/";
    }

    @GetMapping("/editar/{id}")
    // pathvariable extrae los valores directamente desde la url
    public String mostarFormularioEditarCliente(@PathVariable Long id, Model model) {
        model.addAttribute("cliente", clienteService.getClienteById(id));
        return "editarCliente";
    }

    @PostMapping("/editar/{id}")
    public String actualizarCliente(@PathVariable Long id, @Valid @ModelAttribute("cliente") cliente cliente,
            BindingResult result) {
        if (result.hasErrors()) {
            return "editarCliente"; // Vuelve al formulario mostrando los errores
        }
        clienteService.updaCliente(id, cliente);
        return "redirect:/cliente/";
    }

    @GetMapping("/{id}")
    public String eliminarCliente(@PathVariable Long id) {
        clienteService.deleteCliente(id);
        return "redirect:/cliente/";
    }

}
