package entities;

import java.sql.Date;

public class Paciente {

    private Integer id;
    private String nome;
    private String sobrenome;
    private String rg;
    private Date datacadastro;
    private String endereco;

    public Paciente() {
    }

    public Paciente(Integer id, String nome, String sobrenome, String rg, Date datacadastro, String endereco) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.rg = rg;
        this.datacadastro = datacadastro;
        this.endereco = endereco;
    }

    public Paciente(String nome, String sobrenome, String rg, Date datacadastro, String endereco) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.rg = rg;
        this.datacadastro = datacadastro;
        this.endereco = endereco;
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

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Date getDatacadastro() {
        return datacadastro;
    }

    public void setDatacadastro(Date datacadastro) {
        this.datacadastro = datacadastro;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Pacientes{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", rg='" + rg + '\'' +
                ", datacadastro=" + datacadastro +
                ", endereco='" + endereco + '\'' +
                '}';
    }
}
