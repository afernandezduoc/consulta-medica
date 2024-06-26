package com.consultorio.demo.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.OneToMany;

@Entity
@Table(name = "pacientes")
public class Paciente {
    // Atributos de la clase Paciente
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@Nonnull @Size(min = 9, max = 12)
    private String rut;

    //@NotNull @Size(min = 1, max = 100)
    private String nombre;

    //@NotNull @Size(min = 1, max = 100)
    private String apellido;

    @Column(columnDefinition = "DATE")
    private Date fechaNacimiento;
    private String direccion;
    private String region;
    private String telefono;
    private String email;
    private String prevision;
    private String sexo;
    
    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
    private List<ConsultaMedica> consultas;

    public Paciente() {
        // Constructor por defecto necesario para JPA
    }

    public Paciente(Long id, String rut, String nombre, String apellido, Date fechaNacimiento, String direccion, String region, String telefono, 
                    String email, String prevision, String sexo, List<ConsultaMedica> consultas) {
        this.id = id;
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.region = region;
        this.telefono = telefono;
        this.email = email;
        this.prevision = prevision;
        this.sexo = sexo;
        this.consultas = consultas;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPrevision() {
        return prevision;
    }

    public void setPrevision(String prevision) {
        this.prevision = prevision;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public List<ConsultaMedica> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<ConsultaMedica> consultas) {
        this.consultas = consultas;
    }
}

