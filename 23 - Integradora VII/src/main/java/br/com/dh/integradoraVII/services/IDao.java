package br.com.dh.integradoraVII.services;

import java.util.List;

public interface IDao<T> {

    T salvar(T t);
    List<T> buscarTodos();
    String excluir(Integer id);

}
