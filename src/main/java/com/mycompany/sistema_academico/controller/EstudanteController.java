package com.mycompany.sistema_academico.controller;

import com.mycompany.sistema_academico.dto.estudante.EstudanteAtualizacaoDTO;
import com.mycompany.sistema_academico.dto.estudante.EstudanteCriacaoDTO;
import com.mycompany.sistema_academico.dto.estudante.EstudanteRespostaDTO;
import com.mycompany.sistema_academico.dto.usuario.UsuarioRespostaDTO;
import com.mycompany.sistema_academico.service.EstudanteService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/estudantes")
@AllArgsConstructor
public class EstudanteController {

    private EstudanteService estudanteService;

    @GetMapping("/{idEstudante}")
    public ResponseEntity<EstudanteRespostaDTO> recuperarEstudantePorid(@PathVariable("idEstudante") String idEstudante) {
        EstudanteRespostaDTO estudanteRespostaDTO = estudanteService.recuperarPorId(idEstudante);

        if (estudanteRespostaDTO != null) {
            return ResponseEntity.ok(estudanteRespostaDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping()
    public ResponseEntity<List<EstudanteRespostaDTO>> recuperarEstudantes() {
        List<EstudanteRespostaDTO> estudanteRespostaDTOs = estudanteService.recuperarTodos();

        if (!estudanteRespostaDTOs.isEmpty()) {
            return ResponseEntity.ok(estudanteRespostaDTOs);
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<EstudanteRespostaDTO> criarEstudante(@RequestBody EstudanteCriacaoDTO estudanteCriacaoDTO) {
        EstudanteRespostaDTO estudanteRespostaDTO = estudanteService.criar(estudanteCriacaoDTO);

        return ResponseEntity.created(URI.create("/estudantes" + estudanteRespostaDTO.idEstudante())).build();
    }

    @DeleteMapping("/{idEstudante}")
    public ResponseEntity<Void> removerEstudantePorId(@PathVariable("idEstudante") String idEstudante) {
        estudanteService.removerPorId(idEstudante);

        return ResponseEntity.noContent().build();
    }

    @PutMapping()
    public ResponseEntity<EstudanteRespostaDTO> atualizarEstudante(@RequestBody EstudanteAtualizacaoDTO estudanteAtualizacaoDTO) {

        EstudanteRespostaDTO estudanteRespostaDTO = estudanteService.atualizar(estudanteAtualizacaoDTO);

        if (estudanteRespostaDTO != null) {
            return ResponseEntity.ok(estudanteRespostaDTO);
        }

        return ResponseEntity.notFound().build();
    }

}
