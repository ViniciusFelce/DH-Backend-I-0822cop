package br.com.dh.clinica.dtos;

import br.com.dh.clinica.entities.Endereco;

import java.io.Serializable;

public class EnderecoDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String rua;
    private String numero;
    private String bairro;
    private String cidade;
    private String cep;
    private String estado;

    public EnderecoDto() {
    }

    public EnderecoDto(Integer id, String rua, String numero, String bairro, String cidade, String cep, String estado) {
        this.id = id;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
        this.estado = estado;
    }

    public EnderecoDto(Endereco entidade) {
        id = entidade.getId();
        rua = entidade.getRua();
        numero = entidade.getNumero();
        bairro = entidade.getBairro();
        cidade = entidade.getCidade();
        cep = entidade.getCep();
        estado = entidade.getEstado();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
