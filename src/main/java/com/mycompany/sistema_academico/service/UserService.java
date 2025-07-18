package com.mycompany.sistema_academico.service;

import com.mycompany.sistema_academico.dto.UserResponseDTO;
import com.mycompany.sistema_academico.entity.User;
import com.mycompany.sistema_academico.mapper.UserMapper;
import com.mycompany.sistema_academico.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;
    private UserMapper userMapper;

    public UserResponseDTO findById(String userId) {
        Optional<User> user = userRepository.findById(UUID.fromString(userId));

        if (user.isPresent()) {
            return userMapper.toDTO(user.get());
        }
        return null;

    }

}
