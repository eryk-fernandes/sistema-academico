package com.mycompany.sistema_academico.dto;

import java.util.UUID;

public record UserUpdateDTO (UUID userId, String username, String email, String password) implements UserDTO
{}
