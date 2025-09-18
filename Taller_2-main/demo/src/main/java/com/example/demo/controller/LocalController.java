package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


import com.example.demo.entity.Local;
import com.example.demo.service.LocalService;

@Controller
public class LocalController {
    //inyectamos el servicio
    @Autowired
    LocalService localService;

    @GetMapping("/")
    public String listaLocales(Model model){
        model.addAttribute("titulo", "lista de locales");
        model.addAttribute("locales", localService.findAllLocals());
        return "index";
    }

    @PostMapping("/saveLocal")
    //body es el objeto en formato json que envia en cliente en la peticion 
    public Local saveLocal(@RequestBody Local local){
        return localService.saveLocal(local);
    }  
    //put es para actualizar
    @PutMapping("/updateLocal/{id}")
    public Local updLocal(@PathVariable Long id,@RequestBody Local local){
        return localService.updateLocal(id, local);
    }

    @DeleteMapping("/deleteLocal/{id}")
    public String deleteLocal(@PathVariable Long id){
        localService.deleteLocal(id);
        return "registro tin papi tin tin muñecon";
    }
}
