package com.mycompany.sistema_academico.dto.usuario;

import java.util.UUID;

public record UsuarioRespostaDTO(UUID idUsuario, String nomeUsuario, String email) implements UsuarioDTO
{}
