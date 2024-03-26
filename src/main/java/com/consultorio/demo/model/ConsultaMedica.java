package com.consultorio.demo.model;

public class ConsultaMedica {
    private String id;
    private String pacienteId;
    private String fecha;
    private String hora;
    private String motivo;
    private String diagnostico;
    private String tratamiento;
    private String medico;
    private String especialidad;

    public ConsultaMedica(String id, String pacienteId, String fecha, String hora, String motivo, String diagnostico, String tratamiento, String medico, String especialidad) {
        this.id = id;
        this.pacienteId = pacienteId;
        this.fecha = fecha;
        this.hora = hora;
        this.motivo = motivo;
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
        this.medico = medico;
        this.especialidad = especialidad;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getPacienteId() {
        return pacienteId;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public String getMotivo() {
        return motivo;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public String getMedico() {
        return medico;
    }

    public String getEspecialidad() {
        return especialidad;
    }
}
