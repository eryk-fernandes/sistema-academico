package com.mycompany.sistema_academico.dto.estudante;

import java.util.List;
import java.util.UUID;

public record EstudanteRespostaDTO(
        UUID idEstudante,
        String matricula,
        String nome,
        String cpf,
        UUID idUsuario,
        Integer periodo,
        Integer idCurso,
        Double coeficienteRendimento,
        List<String> disciplinasAtuais,
        List<String> disciplinasPagas

    ) implements EstudanteDTO {
}
