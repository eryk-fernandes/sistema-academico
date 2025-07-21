package com.mycompany.sistema_academico.dto;

import java.util.UUID;

public record UserResponseDTO(UUID userId, String username, String email) implements UserDTO
{}
