package com.uwu.cliente.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uwu.cliente.Entity.producto;
import com.uwu.cliente.service.productoService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/producto")
public class productoController {
    // inyectamos el servicio
    @Autowired
    productoService productoService;

    @GetMapping({ "", "/" })
    public String listaProductos(Model model) {
        model.addAttribute("titulo", "Lista de Productos");
        model.addAttribute("productos", productoService.findAllProductos());
        return "/Producto/producto";
    }

    @GetMapping("/nuevo_producto")
    public String mostrarFormularioRegistroProducto(Model model) {
        producto producto = new producto();
        model.addAttribute("titulo", "Crear Nuevo Producto");
        model.addAttribute("producto", producto);
        return "/Producto/crearProducto";
    }

    @PostMapping("")
    public String guardarProducto(@Valid @ModelAttribute("producto") producto producto, BindingResult result) {
        if (result.hasErrors()) {
            return "/Producto/crearProducto";
        }
        productoService.saveProducto(producto);
        return "redirect:/producto/";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarProducto(@PathVariable Long id, Model model) {
        model.addAttribute("producto", productoService.getProductoById(id));
        return "/Producto/editarProducto";
    }

    @PostMapping("/editar/{id}")
    public String actualizarProducto(@PathVariable Long id, @Valid @ModelAttribute("producto") producto producto,
            BindingResult result) {
        if (result.hasErrors()) {
            return "/Producto/editarProducto";
        }
        productoService.updaProducto(id, producto);
        return "redirect:/producto/";
    }

    @GetMapping("/{id}")
    public String eliminarProducto(@PathVariable Long id) {
        productoService.deleteProducto(id);
        return "redirect:/producto/";
    }

    @GetMapping("/esconder/{id}")
    public String esconderProducto(@PathVariable Long id) {
        
        productoService.hideProducto(id);
        return "redirect:/producto/";
    }
    
}
