package com.santosprueba.prueba.servicio;

import com.santosprueba.prueba.modelo.mapper.Persona;
import com.santosprueba.prueba.repo.crud.PersonaCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Base64;
import java.util.List;

@Service
public class PersonaServicio {
    private PersonaCrud personaCrud;
    @Autowired
    public PersonaServicio(PersonaCrud personaCrud) {
        this.personaCrud = personaCrud;
    }

    public void guardar(Persona persona){
        this.personaCrud.save(persona);
    }

    public List<Persona> mostrarTodo(){
        return (List<Persona>) this.personaCrud.findAll();
    }

    //  METODO PARA CONSUMIR LA API DE PERSONA A TRAVES DE LA APP CLIENTE
    //  LA APP CLIENTE CORRE EN EL PUERTO 8060
    public List<Persona> listaPersona() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8060/servicio/listpersona";
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        ResponseEntity<List<Persona>> response = restTemplate.exchange(url,
                HttpMethod.GET, entity, new ParameterizedTypeReference<List<Persona>>() {
                });
        return response.getBody();
    }

    //METODO PARA CONSUMIR LA API DE SERVICIO PERSONA DIRECTAMENTE
    //EL SERVICIO CORRE EN EL PUERTO 8080
    public List<Persona> obtenerPersonas() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/santos/persona/todo";
        HttpHeaders headers = new HttpHeaders();
        String strAuth = "test:test";

        String base64Creds = Base64.getEncoder().encodeToString(strAuth.getBytes());

        headers.add("Authorization", "Basic " + base64Creds);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        ResponseEntity<List<Persona>> response = restTemplate.exchange(url,
                HttpMethod.GET, entity, new ParameterizedTypeReference<List<Persona>>() {
                });
        return response.getBody();
    }
}
