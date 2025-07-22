package com.mycompany.sistema_academico.controller;

import com.mycompany.sistema_academico.dto.usuario.UsuarioCriacaoDTO;
import com.mycompany.sistema_academico.dto.usuario.UsuarioRespostaDTO;
import com.mycompany.sistema_academico.dto.usuario.UsuarioAtualizacaoDTO;
import com.mycompany.sistema_academico.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
@AllArgsConstructor
public class UsuarioController {

    private UsuarioService usuarioService;

    @GetMapping("/{idUsuario}")
    public ResponseEntity<UsuarioRespostaDTO> recuperarUsuarioPorId(@PathVariable("idUsuario") String userId) {

        UsuarioRespostaDTO usuarioRespostaDTO = usuarioService.recuperarPorId(userId);

        if (usuarioRespostaDTO != null) {
            return ResponseEntity.ok(usuarioRespostaDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping()
    public ResponseEntity<List<UsuarioRespostaDTO>> recuperarUsuarios() {
        List<UsuarioRespostaDTO> users = usuarioService.recuperarTodos();

        if (!users.isEmpty()) {
            return ResponseEntity.ok(users);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping()
    public ResponseEntity<UsuarioRespostaDTO> criarUsuario(@RequestBody UsuarioCriacaoDTO usuarioCriacaoDTO) {
        UsuarioRespostaDTO usuarioRespostaDTO = usuarioService.criar(usuarioCriacaoDTO);

        return ResponseEntity.created(URI.create("users/" + usuarioRespostaDTO.usuarioId())).build();
    }

    @DeleteMapping("/{idUsuario}")
    public ResponseEntity<Void> deletarUsuarioPorId(@PathVariable("idUsuario") String usuarioId) {
        usuarioService.removerPorId(usuarioId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping()
    public ResponseEntity<UsuarioRespostaDTO> atualizarUsuario(@RequestBody UsuarioAtualizacaoDTO usuarioAtualizacaoDTO) {

        UsuarioRespostaDTO usuarioRespostaDTO = usuarioService.atualizar(usuarioAtualizacaoDTO);

        if (usuarioRespostaDTO != null) {
            return ResponseEntity.ok(usuarioRespostaDTO);
        }
        return ResponseEntity.notFound().build();
    }

}
