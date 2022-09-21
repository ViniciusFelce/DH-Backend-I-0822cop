package br.com.dh.mongodb.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "dentista")
public class Dentista {

    @Id
    private Integer id;
    private String nome;
    private String email;
    private Integer cro;
    private boolean atendeconvenio;
    private String cidade;

    public Dentista() {
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

    public Integer getCro() {
        return cro;
    }

    public void setCro(Integer cro) {
        this.cro = cro;
    }

    public boolean isAtendeconvenio() {
        return atendeconvenio;
    }

    public void setAtendeconvenio(boolean atendeconvenio) {
        this.atendeconvenio = atendeconvenio;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
