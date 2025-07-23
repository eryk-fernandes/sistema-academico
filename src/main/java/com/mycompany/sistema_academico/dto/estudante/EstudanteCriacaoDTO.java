package com.mycompany.sistema_academico.dto.estudante;

public record EstudanteCriacaoDTO(
        String nome,
        String cpf,
        Integer idCurso
    ) implements EstudanteDTO {
}