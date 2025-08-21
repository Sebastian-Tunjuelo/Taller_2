package com.example.demo.Controllers;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app")
public class IndexController {

    @GetMapping({"/","/index","/home"})
    public String index(Model model){
        model.addAttribute("Titulo", "Hola mundo :D");

        return "index";
    }

    @GetMapping("/listado")
    public String listado(Model model){
    List<Nombre> nombres = Arrays.asList(
        new Nombre ("Manolito Pajaro"),
        new Nombre ("Pepito Perez")
    );
    model.addAttribute("nombres", nombres);   
    model.addAttribute("titulo", "Lista de clientes");
       
        
        return "Listado";
    }

}
