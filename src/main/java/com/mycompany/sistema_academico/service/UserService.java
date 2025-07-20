package com.mycompany.sistema_academico.service;

import com.mycompany.sistema_academico.dto.UserCreateDTO;
import com.mycompany.sistema_academico.dto.UserResponseDTO;
import com.mycompany.sistema_academico.dto.UserUpdateDTO;
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

    public void deleteById(String userId) {
        UUID id = UUID.fromString(userId);

        if (userRepository.existsById(id)) {
            userRepository.deleteById(UUID.fromString(userId));
        }
    }

    public UserResponseDTO updateUser(UserUpdateDTO userUpdateDTO) {
        Optional<User> userOptional = userRepository.findById(userUpdateDTO.userId());

        if (userOptional.isPresent()) {

            User user = userOptional.get();

            user.setUsername(userUpdateDTO.username());
            user.setEmail(userUpdateDTO.email());
            user.setPassword(passwordEncoder.encode(userUpdateDTO.password()));

            userRepository.save(user);

            return new UserResponseDTO(
                    user.getUserId(),
                    user.getUsername(),
                    user.getEmail()
            );
        }
        return null;
    }

}
