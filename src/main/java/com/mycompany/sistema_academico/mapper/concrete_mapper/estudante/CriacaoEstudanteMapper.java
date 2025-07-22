package com.mycompany.sistema_academico.mapper.concrete_mapper.estudante;

import com.mycompany.sistema_academico.dto.estudante.EstudanteCriacaoDTO;
import com.mycompany.sistema_academico.entity.Estudante;
import com.mycompany.sistema_academico.mapper.abstract_mapper.CriacaoMapper;

public class CriacaoEstudanteMapper implements CriacaoMapper<Estudante, EstudanteCriacaoDTO> {


    @Override
    public Estudante toEntity(EstudanteCriacaoDTO estudanteCriacaoDTO) {
        return null;
    }

    @Override
    public EstudanteCriacaoDTO toDTO(Estudante estudante) {
        return null;
    }
}
