package br.com.ultimate.dao;

import java.util.List;

/**
 * Created by Gustavo on 23/06/2017.
 */
public interface IDAO<T> {

    public void salvar(T entity);

    public T atualizar(T entity);

    public void remover(T entity);

    public List<T> getList(Class<T> persistedClass);

    public T encontrar(Class<T> persistedClass, Integer id);
}
