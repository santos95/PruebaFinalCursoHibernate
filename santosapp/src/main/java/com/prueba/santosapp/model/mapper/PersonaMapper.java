package com.prueba.santosapp.model.mapper;

import com.prueba.santosapp.model.dto.Persona;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonaMapper implements RowMapper<Persona> {

    @Override
    public Persona mapRow(ResultSet rs, int rowNum) throws SQLException {
        Persona persona = new Persona();

        persona.setId(rs.getInt("Id"));
        persona.setNombre(rs.getString("Nombre"));
        persona.setApellido(rs.getString("Apellido"));
        persona.setEdad(rs.getInt("Edad"));

        return persona;
    }
}
