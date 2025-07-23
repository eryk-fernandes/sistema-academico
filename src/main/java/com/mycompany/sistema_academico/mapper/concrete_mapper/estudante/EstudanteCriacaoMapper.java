package com.mycompany.sistema_academico.mapper.concrete_mapper.estudante;

import com.mycompany.sistema_academico.dto.estudante.EstudanteCriacaoDTO;
import com.mycompany.sistema_academico.entity.Estudante;
import com.mycompany.sistema_academico.mapper.abstract_mapper.CriacaoMapper;

public class EstudanteCriacaoMapper implements CriacaoMapper<Estudante, EstudanteCriacaoDTO> {


    @Override
    public Estudante toEntity(EstudanteCriacaoDTO estudanteCriacaoDTO) {
        Estudante estudante = new Estudante();

        estudante.setNome(estudanteCriacaoDTO.nome());
        estudante.setCpf(estudanteCriacaoDTO.cpf());
        estudante.setIdCurso(estudanteCriacaoDTO.idCurso());

        return estudante;
    }

    @Override
    public EstudanteCriacaoDTO toDTO(Estudante estudante) {
        return new EstudanteCriacaoDTO(
                estudante.getNome(),
                estudante.getCpf(),
                estudante.getIdCurso()
        );
    }
}
