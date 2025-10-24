package com.uwu.cliente.Controller;

import java.util.List;

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
    public String facturaPorQuery(@RequestParam("clienteId") Long clienteId, Model model,
            RedirectAttributes redirectAttributes) {
        for (cliente cliente : clienteService.findAllClientes()) {
            if (cliente.getId() == clienteId) {
                return "redirect:/ventas/factura/" + clienteId;
            }
        }
        redirectAttributes.addFlashAttribute("error", "cliente no encontrado");
        return "redirect:/ventas/seleccionarCliente";
    }

    @GetMapping("/factura/{clienteId}")
    public String mostrarFactura(
            @PathVariable Long clienteId, @RequestParam(value = "facturaId", required = false) Long facturaId,
            Model model) {
        factura factura;
        if (facturaId != null) {
            factura = facturaService.getFacturaById(facturaId);
        } else {
            factura = new factura();
            cliente cliente = clienteService.getClienteById(clienteId);
            factura.setCliente(cliente);
            factura.setFecha_Compra(new java.util.Date());
            facturaService.saveFactura(factura);
            // basicamente estoy enviendo el id de factura para que no se me pierda por la
            // url de forma "temporal"
            return "redirect:/ventas/factura/" + clienteId + "?facturaId=" + factura.getNro_Venta();
        }
        float subtotalGeneral = 0;
        float descuentoGeneral = 0;
        float totalGeneral = 0;
        /*
         * for (detalle detalle : detalleService.findAllDetalles()) {
         * if (detalle.getFactura().getNro_Venta() == factura.getNro_Venta()) {
         * subtotalGeneral += detalle.getSubtotal();
         * descuentoGeneral += (detalle.getDescuento_Unitario() *
         * detalle.getCantidad());
         * totalGeneral += detalle.getTotal();
         * }
         * }
         */
        for (detalle detalle : detalleService.findByFactudaId(factura.getNro_Venta())) {
            subtotalGeneral += detalle.getSubtotal();
            descuentoGeneral += (detalle.getDescuento_Unitario() * detalle.getCantidad());
            totalGeneral += detalle.getTotal();
        }
        factura.setSubtotal(subtotalGeneral);
        factura.setDescuento_Total(descuentoGeneral);
        factura.setValor_total(totalGeneral);

        model.addAttribute("cliente", factura.getCliente());
        model.addAttribute("factura", factura);
        model.addAttribute("detalles", detalleService.findByFactudaId(factura.getNro_Venta()));
        return "ventas/factura";
    }

    @PostMapping("/factura/{clienteId}/agregarDetalle")
    public String agregarDetalle(@RequestParam Long facturaId,
            @PathVariable("clienteId") Long clienteId,
            @RequestParam Long id_producto,
            @ModelAttribute("detalle") detalle detalle,
            RedirectAttributes redirectAttributes) {

        producto producto = productoService.getProductoById(id_producto);
        if (producto == null) {
            // es un valor model que se guarda temporalmente
            redirectAttributes.addFlashAttribute("error", "Producto no encontrado.");
            return "redirect:/ventas/factura/" + clienteId + "?facturaId=" + facturaId;
        }

        if (detalle.getCantidad() <= 0) {
            redirectAttributes.addFlashAttribute("error", "La cantidad debe ser mayor a 0.");
            return "redirect:/ventas/factura/" + clienteId + "?facturaId=" + facturaId;
        }

        if (detalle.getCantidad() > producto.getStock()) {
            redirectAttributes.addFlashAttribute("error",
                    "La cantidad solicitada (" + detalle.getCantidad() + ") supera el stock disponible ("
                            + producto.getStock() + ").");
            return "redirect:/ventas/factura/" + clienteId + "?facturaId=" + facturaId;
        }
        factura factura = facturaService.getFacturaById(facturaId);
        detalle.setProducto(producto);
        detalle.setFactura(factura);
        producto.setStock(producto.getStock() - detalle.getCantidad());
        detalle.setValor(producto.getP_unitario());
        for (detalle detalle2 : detalleService.findByFactudaId(facturaId)) {
            if ((detalle2.getProducto() == producto) &&
                    (detalle2.getDescuento_Unitario() == detalle.getDescuento_Unitario())) {
                detalle2.setCantidad(detalle.getCantidad() + detalle2.getCantidad());
                detalleService.calcular(detalle2);
                redirectAttributes.addFlashAttribute("success", "Detalle agregado correctamente.");
                return "redirect:/ventas/factura/" + clienteId + "?facturaId=" + factura.getNro_Venta();
            }
        }

        /*
         * float subtotal = producto.getP_unitario() * detalle.getCantidad();
         * detalle.setSubtotal(subtotal);
         * detalle.setTotal(subtotal - (detalle.getDescuento_Unitario() *
         * detalle.getCantidad()));
         * detalleService.saveDetalle(detalle);
         */
        detalleService.calcular(detalle);
        redirectAttributes.addFlashAttribute("success", "Detalle agregado correctamente.");
        return "redirect:/ventas/factura/" + clienteId + "?facturaId=" + factura.getNro_Venta();
    }

    // Método para listar todas las facturas
@GetMapping("/facturas")
public String listarFacturas(Model model) {
    model.addAttribute("facturas", facturaService.findAllFacturas());
    return "Ventas/listaFactura";
}

// Método para ver detalle de una factura específica
@GetMapping("/factura/detalle/{facturaId}")
public String verDetalleFactura(@PathVariable Long facturaId, Model model) {
    factura factura = facturaService.getFacturaById(facturaId);
    
    float subtotalGeneral = 0;
    float descuentoGeneral = 0;
    float totalGeneral = 0;
    
    for (detalle detalle : detalleService.findByFactudaId(factura.getNro_Venta())) {
        subtotalGeneral += detalle.getSubtotal();
        descuentoGeneral += (detalle.getDescuento_Unitario() * detalle.getCantidad());
        totalGeneral += detalle.getTotal();
    }
    
    factura.setSubtotal(subtotalGeneral);
    factura.setDescuento_Total(descuentoGeneral);
    factura.setValor_total(totalGeneral);
    
    model.addAttribute("factura", factura);
    model.addAttribute("cliente", factura.getCliente());
    model.addAttribute("detalles", detalleService.findByFactudaId(factura.getNro_Venta()));
    
    return "Ventas/detalleFactura";
}


@GetMapping("/factura/eliminar/{facturaId}")
public String eliminarFactura(@PathVariable Long facturaId, RedirectAttributes redirectAttributes) {
    try {
        // Primero eliminar los detalles asociados
        List<detalle> detalles = detalleService.findByFactudaId(facturaId);
        for (detalle det : detalles) {
            // Devolver el stock al producto
            producto prod = det.getProducto();
            prod.setStock(prod.getStock() + det.getCantidad());
            productoService.saveProducto(prod);
            // Eliminar el detalle
            detalleService.deleteDetalle(det.getNro_Item());
        }
        // Luego eliminar la factura
        facturaService.deleteFactura(facturaId);
        redirectAttributes.addFlashAttribute("success", "Factura eliminada correctamente.");
    } catch (Exception e) {
        redirectAttributes.addFlashAttribute("error", "Error al eliminar la factura.");
    }
    return "redirect:/ventas/facturas";
}
}
