package com.mycompany.sistema_academico.mapper.concrete_mapper.usuario;

import com.mycompany.sistema_academico.dto.usuario.UsuarioCriacaoDTO;
import com.mycompany.sistema_academico.entity.Usuario;
import com.mycompany.sistema_academico.mapper.abstract_mapper.CriacaoMapper;

public class CriacaoUsuarioMapper implements CriacaoMapper<Usuario, UsuarioCriacaoDTO> {
    @Override
    public Usuario toEntity(UsuarioCriacaoDTO usuarioCriacaoDTO) {
        Usuario usuario = new Usuario();
        usuario.setNomeUsuario(usuarioCriacaoDTO.nomeUsuario());
        usuario.setEmail(usuarioCriacaoDTO.email());
        usuario.setSenha(usuarioCriacaoDTO.senha());

        return usuario;
    }

    @Override
    public UsuarioCriacaoDTO toDTO(Usuario usuario) {
        return new UsuarioCriacaoDTO(
                usuario.getNomeUsuario(),
                usuario.getEmail(),
                usuario.getSenha()
        );
    }
}
