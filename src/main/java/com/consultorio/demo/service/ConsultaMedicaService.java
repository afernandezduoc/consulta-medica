package com.consultorio.demo.service;

import com.consultorio.demo.model.ConsultaMedica;
import com.consultorio.demo.repository.ConsultaMedicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ConsultaMedicaService {
    @Autowired
    private ConsultaMedicaRepository consultaMedicaRepository;

    // Obtener todas las consultas médicas
    public List<ConsultaMedica> findAllConsultas() {
        return consultaMedicaRepository.findAll();
    }

    // Obtener una consulta médica por su ID
    public Optional<ConsultaMedica> findConsultaById(Long id) {
        return consultaMedicaRepository.findById(id);
    }

    // Crear una nueva consulta médica
    public ConsultaMedica createConsulta(ConsultaMedica consultaMedica) {
        return consultaMedicaRepository.save(consultaMedica);
    }

    // Actualizar una consulta médica existente
    public ConsultaMedica updateConsulta(Long id, ConsultaMedica updatedConsulta) {
        return consultaMedicaRepository.findById(id)
            .map(consulta -> {
                consulta.setFecha(updatedConsulta.getFecha());
                consulta.setMotivo(updatedConsulta.getMotivo());
                consulta.setDiagnostico(updatedConsulta.getDiagnostico());
                consulta.setTratamiento(updatedConsulta.getTratamiento());
                consulta.setMedico(updatedConsulta.getMedico());
                consulta.setEspecialidad(updatedConsulta.getEspecialidad());
                return consultaMedicaRepository.save(consulta);
            })
            .orElseGet(() -> {
                updatedConsulta.setId(id);
                return consultaMedicaRepository.save(updatedConsulta);
            });
    }

    // Eliminar una consulta médica
    public void deleteConsulta(Long id) {
        consultaMedicaRepository.deleteById(id);
    }
}
