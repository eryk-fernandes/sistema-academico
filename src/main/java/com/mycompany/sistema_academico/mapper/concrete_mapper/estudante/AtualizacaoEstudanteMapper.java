package com.mycompany.sistema_academico.mapper.concrete_mapper.estudante;

import com.mycompany.sistema_academico.dto.estudante.EstudanteAtualizacaoDTO;
import com.mycompany.sistema_academico.entity.Estudante;
import com.mycompany.sistema_academico.mapper.abstract_mapper.AtualizacaoMapper;

public class AtualizacaoEstudanteMapper implements AtualizacaoMapper<Estudante, EstudanteAtualizacaoDTO> {

    @Override
    public Estudante toEntity(EstudanteAtualizacaoDTO estudanteAtualizacaoDTO) {
        return null;
    }

    @Override
    public EstudanteAtualizacaoDTO toDTO(Estudante estudante) {
        return null;
    }
}
