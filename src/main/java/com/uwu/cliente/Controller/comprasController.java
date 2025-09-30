package com.uwu.cliente.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.uwu.cliente.Entity.cliente;
import com.uwu.cliente.Entity.detalle;
import com.uwu.cliente.Entity.factura;
import com.uwu.cliente.Entity.producto;
import com.uwu.cliente.service.clienteService;
import com.uwu.cliente.service.detalleService;
import com.uwu.cliente.service.facturaService;
import com.uwu.cliente.service.productoService;

@Controller
@RequestMapping("/ventas")
public class comprasController {

    @Autowired
    facturaService facturaService;

    @Autowired
    detalleService detalleService;

    @Autowired
    clienteService clienteService;

    @Autowired
    productoService productoService;

    @GetMapping("/seleccionarCliente")
    public String seleccionarCliente(Model model) {
        model.addAttribute("cliente", new cliente());
        return "Ventas/seleccionarCliente";
    }

    @GetMapping("/factura")
    public String facturaPorQuery(@RequestParam("clienteId") Long clienteId, Model model) {
        return "redirect:/ventas/factura/" + clienteId;
    }

    @GetMapping("/factura/{clienteId}")
    public String mostrarFactura(@PathVariable Long clienteId, Model model) {
        factura factura = new factura();
        cliente cliente =new cliente();
        cliente = clienteService.getClienteById(clienteId);
        factura.setCliente(cliente);
        factura.setFecha_Compra(new java.util.Date());
        facturaService.saveFactura(factura);
      
        model.addAttribute("cliente", cliente);
        model.addAttribute("factura", factura);
        return "ventas/factura";
    }

   

    @PostMapping("/factura/{clienteId}/agregarDetalle")
public String agregarDetalle(@RequestParam Long facturaId, @PathVariable("clienteId") Long clienteId, @RequestParam Long id_producto,
 @ModelAttribute("detalle") detalle detalle,RedirectAttributes redirectAttributes)
 {

    
    producto producto = productoService.getProductoById(id_producto);
    factura factura = facturaService.getFacturaById(facturaId); 
    
    detalle.setProducto(producto);
    detalle.setFactura(factura);

    detalleService.saveDetalle(detalle); 

    return "redirect:/ventas/factura/" + clienteId;
}
}

    


