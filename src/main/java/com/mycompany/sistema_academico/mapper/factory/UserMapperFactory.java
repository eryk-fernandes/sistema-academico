package com.mycompany.sistema_academico.mapper.factory;

import com.mycompany.sistema_academico.dto.UserCreateDTO;
import com.mycompany.sistema_academico.dto.UserResponseDTO;
import com.mycompany.sistema_academico.dto.UserUpdateDTO;
import com.mycompany.sistema_academico.entity.User;
import com.mycompany.sistema_academico.mapper.abstract_mapper.CreateMapper;
import com.mycompany.sistema_academico.mapper.abstract_mapper.ResponseMapper;
import com.mycompany.sistema_academico.mapper.abstract_mapper.UpdateMapper;
import com.mycompany.sistema_academico.mapper.concrete_mapper.UserCreateMapper;
import com.mycompany.sistema_academico.mapper.concrete_mapper.UserResponseMapper;
import com.mycompany.sistema_academico.mapper.concrete_mapper.UserUpdateMapper;

public class UserMapperFactory implements MapperFactory<User, UserCreateDTO, UserResponseDTO, UserUpdateDTO> {

    @Override
    public CreateMapper<User, UserCreateDTO> createMapper() {
        return new UserCreateMapper();
    }

    @Override
    public ResponseMapper<User, UserResponseDTO> responseMapper() {
        return new UserResponseMapper();
    }

    @Override
    public UpdateMapper<User, UserUpdateDTO> updateMapper() {
        return new UserUpdateMapper();
    }
}
