package com.mycompany.sistema_academico.mapper.concrete_mapper.usuario;

import com.mycompany.sistema_academico.dto.usuario.UsuarioAtualizacaoDTO;
import com.mycompany.sistema_academico.entity.Usuario;
import com.mycompany.sistema_academico.mapper.abstract_mapper.AtualizacaoMapper;

public class AtualizacaoUsuarioMapper implements AtualizacaoMapper<Usuario, UsuarioAtualizacaoDTO> {

    @Override
    public Usuario toEntity(UsuarioAtualizacaoDTO usuarioAtualizacaoDTO) {
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(usuarioAtualizacaoDTO.usuarioId());
        usuario.setNomeUsuario(usuarioAtualizacaoDTO.nomeUsuario());
        usuario.setEmail(usuarioAtualizacaoDTO.email());
        usuario.setSenha(usuarioAtualizacaoDTO.senha());

        return usuario;
    }

    @Override
    public UsuarioAtualizacaoDTO toDTO(Usuario usuario) {
        return new UsuarioAtualizacaoDTO(
                usuario.getIdUsuario(),
                usuario.getNomeUsuario(),
                usuario.getEmail(),
                usuario.getSenha()
        );
    }
}
