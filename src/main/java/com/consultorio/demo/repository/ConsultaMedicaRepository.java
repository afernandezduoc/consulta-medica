package com.consultorio.demo.repository;

import com.consultorio.demo.model.ConsultaMedica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultaMedicaRepository extends JpaRepository<ConsultaMedica, Long> {
    
}
