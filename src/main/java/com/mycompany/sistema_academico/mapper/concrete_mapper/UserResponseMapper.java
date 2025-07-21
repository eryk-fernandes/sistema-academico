package com.mycompany.sistema_academico.mapper.concrete_mapper;

import com.mycompany.sistema_academico.dto.UserResponseDTO;
import com.mycompany.sistema_academico.entity.User;
import com.mycompany.sistema_academico.mapper.abstract_mapper.ResponseMapper;

public class UserResponseMapper implements ResponseMapper<User, UserResponseDTO>
{

    @Override
    public User toEntity(UserResponseDTO userResponseDTO) {

        User user = new User();
        user.setUserId(userResponseDTO.userId());
        user.setUsername(userResponseDTO.username());
        user.setEmail(userResponseDTO.email());

        return user;
    }

    @Override
    public UserResponseDTO toDTO(User user) {
        return new UserResponseDTO(
                user.getUserId(),
                user.getUsername(),
                user.getEmail()
        );
    }
}
