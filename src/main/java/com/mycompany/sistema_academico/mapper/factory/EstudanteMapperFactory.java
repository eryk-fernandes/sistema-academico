package com.mycompany.sistema_academico.mapper.factory;

import com.mycompany.sistema_academico.dto.estudante.EstudanteAtualizacaoDTO;
import com.mycompany.sistema_academico.dto.estudante.EstudanteCriacaoDTO;
import com.mycompany.sistema_academico.dto.estudante.EstudanteRespostaDTO;
import com.mycompany.sistema_academico.entity.Estudante;
import com.mycompany.sistema_academico.mapper.abstract_mapper.AtualizacaoMapper;
import com.mycompany.sistema_academico.mapper.abstract_mapper.CriacaoMapper;
import com.mycompany.sistema_academico.mapper.abstract_mapper.RespostaMapper;
import com.mycompany.sistema_academico.mapper.concrete_mapper.estudante.AtualizacaoEstudanteMapper;
import com.mycompany.sistema_academico.mapper.concrete_mapper.estudante.CriacaoEstudanteMapper;
import com.mycompany.sistema_academico.mapper.concrete_mapper.estudante.RespostaEstudanteMapper;

public class EstudanteMapperFactory implements MapperFactory<Estudante, EstudanteCriacaoDTO, EstudanteRespostaDTO, EstudanteAtualizacaoDTO> {

    @Override
    public CriacaoMapper<Estudante, EstudanteCriacaoDTO> criarCriacaoMapper() {
        return new CriacaoEstudanteMapper();
    }

    @Override
    public RespostaMapper<Estudante, EstudanteRespostaDTO> criarRespostaMapper() {
        return new RespostaEstudanteMapper();
    }

    @Override
    public AtualizacaoMapper<Estudante, EstudanteAtualizacaoDTO> criarAtualizacaoMapper() {
        return new AtualizacaoEstudanteMapper();
    }
}
