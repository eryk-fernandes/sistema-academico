package com.mycompany.sistema_academico.mapper.concrete_mapper.estudante;


import com.mycompany.sistema_academico.dto.estudante.EstudanteRespostaDTO;
import com.mycompany.sistema_academico.entity.Estudante;
import com.mycompany.sistema_academico.mapper.abstract_mapper.RespostaMapper;

public class RespostaEstudanteMapper implements RespostaMapper<Estudante, EstudanteRespostaDTO> {


    @Override
    public Estudante toEntity(EstudanteRespostaDTO estudanteCriacaoDTO) {
        return null;
    }

    @Override
    public EstudanteRespostaDTO toDTO(Estudante estudante) {
        return null;
    }
}
