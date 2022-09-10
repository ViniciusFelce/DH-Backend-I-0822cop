package br.com.dh.orm.entities;

import javax.persistence.*;

@Entity
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private Integer idade;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

    public Aluno() {
    }
}
