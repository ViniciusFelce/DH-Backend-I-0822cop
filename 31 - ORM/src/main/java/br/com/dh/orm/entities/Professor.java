package br.com.dh.orm.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String curso;

    @OneToMany(mappedBy = "professor")
    private Set<Aluno> alunos = new HashSet<>();

    public Professor() {
    }
}
