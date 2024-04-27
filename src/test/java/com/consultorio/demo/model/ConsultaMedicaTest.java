package com.consultorio.demo.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;

public class ConsultaMedicaTest {
    private ConsultaMedica consulta;

    @BeforeEach
    void setUp() {
        consulta = new ConsultaMedica();
        consulta.setId(1L);
        consulta.setFecha(new Date());
        consulta.setMotivo("Consulta de rutina");
        consulta.setDiagnostico("Saludable");
        consulta.setTratamiento("Ninguno");
        consulta.setMedico("Dr. Smith");
        consulta.setEspecialidad("Medicina General");

        Paciente paciente = new Paciente();
        paciente.setId(1L);
        consulta.setPaciente(paciente);
    }

    @Test
    void testGetters() {
        assertEquals(1L, consulta.getId());
        assertEquals("Consulta de rutina", consulta.getMotivo());
        assertEquals("Saludable", consulta.getDiagnostico());
        assertEquals("Ninguno", consulta.getTratamiento());
        assertEquals("Dr. Smith", consulta.getMedico());
        assertEquals("Medicina General", consulta.getEspecialidad());
        assertEquals(1L, consulta.getPaciente().getId());
    }
}
