package br.com.dh.clinica.services.exceptions;

public class BancoDeDadosException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public BancoDeDadosException(String msg) {
        super(msg);
    }

}
