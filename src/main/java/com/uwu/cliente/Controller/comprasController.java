package com.uwu.cliente.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
    public String facturaPorQuery(@RequestParam("id") long id, Model model) {
        return "redirect:/ventas/factura/" + id;
    }

    @GetMapping("/factura/{id}")
    public String mostrarFactura(@PathVariable long id, Model model) {
        factura factura = new factura();
        cliente cliente =new cliente();
        cliente = clienteService.getClienteById(id);
        factura.setCliente(cliente);
        factura.setFecha_Compra(new java.util.Date());
        facturaService.saveFactura(factura);
        model.addAttribute("cliente", cliente);
        model.addAttribute("factura", factura);
        return "ventas/factura";
    }

    @PostMapping("/factura/{id}/agregarDetalle")
    public String agregarDetalle(@PathVariable("facturaId")long facturaId,@RequestParam("productoId")long productoId,
        @RequestParam("cantidad") float cantidad,@RequestParam("descuento") float descuento ,  RedirectAttributes redirectAttributes
    ){
        factura factura=facturaService.getFacturaById(facturaId);
        producto producto=productoService.getProductoById(productoId);

        detalle detalle=new detalle();
        detalle.setFactura(factura);
        detalle.setProducto(producto);
        detalle.setCantidad(cantidad);
        detalle.setValor(producto.getP_unitario());
        detalle.setDescuento_Unitario(descuento);
        detalle.setSubtotal(producto.getP_unitario()*cantidad);
        detalle.setTotal(detalle.getSubtotal()-descuento);
        detalleService.saveDetalle(detalle);

        float nuevoSubtotal=0;
        float nuevoDescuentoTotal=0;

        if (factura.getDetalles() != null) {
            for (detalle d : factura.getDetalles()) {
                nuevoSubtotal += d.getSubtotal();
                nuevoDescuentoTotal += d.getDescuento_Unitario();
            }
        }
        factura.setSubtotal(nuevoSubtotal);
        factura.setDescuento_Total(nuevoDescuentoTotal);
        factura.setValor_total(nuevoSubtotal - nuevoDescuentoTotal);
        facturaService.saveFactura(factura);

        return "redirect:ventas/factura" + facturaId;
    }

}
