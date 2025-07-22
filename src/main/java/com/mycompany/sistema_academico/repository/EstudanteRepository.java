package com.mycompany.sistema_academico.repository;

import com.mycompany.sistema_academico.entity.Estudante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EstudanteRepository extends JpaRepository<Estudante, UUID> {
}
