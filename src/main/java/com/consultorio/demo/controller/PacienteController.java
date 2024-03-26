package com.consultorio.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consultorio.demo.service.MedicalService;
import com.consultorio.demo.model.Paciente;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    // Aquí inyectamos el servicio que maneja la lógica de negocio
    @Autowired
    private MedicalService medicalService; 

    // En este método se obtiene una lista de todos los pacientes
    // y se retorna un ResponseEntity con la lista de pacientes y un código de estado HTTP correspondiente (200 si hay contenido, 204 si no hay contenido)
    @GetMapping
    public ResponseEntity<List<Paciente>> getPacientes() {
        List<Paciente> pacientes = medicalService.getPacientes();
        return new ResponseEntity<>(pacientes, pacientes.isEmpty() ? HttpStatus.NO_CONTENT : HttpStatus.OK);
    }

    // En este método se obtiene un paciente por su ID
    // y se retorna un ResponseEntity con el paciente y un código de estado HTTP correspondiente (200 si se encontró el paciente, 404 si no se encontró)
    @GetMapping("/{id}")
    public ResponseEntity<Paciente> getPacienteById(@PathVariable String id) {
        return medicalService.getPacienteById(id) != null ? new ResponseEntity<>(medicalService.getPacienteById(id), HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
