package com.mycompany.sistema_academico.dto.usuario;

import java.util.UUID;

public record UsuarioAtualizacaoDTO(UUID idUsuario, String nomeUsuario, String email, String senha) implements UsuarioDTO
{}
