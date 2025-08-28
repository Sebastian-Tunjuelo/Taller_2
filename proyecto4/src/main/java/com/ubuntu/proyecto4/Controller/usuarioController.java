package com.ubuntu.proyecto4.Controller;

//RECORDATORIO ARRAYLIST

/* 
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ubuntu.proyecto4.Models.Entity.usuario;

@Controller
@RequestMapping("/usuario")
public class usuarioController {
    

   

    @GetMapping("/lista")
    public String lista(Model model){
    List<usuario> usuario = Arrays.asList(
       
        new usuario("Kris", "R", "lapampara@gmail.com"),
        new usuario("Blessd", "El Bendito", "yaper@gmail.com"),
        new usuario("Ryan", "Castro", "awo@gmail.com")
    );
    model.addAttribute("usuario", usuario);   
    model.addAttribute("titulo", "Lista de clientes");

    System.out.println(usuario);
       
        
        return "index";
    }

    //Metodo alternativo usando ArrayList


       @GetMapping("/lista2")
    public String lista2(Model model){
   
ArrayList<usuario> usuario = new ArrayList<usuario>();
usuario.add(new usuario("Kris", "R", ""));
usuario.add(new usuario("Blessd", "El Bendito", "yaper@gmail.com"));
usuario.add(new usuario("Ryan", "Castro", "awo@gmail.com"));


    model.addAttribute("usuario", usuario);   
    model.addAttribute("titulo", "Lista de clientes");

    return "index";
    }
    
}
    */
