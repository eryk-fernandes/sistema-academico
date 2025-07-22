package com.mycompany.sistema_academico.service;

import com.mycompany.sistema_academico.repository.EstudanteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EstudanteService {

    private EstudanteRepository estudanteRepository;

}
