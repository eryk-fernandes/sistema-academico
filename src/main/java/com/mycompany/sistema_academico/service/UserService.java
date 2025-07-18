package com.mycompany.sistema_academico.service;

import com.mycompany.sistema_academico.dto.UserCreateDTO;
import com.mycompany.sistema_academico.dto.UserResponseDTO;
import com.mycompany.sistema_academico.entity.User;
import com.mycompany.sistema_academico.mapper.UserMapper;
import com.mycompany.sistema_academico.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private UserRepository userRepository;
    private UserMapper userMapper;

    public UserResponseDTO findById(String userId) {
        Optional<User> user = userRepository.findById(UUID.fromString(userId));

        if (user.isPresent()) {
            return userMapper.toDTO(user.get());
        }
        return null;
    }

    public UserResponseDTO createUser(UserCreateDTO userCreateDTO) {
        User user = new User();
        user.setEmail(userCreateDTO.email());
        user.setPassword(passwordEncoder.encode(userCreateDTO.password()));
        user.setUsername(userCreateDTO.username());

        User savedUser = userRepository.save(user);

        return new UserResponseDTO(savedUser.getUserId(), savedUser.getUsername(), savedUser.getEmail());
    }

}
