package com.consultorio.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consultorio.demo.model.ConsultaMedica;
import com.consultorio.demo.service.MedicalService;

@RestController
@RequestMapping("/consultas")
public class ConsultaMedicaController {
    // Aquí inyectamos el servicio que maneja la lógica de negocio
    @Autowired
    private MedicalService medicalService;
    
    // En este método se obtiene una lista de todas las consultas médicas
    // y se retorna un ResponseEntity con la lista de consultas médicas
    @GetMapping
    public ResponseEntity<List<ConsultaMedica>> getConsultasMedicas() {
        List<ConsultaMedica> consultasMedicas = medicalService.getConsultasMedicas();
        return ResponseEntity.ok(consultasMedicas);
    }

    // En este método se obtiene una consulta médica por su ID
    // y se retorna un ResponseEntity con la consulta médica y un código de estado HTTP correspondiente (200 si se encontró la consulta médica, 404 si no se encontró)
    @GetMapping("/{id}")
    public ResponseEntity<ConsultaMedica> getConsultaMedicaById(@PathVariable String id) {
        return medicalService.getConsultaMedicaById(id) != null ? ResponseEntity.ok(medicalService.getConsultaMedicaById(id)) : ResponseEntity.notFound().build();
    }
}
