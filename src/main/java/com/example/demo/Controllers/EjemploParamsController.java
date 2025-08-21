package com.example.demo.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class EjemploParamsController {
    
    @GetMapping("/")
       public String index(Model model){
        


        return "parametros/index";
    }
    @GetMapping("/string")
       public String param( @RequestParam String texto, Model model){
        
        model.addAttribute("titulo", "Recibir parametros del request http get");
        model.addAttribute("resultado", "El texto enviado es : " + texto);

        return "parametros/ver";
    }
        @GetMapping("/mix-params")
       public String variables(@RequestParam(name="saludo",required=false,defaultValue="owo")String texto,@RequestParam Integer numero,Model model){

        model.addAttribute("titulo", "Recibir parametros de la mix");
        model.addAttribute("resultado", "El saludo enviado es : " + texto + " y el numero es: "+ numero);


        return "parametros/ver";
    }


}
