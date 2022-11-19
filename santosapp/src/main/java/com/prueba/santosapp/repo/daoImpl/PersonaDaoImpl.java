package com.prueba.santosapp.repo.daoImpl;

import com.prueba.santosapp.model.dto.Persona;
import com.prueba.santosapp.model.mapper.PersonaMapper;
import com.prueba.santosapp.repo.dao.PersonaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@Repository
public class PersonaDaoImpl implements PersonaDao {

    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert simpleJdbcInsert;

    @Autowired
    public PersonaDaoImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.simpleJdbcInsert = new SimpleJdbcInsert(dataSource);
    }


    @Override
    public List<Persona> obtenerTodo() {
        return this.jdbcTemplate.query("SELECT * FROM Persona_Santos", new PersonaMapper());
    }

    @Override
    public void guardar(Persona persona) {
        this.jdbcTemplate.update("INSERT INTO Persona_Santos (Nombre, Apellido, Edad)" +
                " VALUES(?, ?, ?)", persona.getNombre(), persona.getApellido(), persona.getEdad());
    }

    @Override
    public Optional<Persona> buscar(Integer Id) {
        //return Optional.empty();
        return this.jdbcTemplate.query("SELECT * FROM Persona_Santos WHERE Id = ?", new PersonaMapper(), Id).stream().filter(persona -> persona.getId().equals(Id)).findFirst();
    }

    @Override
    public Persona save(Persona persona) {
        return null;
    }

    @Override
    public void eliminar(Integer id) {
        this.jdbcTemplate.update("DELETE FROM Persona_Santos WHERE Id = ?", id);
    }

    @Override
    public Persona update(Persona persona) {
        this.jdbcTemplate.update("UPDATE Persona_Santos SET " +
                "Nombre = ?, Apellido = ?, Edad = ?" +
                " WHERE Id = ?", persona.getNombre(), persona.getApellido(), persona.getEdad(),persona.getId());
        return persona;
    }
}
