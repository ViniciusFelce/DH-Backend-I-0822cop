package dao;

import java.util.List;

public interface IDao<T> {

    T salvar(T t);
    List<T> buscarTodos();

}
