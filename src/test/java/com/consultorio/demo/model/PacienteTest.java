package com.consultorio.demo.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.ArrayList;

public class PacienteTest {
    private Paciente paciente;

    @BeforeEach
    void setUp() {
        paciente = new Paciente();
        paciente.setId(1L);
        paciente.setRut("12345678-9");
        paciente.setNombre("Juan");
        paciente.setApellido("Pérez");
        paciente.setFechaNacimiento(new Date());
        paciente.setDireccion("Calle Falsa 123");
        paciente.setRegion("Región Metropolitana");
        paciente.setTelefono("123456789");
        paciente.setEmail("juan.perez@example.com");
        paciente.setPrevision("FONASA");
        paciente.setSexo("Masculino");
        paciente.setConsultas(new ArrayList<>()); 
    }

    @Test
    void testGetters() {
        assertEquals(1L, paciente.getId());
        assertEquals("12345678-9", paciente.getRut());
        assertEquals("Juan", paciente.getNombre());
        assertEquals("Pérez", paciente.getApellido());
        assertEquals("Calle Falsa 123", paciente.getDireccion());
        assertEquals("Región Metropolitana", paciente.getRegion());
        assertEquals("123456789", paciente.getTelefono());
        assertEquals("juan.perez@example.com", paciente.getEmail());
        assertEquals("FONASA", paciente.getPrevision());
        assertEquals("Masculino", paciente.getSexo());
        assertEquals(0, paciente.getConsultas().size());
    }
}
