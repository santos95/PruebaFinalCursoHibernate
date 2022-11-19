package com.santosprueba.prueba.controller;

import java.util.List;
import com.santosprueba.prueba.modelo.mapper.Persona;
import com.santosprueba.prueba.servicio.PersonaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/persona")
public class PersonaController {

    private PersonaServicio personaServicio;

    @Autowired
    public PersonaController(PersonaServicio personaServicio) {
        this.personaServicio = personaServicio;
    }

    @PostMapping("/guardar")
    public void guardar(@RequestBody Persona persona){
        this.personaServicio.guardar(persona);
    }


    @GetMapping("/todo")
    public List<Persona> todo(){
       return this.personaServicio.mostrarTodo();
    }


}
