package com.mycompany.sistema_academico.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "usuarios")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID usuarioId;
    @Column(name = "nomeUsuario", nullable = false, length = 255, unique = true)
    private String nomeUsuario;
    @Column(name = "email", nullable = false, length = 255, unique = true)
    private String email;
    @Column(name = "senha", nullable = false, length = 255)
    private String senha;
    @CreationTimestamp
    private Instant instanteCriacao;
    @UpdateTimestamp
    private Instant instanteAtualizacao;

}
