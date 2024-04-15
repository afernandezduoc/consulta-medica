package com.consultorio.demo.service;

import com.consultorio.demo.model.Paciente;
import com.consultorio.demo.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {
    @Autowired
    private PacienteRepository pacienteRepository;

    // Método para obtener todos los pacientes
    public List<Paciente> findAllPacientes() {
        return pacienteRepository.findAll();
    }

    // Método para buscar un paciente por ID
    public Optional<Paciente> findPacienteById(Long id) {
        return pacienteRepository.findById(id);
    }

    // Método para crear un nuevo paciente
    public Paciente createPaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    // Método para actualizar un paciente existente
    public Paciente updatePaciente(Long id, Paciente updatedPaciente) {
        return pacienteRepository.findById(id)
                .map(paciente -> {
                    paciente.setNombre(updatedPaciente.getNombre());
                    paciente.setApellido(updatedPaciente.getApellido());
                    paciente.setFechaNacimiento(updatedPaciente.getFechaNacimiento());
                    paciente.setDireccion(updatedPaciente.getDireccion());
                    paciente.setRegion(updatedPaciente.getRegion());
                    paciente.setTelefono(updatedPaciente.getTelefono());
                    paciente.setEmail(updatedPaciente.getEmail());
                    paciente.setPrevision(updatedPaciente.getPrevision());
                    paciente.setSexo(updatedPaciente.getSexo());
                    return pacienteRepository.save(paciente);
                })
                .orElseGet(() -> {
                    updatedPaciente.setId(id);
                    return pacienteRepository.save(updatedPaciente);
                });
    }

    // Método para eliminar un paciente
    public void deletePaciente(Long id) {
        pacienteRepository.deleteById(id);
    }
}
