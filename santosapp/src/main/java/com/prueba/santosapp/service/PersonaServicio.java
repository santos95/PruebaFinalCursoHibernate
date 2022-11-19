package com.prueba.santosapp.service;

import com.prueba.santosapp.model.dto.Persona;
import com.prueba.santosapp.repo.dao.PersonaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaServicio {
    private PersonaDao personaDao;

    @Autowired
    public PersonaServicio(PersonaDao personaDao) {
        this.personaDao = personaDao;
    }

    public List<Persona> obtenerTodo(){
        return this.personaDao.obtenerTodo();
    }

    public Optional<Persona> buscar(Integer Id) {
        return this.personaDao.buscar(Id);
    }

    public void guardar(Persona persona) {
        this.personaDao.guardar(persona);
    }

    public void eliminar(Integer id){
        this.personaDao.eliminar(id);
    }

    public Persona update(Persona persona){
        return this.personaDao.update(persona);
    }


}
