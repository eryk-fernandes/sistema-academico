package com.mycompany.sistema_academico.mapper.concrete_mapper;

import com.mycompany.sistema_academico.dto.UserUpdateDTO;
import com.mycompany.sistema_academico.entity.User;
import com.mycompany.sistema_academico.mapper.abstract_mapper.UpdateMapper;

public class UserUpdateMapper implements UpdateMapper<User, UserUpdateDTO> {

    @Override
    public User toEntity(UserUpdateDTO userUpdateDTO) {
        User user = new User();
        user.setUserId(userUpdateDTO.userId());
        user.setUsername(userUpdateDTO.username());
        user.setEmail(userUpdateDTO.email());
        user.setPassword(userUpdateDTO.password());

        return user;
    }

    @Override
    public UserUpdateDTO toDTO(User user) {
        return new UserUpdateDTO(
                user.getUserId(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword()
        );
    }
}
