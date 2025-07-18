package com.mycompany.sistema_academico.mapper;

import com.mycompany.sistema_academico.dto.UserResponseDTO;
import com.mycompany.sistema_academico.entity.User;

public class UserMapper implements Mapper<User, UserResponseDTO> {

    @Override
    public User toEntity(UserResponseDTO userResponseDTO) {

        User user = new User();
        user.setUserId(userResponseDTO.userId());
        user.setUsername(userResponseDTO.username());
        user.setEmail(userResponseDTO.email());

        return new User();
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
