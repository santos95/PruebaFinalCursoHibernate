package com.prueba.santosapp.controller;

import com.prueba.santosapp.model.dto.Persona;
import com.prueba.santosapp.service.PersonaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persona")
public class PersonaController {
    private PersonaServicio personaServicio;

    @Autowired
    public PersonaController(PersonaServicio personaServicio) {
        this.personaServicio = personaServicio;
    }

    @GetMapping("/todo")
    //@ApiOperation("Obtener todos las personas")
    public ResponseEntity<List<Persona>> obtenerTodo(){
        return new ResponseEntity<>(this.personaServicio.obtenerTodo(), HttpStatus.OK);
    }

    @GetMapping("/{Id}")
    public ResponseEntity<Persona> buscar(@PathVariable Integer Id){
        return personaServicio.buscar(Id)
                .map(persona -> new ResponseEntity<>(persona, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/guardar")
    public void guardar(@RequestBody Persona persona){
        this.personaServicio.guardar(persona);
    }

    @DeleteMapping("/eliminar/{Id}")
    public void eliminar(@PathVariable Integer Id){
        this.personaServicio.eliminar(Id);
    }

    @PutMapping("/update")
    public Persona update(@RequestBody Persona persona){
        return this.personaServicio.update(persona);
    }
}
