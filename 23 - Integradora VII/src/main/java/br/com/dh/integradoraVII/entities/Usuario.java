package br.com.dh.integradoraVII.entities;

public class Usuario {

    private Integer id;
    private String nome;
    private String email;
    private String senha;
    private Integer nivelacesso;

    public Usuario() {
    }

    public Usuario(Integer id, String nome, String email, String senha, Integer nivelacesso) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.nivelacesso = nivelacesso;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Integer getNivelacesso() {
        return nivelacesso;
    }

    public void setNivelacesso(Integer nivelacesso) {
        this.nivelacesso = nivelacesso;
    }
}
