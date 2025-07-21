package com.mycompany.sistema_academico.mapper.concrete_mapper;

import com.mycompany.sistema_academico.dto.UserCreateDTO;
import com.mycompany.sistema_academico.entity.User;
import com.mycompany.sistema_academico.mapper.abstract_mapper.CreateMapper;

public class UserCreateMapper implements CreateMapper<User, UserCreateDTO> {
    @Override
    public User toEntity(UserCreateDTO userCreateDTO) {
        User user = new User();
        user.setUsername(userCreateDTO.username());
        user.setEmail(userCreateDTO.email());
        user.setPassword(userCreateDTO.password());

        return user;
    }

    @Override
    public UserCreateDTO toDTO(User user) {
        return new UserCreateDTO(
                user.getUsername(),
                user.getEmail(),
                user.getPassword()
        );
    }
}
