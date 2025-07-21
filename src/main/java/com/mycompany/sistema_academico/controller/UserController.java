package com.mycompany.sistema_academico.controller;

import com.mycompany.sistema_academico.dto.UserCreateDTO;
import com.mycompany.sistema_academico.dto.UserResponseDTO;
import com.mycompany.sistema_academico.dto.UserUpdateDTO;
import com.mycompany.sistema_academico.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable("userId") String userId) {

        UserResponseDTO userResponseDTO = userService.findById(userId);

        if (userResponseDTO != null) {
            return ResponseEntity.ok(userResponseDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping()
    public ResponseEntity<List<UserResponseDTO>> getUsers() {
        List<UserResponseDTO> users = userService.findAll();

        if (!users.isEmpty()) {
            return ResponseEntity.ok(users);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping()
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserCreateDTO userCreateDTO) {
        UserResponseDTO userResponseDTO = userService.create(userCreateDTO);

        return ResponseEntity.created(URI.create("users/" + userResponseDTO.userId())).build();
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUserById(@PathVariable("userId") String userId) {
        userService.deleteById(userId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping()
    public ResponseEntity<UserResponseDTO> updateUser(@RequestBody UserUpdateDTO userUpdateDTO) {

        UserResponseDTO userResponseDTO = userService.update(userUpdateDTO);

        if (userResponseDTO != null) {
            return ResponseEntity.ok(userResponseDTO);
        }
        return ResponseEntity.notFound().build();
    }

}
