package br.com.ultimate.dao;

import br.com.ultimate.modelo.Pessoa;
import br.com.ultimate.modelo.Turma;
import br.com.ultimate.util.JPAUtil;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by Gustavo on 23/06/2017.
 */
public class TurmaDAO<T> extends AbstractJDBCDAO<Turma> {

    @Override
    public Turma atualizar(Turma entity) {
        return null;
    }

    @Override
    public void remover(Class<Turma> persistedClass, Integer id) {

    }

    @Override
    public List<Turma> getList(Class<Turma> persistedClass) {
        return null;
    }

    @Override
    public Turma encontrar(Class<Turma> persistedClass, Integer id) {
        return null;
    }
}
