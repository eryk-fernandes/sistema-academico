package com.mycompany.sistema_academico.mapper.factory;

import com.mycompany.sistema_academico.dto.usuario.UsuarioCriacaoDTO;
import com.mycompany.sistema_academico.dto.usuario.UsuarioRespostaDTO;
import com.mycompany.sistema_academico.dto.usuario.UsuarioAtualizacaoDTO;
import com.mycompany.sistema_academico.entity.Usuario;
import com.mycompany.sistema_academico.mapper.abstract_mapper.CriacaoMapper;
import com.mycompany.sistema_academico.mapper.abstract_mapper.RespostaMapper;
import com.mycompany.sistema_academico.mapper.concrete_mapper.usuario.UsuarioRespostaMapper;
import com.mycompany.sistema_academico.mapper.concrete_mapper.usuario.UsuarioCriacaoMapper;

public class UsuarioMapperFactory implements MapperFactory<Usuario, UsuarioCriacaoDTO, UsuarioRespostaDTO, UsuarioAtualizacaoDTO> {

    @Override
    public CriacaoMapper<Usuario, UsuarioCriacaoDTO> criarCriacaoMapper() {
        return new UsuarioCriacaoMapper();
    }

    @Override
    public RespostaMapper<Usuario, UsuarioRespostaDTO> criarRespostaMapper() {
        return new UsuarioRespostaMapper();
    }

}
