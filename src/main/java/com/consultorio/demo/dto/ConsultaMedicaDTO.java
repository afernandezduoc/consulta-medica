package com.consultorio.demo.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalTime;

public class ConsultaMedicaDTO {
    private Long id;

    @NotNull(message = "El ID del paciente es obligatorio.")
    private Long pacienteId;

    @NotNull(message = "La fecha de la consulta es obligatoria.")
    private LocalDate fecha;

    @NotNull(message = "La hora de la consulta es obligatoria.")
    private LocalTime hora;

    @NotNull(message = "El motivo de la consulta es obligatorio.")
    @Size(min = 1, max = 255, message = "El motivo no puede estar vacío y debe ser menor de 256 caracteres.")
    private String motivo;

    private String diagnostico;
    private String tratamiento;

    @NotNull(message = "El nombre del médico es obligatorio.")
    @Size(min = 1, max = 100, message = "El nombre del médico debe ser menor de 101 caracteres.")
    private String medico;

    @NotNull(message = "La especialidad del médico es obligatoria.")
    @Size(min = 1, max = 50, message = "La especialidad debe ser menor de 51 caracteres.")
    private String especialidad;

    // Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(Long pacienteId) {
        this.pacienteId = pacienteId;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}
