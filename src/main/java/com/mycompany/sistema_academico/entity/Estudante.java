package com.mycompany.sistema_academico.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "estudantes")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Estudante {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_estudante")
    private UUID idEstudante;

    @Column(name = "matricula", unique = true)
    private String matricula;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cpf", length = 11, unique = true)
    private String cpf;

    @Column(name = "id_usuario", unique = true)
    private UUID idUsuario;

    @Column(name = "periodo")
    private Integer periodo;

    @Column(name = "curso")
    private String curso;

    @Column(name = "coeficiente_rendimento")
    private Double coeficienteRendimento;

    @Column(name = "disciplinas_atuais")
    private List<String> disciplinasAtuais;

    @Column(name = "disciplinas_pagas")
    private List<String> disciplinasPagas;

}
