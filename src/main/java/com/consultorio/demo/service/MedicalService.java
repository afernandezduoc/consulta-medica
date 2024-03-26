package com.consultorio.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.consultorio.demo.model.ConsultaMedica;
import com.consultorio.demo.model.Paciente;

@Service
public class MedicalService {
    @Autowired
    private InMemoryService inMemoryService;

    public List<Paciente> getPacientes() {
        return inMemoryService.getPacientes();
    }

    public Paciente getPacienteById(String id) {
        return inMemoryService.getPacientes().stream().filter(paciente -> paciente.getId().equals(id)).findFirst().orElse(null);
    }

    public List<ConsultaMedica> getConsultasMedicas() {
        return inMemoryService.getConsultasMedicas();
    }

    public ConsultaMedica getConsultaMedicaById(String id) {
        return inMemoryService.getConsultasMedicas().stream().filter(consultaMedica -> consultaMedica.getId().equals(id)).findFirst().orElse(null);
    }

    public List<ConsultaMedica> getConsultasMedicasByPacienteId(String pacienteId) {
        return inMemoryService.getConsultasMedicas().stream().filter(consultaMedica -> consultaMedica.getPacienteId().equals(pacienteId)).toList();
    }
}
