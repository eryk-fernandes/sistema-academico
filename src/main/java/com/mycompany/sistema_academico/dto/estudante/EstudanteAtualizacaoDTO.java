package com.mycompany.sistema_academico.dto.estudante;

import java.util.List;
import java.util.UUID;

public record EstudanteAtualizacaoDTO(
        UUID idEstudante,
        String nome,
        Integer periodo,
        Double coeficienteRendimento,
        List<String> disciplinasAtuais,
        List<String> disciplinasPagas

    ) implements EstudanteDTO {
}
