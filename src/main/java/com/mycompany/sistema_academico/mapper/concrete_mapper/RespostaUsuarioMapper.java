package com.mycompany.sistema_academico.mapper.concrete_mapper;

import com.mycompany.sistema_academico.dto.UsuarioRespostaDTO;
import com.mycompany.sistema_academico.entity.Usuario;
import com.mycompany.sistema_academico.mapper.abstract_mapper.RespostaMapper;

public class RespostaUsuarioMapper implements RespostaMapper<Usuario, UsuarioRespostaDTO>
{

    @Override
    public Usuario toEntity(UsuarioRespostaDTO usuarioRespostaDTO) {

        Usuario usuario = new Usuario();
        usuario.setUsuarioId(usuarioRespostaDTO.usuarioId());
        usuario.setNomeUsuario(usuarioRespostaDTO.nomeUsuario());
        usuario.setEmail(usuarioRespostaDTO.email());

        return usuario;
    }

    @Override
    public UsuarioRespostaDTO toDTO(Usuario usuario) {
        return new UsuarioRespostaDTO(
                usuario.getUsuarioId(),
                usuario.getNomeUsuario(),
                usuario.getEmail()
        );
    }
}
