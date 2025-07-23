package com.mycompany.sistema_academico.mapper.concrete_mapper.estudante;

import com.mycompany.sistema_academico.dto.estudante.EstudanteAtualizacaoDTO;
import com.mycompany.sistema_academico.entity.Estudante;
import com.mycompany.sistema_academico.mapper.abstract_mapper.AtualizacaoMapper;

public class EstudanteAtualizacaoMapper implements AtualizacaoMapper<Estudante, EstudanteAtualizacaoDTO> {

    @Override
    public Estudante toEntity(EstudanteAtualizacaoDTO estudanteAtualizacaoDTO) {
        Estudante estudante = new Estudante();

        estudante.setIdUsuario(estudanteAtualizacaoDTO.idEstudante());
        estudante.setNome(estudanteAtualizacaoDTO.nome());
        estudante.setPeriodo(estudanteAtualizacaoDTO.periodo());
        estudante.setCoeficienteRendimento(estudanteAtualizacaoDTO.coeficienteRendimento());
        estudante.setDisciplinasAtuais(estudanteAtualizacaoDTO.disciplinasAtuais());
        estudante.setDisciplinasPagas(estudanteAtualizacaoDTO.disciplinasPagas());

        return estudante;
    }

    @Override
    public EstudanteAtualizacaoDTO toDTO(Estudante estudante) {
        return new EstudanteAtualizacaoDTO(
                estudante.getIdEstudante(),
                estudante.getNome(),
                estudante.getPeriodo(),
                estudante.getCoeficienteRendimento(),
                estudante.getDisciplinasAtuais(),
                estudante.getDisciplinasPagas()
        );
    }
}
