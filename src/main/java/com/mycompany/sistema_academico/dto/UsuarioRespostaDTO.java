package com.mycompany.sistema_academico.dto;

import java.util.UUID;

public record UsuarioRespostaDTO(UUID usuarioId, String nomeUsuario, String email) implements UsuarioDTO
{}
