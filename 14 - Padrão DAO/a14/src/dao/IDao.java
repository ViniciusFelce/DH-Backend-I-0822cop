package dao;

// Aqui estamos utilizando um generics T
public interface IDao<T> {

    T salvar(T t);

}
