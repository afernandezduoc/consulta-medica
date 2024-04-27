package com.consultorio.demo.controller;

import com.consultorio.demo.dto.ConsultaMedicaDTO;
import com.consultorio.demo.model.ConsultaMedica;
import com.consultorio.demo.service.ConsultaMedicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/consultas")
public class ConsultaMedicaController {
    @Autowired
    private ConsultaMedicaService consultaMedicaService;

    // Obtener todas las consultas médicas
    @GetMapping
    public ResponseEntity<List<ConsultaMedicaDTO>> getAllConsultas() {
        List<ConsultaMedicaDTO> consultas = consultaMedicaService.findAllConsultas()
            .stream()
            .map(this::convertToDTO)
            .collect(Collectors.toList());
        return ResponseEntity.ok(consultas);
    }

    // Obtener una consulta médica por ID
    @GetMapping("/{id}")
    public ResponseEntity<ConsultaMedicaDTO> getConsultaById(@PathVariable Long id) {
        return consultaMedicaService.findConsultaById(id)
            .map(consulta -> ResponseEntity.ok(convertToDTO(consulta)))
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear una nueva consulta médica
    @PostMapping
    public ResponseEntity<ConsultaMedicaDTO> createConsulta(@Validated @RequestBody ConsultaMedicaDTO consultaDTO) {
        ConsultaMedica consulta = consultaMedicaService.createConsulta(convertToEntity(consultaDTO));
        return new ResponseEntity<>(convertToDTO(consulta), HttpStatus.CREATED);
    }

    // Actualizar una consulta médica existente
    @PutMapping("/{id}")
    public ResponseEntity<ConsultaMedicaDTO> updateConsulta(@PathVariable Long id, @Validated @RequestBody ConsultaMedicaDTO consultaDTO) {
        ConsultaMedica updatedConsulta = consultaMedicaService.updateConsulta(id, convertToEntity(consultaDTO));
        return ResponseEntity.ok(convertToDTO(updatedConsulta));
    }

    // Eliminar una consulta médica
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConsulta(@PathVariable Long id) {
        consultaMedicaService.deleteConsulta(id);
        return ResponseEntity.noContent().build();
    }

    // Método auxiliar para convertir entidad a DTO
    private ConsultaMedicaDTO convertToDTO(ConsultaMedica consulta) {
        ConsultaMedicaDTO consultaDTO = new ConsultaMedicaDTO();
        consultaDTO.setId(consulta.getId());
        consultaDTO.setPacienteId(consulta.getPaciente().getId());
        consultaDTO.setFecha(consulta.getFecha());
        consultaDTO.setMotivo(consulta.getMotivo());
        consultaDTO.setDiagnostico(consulta.getDiagnostico());
        consultaDTO.setTratamiento(consulta.getTratamiento());
        consultaDTO.setMedico(consulta.getMedico());
        consultaDTO.setEspecialidad(consulta.getEspecialidad());
        return consultaDTO;
    }

    // Método auxiliar para convertir DTO a entidad
    private ConsultaMedica convertToEntity(ConsultaMedicaDTO consultaDTO) {
        ConsultaMedica consulta = new ConsultaMedica();
        consulta.setId(consultaDTO.getId());
        consulta.setFecha(consultaDTO.getFecha());
        consulta.setMotivo(consultaDTO.getMotivo());
        consulta.setDiagnostico(consultaDTO.getDiagnostico());
        consulta.setTratamiento(consultaDTO.getTratamiento());
        consulta.setMedico(consultaDTO.getMedico());
        consulta.setEspecialidad(consultaDTO.getEspecialidad());
        return consulta;
    }
}
