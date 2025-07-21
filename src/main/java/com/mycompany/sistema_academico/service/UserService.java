package com.mycompany.sistema_academico.service;

import com.mycompany.sistema_academico.dto.UserCreateDTO;
import com.mycompany.sistema_academico.dto.UserResponseDTO;
import com.mycompany.sistema_academico.dto.UserUpdateDTO;
import com.mycompany.sistema_academico.entity.User;
import com.mycompany.sistema_academico.mapper.factory.UserMapperFactory;
import com.mycompany.sistema_academico.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;
    private UserMapperFactory userMapper;
    private final PasswordEncoder passwordEncoder;

    public UserResponseDTO findById(String userId) {
        Optional<User> user = userRepository.findById(UUID.fromString(userId));

        if (user.isPresent()) {
            return userMapper.responseMapper().toDTO(user.get());
        }
        return null;
    }

    public List<UserResponseDTO> findAll() {
        List<User> users = userRepository.findAll();

        return users.stream().map(
                u -> userMapper.responseMapper().toDTO(u)
        ).toList();
    }

    public UserResponseDTO create(UserCreateDTO userCreateDTO) {

        if (isEmailUnavailable(userCreateDTO.email()) ||
            isUsernameUnavailable(userCreateDTO.username()))
        {
            return null;
        }

        User user = userMapper.createMapper().toEntity(userCreateDTO);
        user.setPassword(hashPassword(user.getPassword()));

        User savedUser = userRepository.save(user);

        return userMapper.responseMapper().toDTO(savedUser);
    }

    public void deleteById(String userId) {
        UUID id = UUID.fromString(userId);

        if (userRepository.existsById(id)) {
            userRepository.deleteById(UUID.fromString(userId));
        }
    }

    public UserResponseDTO update(UserUpdateDTO userUpdateDTO) {

        Optional<User> userOptional = userRepository.findById(userUpdateDTO.userId());

        if (userOptional.isEmpty()) {
            return null;
        }

        User newUser = userOptional.get();

        boolean emailChanged = !newUser.getEmail().equals(userUpdateDTO.email());

        if (emailChanged) {
            if (isEmailUnavailable(userUpdateDTO.email())) {
                return null;
            }
        }

        boolean usernameChanged = !newUser.getUsername().equals(userUpdateDTO.username());

        if (usernameChanged) {
            if (isUsernameUnavailable(userUpdateDTO.username())) {
                System.out.println(newUser.getUsername());
                return null;
            }
        }

        User user = userMapper.updateMapper().toEntity(userUpdateDTO);

        newUser.setUsername(user.getUsername());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(hashPassword(user.getPassword()));

        userRepository.save(newUser);

        return userMapper.responseMapper().toDTO(newUser);
    }

    private String hashPassword(String password) {
        return passwordEncoder.encode(password);
    }

    private Boolean isEmailUnavailable(String email) {
        List<User> users = userRepository.findAll();

        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    private Boolean isUsernameUnavailable(String username) {
        List<User> users = userRepository.findAll();

        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

}
