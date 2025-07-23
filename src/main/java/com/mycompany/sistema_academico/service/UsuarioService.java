package com.mycompany.sistema_academico.service;

import com.mycompany.sistema_academico.dto.usuario.UsuarioCriacaoDTO;
import com.mycompany.sistema_academico.dto.usuario.UsuarioRespostaDTO;
import com.mycompany.sistema_academico.dto.usuario.UsuarioAtualizacaoDTO;
import com.mycompany.sistema_academico.entity.Usuario;
import com.mycompany.sistema_academico.mapper.abstract_mapper.RespostaMapper;
import com.mycompany.sistema_academico.mapper.factory.UsuarioMapperFactory;
import com.mycompany.sistema_academico.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UsuarioService {

    private UsuarioRepository usuarioRepository;
    private UsuarioMapperFactory usuarioMapper;
    private final PasswordEncoder critografador;

    public UsuarioRespostaDTO recuperarPorId(String userId) {
        Optional<Usuario> user = usuarioRepository.findById(UUID.fromString(userId));

        return user.map(usuario -> usuarioMapper.criarRespostaMapper().toDTO(usuario)).orElse(null);
    }

    public List<UsuarioRespostaDTO> recuperarTodos() {
        List<Usuario> usuarios = usuarioRepository.findAll();

        RespostaMapper<Usuario, UsuarioRespostaDTO> respostaMapper = usuarioMapper.criarRespostaMapper();

        return usuarios.stream().map(respostaMapper::toDTO).toList();
    }

    public UsuarioRespostaDTO criar(UsuarioCriacaoDTO usuarioCriacaoDTO) {

        if (emailIndisponivel(usuarioCriacaoDTO.email()) ||
            usuarioIndisponivel(usuarioCriacaoDTO.nomeUsuario()))
        {
            return null;
        }

        Usuario usuario = usuarioMapper.criarCriacaoMapper().toEntity(usuarioCriacaoDTO);
        usuario.setSenha(hashSenha(usuario.getSenha()));

        Usuario savedUsuario = usuarioRepository.save(usuario);

        return usuarioMapper.criarRespostaMapper().toDTO(savedUsuario);
    }

    public void removerPorId(String userId) {
        UUID id = UUID.fromString(userId);

        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(UUID.fromString(userId));
        }
    }

    public UsuarioRespostaDTO atualizar(UsuarioAtualizacaoDTO usuarioAtualizacaoDTO) {

        Optional<Usuario> userOptional = usuarioRepository.findById(usuarioAtualizacaoDTO.idUsuario());

        if (userOptional.isEmpty()) {
            return null;
        }

        Usuario novoUsuario = userOptional.get();

        boolean emailModificado = !novoUsuario.getEmail().equals(usuarioAtualizacaoDTO.email());

        if (emailModificado) {
            if (emailIndisponivel(usuarioAtualizacaoDTO.email())) {
                return null;
            }
        }

        boolean nomeUsuarioModificado = !novoUsuario.getNomeUsuario().equals(usuarioAtualizacaoDTO.nomeUsuario());

        if (nomeUsuarioModificado) {
            if (usuarioIndisponivel(usuarioAtualizacaoDTO.nomeUsuario())) {
                System.out.println(novoUsuario.getNomeUsuario());
                return null;
            }
        }

        Usuario usuario = usuarioMapper.criarAtualizacaoMapper().toEntity(usuarioAtualizacaoDTO);

        novoUsuario.setNomeUsuario(usuario.getNomeUsuario());
        novoUsuario.setEmail(usuario.getEmail());
        novoUsuario.setSenha(hashSenha(usuario.getSenha()));

        usuarioRepository.save(novoUsuario);

        return usuarioMapper.criarRespostaMapper().toDTO(novoUsuario);
    }

    private String hashSenha(String password) {
        return critografador.encode(password);
    }

    private Boolean emailIndisponivel(String email) {
        List<Usuario> usuarios = usuarioRepository.findAll();

        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    private Boolean usuarioIndisponivel(String username) {
        List<Usuario> usuarios = usuarioRepository.findAll();

        for (Usuario usuario : usuarios) {
            if (usuario.getNomeUsuario().equals(username)) {
                return true;
            }
        }
        return false;
    }

}
