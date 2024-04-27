package com.consultorio.demo.controller;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import com.consultorio.demo.dto.PacienteDTO;
import com.consultorio.demo.model.Paciente;
import com.consultorio.demo.service.PacienteService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.when;


@WebMvcTest(PacienteController.class)
public class PacienteControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PacienteService pacienteService;

    @Test
    public void getPacienteByIdTest() throws Exception {
        Paciente paciente = new Paciente();
        paciente.setId(1L);
        PacienteDTO pacienteDTO = new PacienteDTO();
        pacienteDTO.setId(1L);

        when(pacienteService.findPacienteById(1L)).thenReturn(Optional.of(paciente));

        mockMvc.perform(get("/api/pacientes/1"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(1));
    }

    @Test
    public void createPacienteTest() throws Exception {
        PacienteDTO pacienteDTO = new PacienteDTO();
        pacienteDTO.setNombre("Carlos");

        Paciente paciente = new Paciente();
        paciente.setNombre("Carlos");

        given(pacienteService.createPaciente(any(Paciente.class))).willReturn(paciente);

        mockMvc.perform(post("/api/pacientes")
                .contentType("application/json")
                .content("{\"nombre\":\"Carlos\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.nombre").value("Carlos"));
    }    
}
