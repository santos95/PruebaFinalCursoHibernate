package com.santosprueba.prueba.view;

import com.santosprueba.prueba.modelo.mapper.Persona;
import com.santosprueba.prueba.servicio.PersonaServicio;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.List;

@Scope(value = "session")
@Component
@Data
public class PersonaBackBean implements Serializable {

    private String test = "Pantalla Prueba Curso Hibernate";

    private Persona persona;

    private List<Persona> listPersonas;

    private PersonaServicio personaServicio;

    @Autowired
    public PersonaBackBean(PersonaServicio personaServicio) {
        this.personaServicio = personaServicio;
    }

    @PostConstruct
    public void init(){
        persona = new Persona();

        //consume directamente a la api persona
        //listPersonas = personaServicio.obtenerPersonas();

        //consume a traves de la aplicacion cliente el api persona
        listPersonas = personaServicio.listaPersona();
    }

    public void agregar() {
        personaServicio.guardar(persona);
        persona = new Persona();
        this.init();
    }

}
