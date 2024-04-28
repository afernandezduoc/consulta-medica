package com.consultorio.demo.controller;

import com.consultorio.demo.dto.PacienteDTO;
import com.consultorio.demo.model.Paciente;
import com.consultorio.demo.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.hateoas.EntityModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    // Obtener todos los pacientes
    @GetMapping
    public ResponseEntity<List<PacienteDTO>> getAllPacientes() {
        List<PacienteDTO> pacientes = pacienteService.findAllPacientes()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(pacientes);
    }

    // Obtener un paciente por ID
    /*
     * @GetMapping("/{id}")
     * public ResponseEntity<PacienteDTO> getPacienteById(@PathVariable Long id) {
     * return pacienteService.findPacienteById(id)
     * .map(paciente -> ResponseEntity.ok(convertToDTO(paciente)))
     * .orElseGet(() -> ResponseEntity.notFound().build());
     * }
     */
    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<PacienteDTO>> getPacienteById(@PathVariable Long id) {
        return pacienteService.findPacienteById(id)
                .map(paciente -> {
                    PacienteDTO dto = convertToDTO(paciente);
                    EntityModel<PacienteDTO> resource = EntityModel.of(dto,
                            linkTo(methodOn(PacienteController.class).getPacienteById(id)).withSelfRel(),
                            linkTo(methodOn(PacienteController.class).getAllPacientes()).withRel("all-patients"));
                    return ResponseEntity.ok(resource);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear un nuevo paciente
    @PostMapping
    public ResponseEntity<PacienteDTO> createPaciente(@Validated @RequestBody PacienteDTO pacienteDTO) {
        Paciente paciente = pacienteService.createPaciente(convertToEntity(pacienteDTO));
        return new ResponseEntity<>(convertToDTO(paciente), HttpStatus.CREATED);
    }

    // Actualizar un paciente existente
    @PutMapping("/{id}")
    public ResponseEntity<PacienteDTO> updatePaciente(@PathVariable Long id,
            @Validated @RequestBody PacienteDTO pacienteDTO) {
        Paciente updatedPaciente = pacienteService.updatePaciente(id, convertToEntity(pacienteDTO));
        return ResponseEntity.ok(convertToDTO(updatedPaciente));
    }

    // Eliminar un paciente
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePaciente(@PathVariable Long id) {
        pacienteService.deletePaciente(id);
        return ResponseEntity.noContent().build();
    }

    // Método auxiliar para convertir entidad a DTO
    private PacienteDTO convertToDTO(Paciente paciente) {
        PacienteDTO pacienteDTO = new PacienteDTO();
        pacienteDTO.setId(paciente.getId());
        pacienteDTO.setRut(paciente.getRut());
        pacienteDTO.setNombre(paciente.getNombre());
        pacienteDTO.setApellido(paciente.getApellido());
        pacienteDTO.setFechaNacimiento(paciente.getFechaNacimiento());
        pacienteDTO.setDireccion(paciente.getDireccion());
        pacienteDTO.setRegion(paciente.getRegion());
        pacienteDTO.setTelefono(paciente.getTelefono());
        pacienteDTO.setEmail(paciente.getEmail());
        pacienteDTO.setPrevision(paciente.getPrevision());
        pacienteDTO.setSexo(paciente.getSexo());
        return pacienteDTO;
    }

    // Método auxiliar para convertir DTO a entidad
    private Paciente convertToEntity(PacienteDTO pacienteDTO) {
        Paciente paciente = new Paciente();
        paciente.setId(pacienteDTO.getId());
        paciente.setRut(pacienteDTO.getRut());
        paciente.setNombre(pacienteDTO.getNombre());
        paciente.setApellido(pacienteDTO.getApellido());
        paciente.setFechaNacimiento(pacienteDTO.getFechaNacimiento());
        paciente.setDireccion(pacienteDTO.getDireccion());
        paciente.setRegion(pacienteDTO.getRegion());
        paciente.setTelefono(pacienteDTO.getTelefono());
        paciente.setEmail(pacienteDTO.getEmail());
        paciente.setPrevision(pacienteDTO.getPrevision());
        paciente.setSexo(pacienteDTO.getSexo());
        return paciente;
    }
}
