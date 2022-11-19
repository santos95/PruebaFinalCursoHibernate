package com.santosprueba.prueba.repo.crud;

import com.santosprueba.prueba.modelo.mapper.Persona;
import org.springframework.data.repository.CrudRepository;

public interface PersonaCrud extends CrudRepository<Persona, Integer> {
}
