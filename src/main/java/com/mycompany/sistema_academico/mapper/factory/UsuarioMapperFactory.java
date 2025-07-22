package com.mycompany.sistema_academico.mapper.factory;

import com.mycompany.sistema_academico.dto.UsuarioCriacaoDTO;
import com.mycompany.sistema_academico.dto.UsuarioRespostaDTO;
import com.mycompany.sistema_academico.dto.UsuarioAtualizacaoDTO;
import com.mycompany.sistema_academico.entity.Usuario;
import com.mycompany.sistema_academico.mapper.abstract_mapper.CriacaoMapper;
import com.mycompany.sistema_academico.mapper.abstract_mapper.RespostaMapper;
import com.mycompany.sistema_academico.mapper.abstract_mapper.AtualizacaoMapper;
import com.mycompany.sistema_academico.mapper.concrete_mapper.AtualizacaoUsuarioMapper;
import com.mycompany.sistema_academico.mapper.concrete_mapper.RespostaUsuarioMapper;
import com.mycompany.sistema_academico.mapper.concrete_mapper.CriacaoUsuarioMapper;

public class UsuarioMapperFactory implements MapperFactory<Usuario, UsuarioCriacaoDTO, UsuarioRespostaDTO, UsuarioAtualizacaoDTO> {

    @Override
    public CriacaoMapper<Usuario, UsuarioCriacaoDTO> criarCriacaoMapper() {
        return new CriacaoUsuarioMapper();
    }

    @Override
    public RespostaMapper<Usuario, UsuarioRespostaDTO> criarRespostaMapper() {
        return new RespostaUsuarioMapper();
    }

    @Override
    public AtualizacaoMapper<Usuario, UsuarioAtualizacaoDTO> criarAtualizacaoMapper() {
        return new AtualizacaoUsuarioMapper();
    }
}
