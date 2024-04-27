package com.consultorio.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.consultorio.demo.model.Paciente;
import com.consultorio.demo.repository.PacienteRepository;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class PacienteServiceTest {
    @Mock
    private PacienteRepository pacienteRepository;

    @InjectMocks
    private PacienteService pacienteService;

    @Test
    void testFindPacienteById_ExistingId() {
        Paciente expectedPaciente = new Paciente();
        expectedPaciente.setId(1L);
        when(pacienteRepository.findById(1L)).thenReturn(Optional.of(expectedPaciente));

        Optional<Paciente> result = pacienteService.findPacienteById(1L);

        verify(pacienteRepository).findById(1L);
        assertEquals(true, result.isPresent());
        assertEquals(expectedPaciente, result.get());
    }

    @Test
    void testFindPacienteById_NonExistingId() {
        when(pacienteRepository.findById(1L)).thenReturn(Optional.empty());

        Optional<Paciente> result = pacienteService.findPacienteById(1L);

        verify(pacienteRepository).findById(1L);
        assertEquals(false, result.isPresent());
    }

    @Test
    void testCreatePaciente() {
        Paciente newPaciente = new Paciente();
        newPaciente.setNombre("Carlos");
        newPaciente.setApellido("Vega");
        when(pacienteRepository.save(any(Paciente.class))).thenReturn(newPaciente);

        Paciente result = pacienteService.createPaciente(newPaciente);

        verify(pacienteRepository).save(newPaciente);
        assertEquals("Carlos", result.getNombre());
        assertEquals("Vega", result.getApellido());
    }
}
