package com.consultorio.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.consultorio.demo.model.ConsultaMedica;
import com.consultorio.demo.model.Paciente;

import jakarta.annotation.PostConstruct;

@Service
public class InMemoryService {
    // Listas para almacenar pacientes y consultas médicas
    private final List<Paciente> pacientes = new ArrayList<>();
    private final List<ConsultaMedica> consultasMedicas = new ArrayList<>();

    // Método para inicializar datos de prueba
    @PostConstruct
    private void initData() {
        // Consultas Médicas
        ConsultaMedica consulta1 = new ConsultaMedica("1", "1", "2024-01-01", "10:00", "Chequeo anual", "Saludable", "Ninguno", "Dr. Marta Sánchez", "Medicina General");
        ConsultaMedica consulta2 = new ConsultaMedica("2", "2", "2024-02-02", "11:00", "Consulta dermatológica", "Dermatitis", "Cremas dermatológicas", "Dr. José Rivera", "Dermatología");
        ConsultaMedica consulta3 = new ConsultaMedica("3", "3", "2024-03-03", "12:00", "Consulta oftalmológica", "Miopía", "Receta para Lentes nuevos", "Dra. Clara Gómez", "Oftalmología");
        ConsultaMedica consulta4 = new ConsultaMedica("4", "4", "2024-04-04", "09:00", "Consulta por alergia", "Alergia al polen", "Antihistamínicos", "Dr. Luis Méndez", "Inmunología");
        ConsultaMedica consulta5 = new ConsultaMedica("5", "5", "2024-05-05", "14:00", "Control de hipertensión", "Hipertensión controlada", "Seguir medicación", "Dra. Ana Pérez", "Cardiología");

        // Pacientes
        Paciente paciente1 = new Paciente("1", "12.345.678-9", "Juan", "Pérez", "1980-01-01", "Calle Falsa 123", "Región Metropolitana", "+56900000000", "juan.perez@example.com", "FONASA", "Masculino", List.of(consulta1));
        Paciente paciente2 = new Paciente("2", "23.456.789-0", "María", "López", "1985-02-02", "Avenida Siempre Viva 456", "Región de Valparaíso", "+56911111111", "maria.lopez@example.com", "ISAPRE", "Femenino", List.of(consulta2));
        Paciente paciente3 = new Paciente("3", "34.567.890-1", "Carlos", "Gómez", "1990-03-03", "Pasaje Inventado 789", "Región del Biobío", "+56922222222", "carlos.gomez@example.com", "FONASA", "Masculino", List.of(consulta3));
        Paciente paciente4 = new Paciente("4", "45.678.901-2", "Ana", "Rivera", "1982-04-04", "Callejón de los Milagros 101", "Región de la Araucanía", "+56933333333", "ana.rivera@example.com", "ISAPRE", "Femenino", List.of(consulta4));
        Paciente paciente5 = new Paciente("5", "56.789.012-3", "Diego", "Martínez", "1975-05-05", "Ruta del Desierto 202", "Región de Antofagasta", "+56944444444", "diego.martinez@example.com", "FONASA", "Masculino", List.of(consulta5));

        // Añadir pacientes a la lista
        pacientes.addAll(List.of(paciente1, paciente2, paciente3, paciente4, paciente5));

        // Añadir consultas médicas a la lista
        consultasMedicas.addAll(List.of(consulta1, consulta2, consulta3, consulta4, consulta5));
    }

    // Métodos para obtener pacientes y consultas médicas
    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public List<ConsultaMedica> getConsultasMedicas() {
        return consultasMedicas;
    }
}
