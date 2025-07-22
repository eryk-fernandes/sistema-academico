package com.mycompany.sistema_academico.dto.usuario;

import java.util.UUID;

public record UsuarioAtualizacaoDTO(UUID usuarioId, String nomeUsuario, String email, String senha) implements UsuarioDTO
{}
