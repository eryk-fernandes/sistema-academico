package com.mycompany.sistema_academico.mapper.concrete_mapper.estudante;

import com.mycompany.sistema_academico.dto.estudante.EstudanteRespostaDTO;
import com.mycompany.sistema_academico.entity.Estudante;
import com.mycompany.sistema_academico.mapper.abstract_mapper.RespostaMapper;

public class EstudanteRespostaMapper implements RespostaMapper<Estudante, EstudanteRespostaDTO> {


    @Override
    public Estudante toEntity(EstudanteRespostaDTO estudanteRespostaDTO) {
        Estudante estudante = new Estudante();

        estudante.setIdEstudante(estudanteRespostaDTO.idEstudante());
        estudante.setMatricula(estudanteRespostaDTO.matricula());
        estudante.setNome(estudanteRespostaDTO.nome());
        estudante.setCpf(estudanteRespostaDTO.cpf());
        estudante.setIdUsuario(estudanteRespostaDTO.idUsuario());
        estudante.setPeriodo(estudanteRespostaDTO.periodo());
        estudante.setIdCurso(estudanteRespostaDTO.idCurso());
        estudante.setCoeficienteRendimento(estudanteRespostaDTO.coeficienteRendimento());
        estudante.setDisciplinasAtuais(estudanteRespostaDTO.disciplinasAtuais());
        estudante.setDisciplinasPagas(estudanteRespostaDTO.disciplinasPagas());

        return estudante;
    }

    @Override
    public EstudanteRespostaDTO toDTO(Estudante estudante) {
        return new EstudanteRespostaDTO(
                estudante.getIdEstudante(),
                estudante.getMatricula(),
                estudante.getNome(),
                estudante.getCpf(),
                estudante.getIdUsuario(),
                estudante.getPeriodo(),
                estudante.getIdCurso(),
                estudante.getCoeficienteRendimento(),
                estudante.getDisciplinasAtuais(),
                estudante.getDisciplinasPagas()
        );
    }
}