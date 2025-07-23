package com.mycompany.sistema_academico.service;

import com.mycompany.sistema_academico.dto.estudante.EstudanteAtualizacaoDTO;
import com.mycompany.sistema_academico.dto.estudante.EstudanteCriacaoDTO;
import com.mycompany.sistema_academico.dto.estudante.EstudanteRespostaDTO;
import com.mycompany.sistema_academico.entity.Estudante;
import com.mycompany.sistema_academico.mapper.abstract_mapper.RespostaMapper;
import com.mycompany.sistema_academico.mapper.factory.EstudanteMapperFactory;
import com.mycompany.sistema_academico.repository.EstudanteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class EstudanteService {

    private EstudanteRepository estudanteRepository;
    private EstudanteMapperFactory estudanteMapper;

    public EstudanteRespostaDTO recuperarPorId(String idEstudante) {
        Optional<Estudante> estudanteOptional = estudanteRepository.findById(UUID.fromString(idEstudante));

        return estudanteOptional.map(
                estudante -> estudanteMapper.criarRespostaMapper()
                                .toDTO(estudante)).orElse(null);
    }

    public List<EstudanteRespostaDTO> recuperarTodos() {
        List<Estudante> estudantes = estudanteRepository.findAll();

        RespostaMapper<Estudante, EstudanteRespostaDTO> respostaMapper = estudanteMapper.criarRespostaMapper();

        return estudantes.stream().map(respostaMapper::toDTO).toList();
    }

    public EstudanteRespostaDTO criar(EstudanteCriacaoDTO estudanteCriacaoDTO) {
        Estudante estudante = estudanteMapper.criarCriacaoMapper().toEntity(estudanteCriacaoDTO);

        Estudante estudanteSalvo = estudanteRepository.save(estudante);

        return estudanteMapper.criarRespostaMapper().toDTO(estudanteSalvo);
    }

    public void removerPorId(String idEstudante) {
        UUID id = UUID.fromString(idEstudante);

        if (estudanteRepository.existsById(id)) {
            estudanteRepository.deleteById(UUID.fromString(idEstudante));
        }
    }

    public EstudanteRespostaDTO atualizar(EstudanteAtualizacaoDTO estudanteAtualizacaoDTO) {
        Optional<Estudante> estudanteOptional = estudanteRepository.findById(estudanteAtualizacaoDTO.idEstudante());

        if (estudanteOptional.isEmpty()) {
            return null;
        }

        Estudante novoEstudante = estudanteOptional.get();

        novoEstudante.setNome(estudanteAtualizacaoDTO.nome());
        novoEstudante.setPeriodo(estudanteAtualizacaoDTO.periodo());
        novoEstudante.setCoeficienteRendimento(estudanteAtualizacaoDTO.coeficienteRendimento());
        novoEstudante.setDisciplinasAtuais(estudanteAtualizacaoDTO.disciplinasAtuais());
        novoEstudante.setDisciplinasPagas(estudanteAtualizacaoDTO.disciplinasPagas());

        estudanteRepository.save(novoEstudante);

        return estudanteMapper.criarRespostaMapper().toDTO(novoEstudante);
    }


}
