package com.mycompany.sistema_academico.controller;

import com.mycompany.sistema_academico.dto.UserCreateDTO;
import com.mycompany.sistema_academico.dto.UserResponseDTO;
import com.mycompany.sistema_academico.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

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

    @PostMapping()
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserCreateDTO userCreateDTO) {
        UserResponseDTO userResponseDTO = userService.createUser(userCreateDTO);

        return ResponseEntity.created(URI.create("users/" + userResponseDTO.userId())).build();
    }

}
