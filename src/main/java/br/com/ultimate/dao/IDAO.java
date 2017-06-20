package br.com.ultimate.dao;

import java.util.List;

/**
 * Created by Gustavo on 20/06/2017.
 * Interface DAO
 */
public interface IDAO<T, Integer> {

    public void salvar(T entity);

    public T atualizar(T entity);

    public void remover(Class<T> persistedClass, Integer id);

    public List<T> getList(Class<T> persistedClass);

    public T encontrar(Class<T> persistedClass, Integer id);
}
