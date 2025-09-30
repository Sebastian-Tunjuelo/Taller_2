package com.uwu.cliente.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.uwu.cliente.Entity.cliente;
import com.uwu.cliente.Entity.factura;
import com.uwu.cliente.service.clienteService;
import com.uwu.cliente.service.detalleService;
import com.uwu.cliente.service.facturaService;

@Controller
@RequestMapping("/ventas")
public class comprasController {

    @Autowired
    facturaService facturaService;

    @Autowired
    detalleService detalleService;

    @Autowired
    clienteService clienteService;

    @GetMapping("/seleccionarCliente")
    public String seleccionarCliente(Model model) {
        model.addAttribute("cliente", new cliente());
        return "Ventas/seleccionarCliente";
    }

    @GetMapping("/factura")
    public String facturaPorQuery(@RequestParam("id") long id, Model model) {
        return "redirect:/ventas/factura/" + id;
    }

    @GetMapping("/factura/{id}")
    public String mostrarFactura(@PathVariable long id, Model model) {
        factura factura = new factura();
        factura.setCliente(clienteService.getClienteById(id));
        model.addAttribute("factura", factura);
        return "ventas/factura";
    }

}
