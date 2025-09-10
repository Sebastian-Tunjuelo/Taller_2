package com.uwu.cliente.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uwu.cliente.Entity.producto;
import com.uwu.cliente.service.productoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping("/producto")
public class productoController {
    //inyectamos el servicio
    @Autowired
    productoService productoService;

    @GetMapping({"", "/"})
    public String listaProductos(Model model) {
        model.addAttribute("titulo", "Lista de Productos");
        model.addAttribute("productos", productoService.findAllProductos());
        return "producto";
    }

    @GetMapping("/nuevo_producto")
    public String mostrarFormularioRegistroProducto(Model model) {
        producto producto = new producto();
        model.addAttribute("titulo", "Crear Nuevo Producto");
        model.addAttribute("producto", producto);
        return "crearProducto";
    }

    @PostMapping("")
    public String guardarProducto(@ModelAttribute("producto") producto producto) {
        productoService.saveProducto(producto);
        return "redirect:/producto/";
    }
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarProducto(@PathVariable Long id, Model model) {
        model.addAttribute("producto", productoService.getProductoById(id));
        return "editarProducto";
    }
    @PostMapping("/editar/{id}")
    public String actualizarProducto(@PathVariable Long id, @ModelAttribute("producto") producto producto) {
        productoService.updaProducto(id, producto);
        return "redirect:/producto/";
    }
    @GetMapping("/{id}")
    public String eliminarProducto(@PathVariable Long id) {
        productoService.deleteProducto(id);
        return "redirect:/producto/";
    }
}
