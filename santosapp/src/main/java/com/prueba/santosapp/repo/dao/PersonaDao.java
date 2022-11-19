package com.prueba.santosapp.repo.dao;

import com.prueba.santosapp.model.dto.Persona;

import java.util.List;
import java.util.Optional;

public interface PersonaDao {
    List<Persona> obtenerTodo();

    void guardar(Persona persona);

    Optional<Persona> buscar(Integer Id);

    Persona save(Persona persona);

    void eliminar(Integer id);

    Persona update(Persona persona);

}
