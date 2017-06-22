package br.com.neutrino.dao;

import br.com.neutrino.util.HibernateUtil;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author David Nogueira
 * @param <Entidade>
 */
public class GenericoDAO<Entidade> {

    private Class<Entidade> classe;

    @SuppressWarnings("unchecked")
	public GenericoDAO() {
        this.classe = (Class<Entidade>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public void salvar(Entidade entidade) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = sessao.beginTransaction();
            sessao.save(entidade);
            tx.commit();
        } catch (RuntimeException erro) {
            if (tx != null) {
                tx.rollback();
            }
            throw erro;
        } finally {
            sessao.flush();
            sessao.close();
        }

    }

    public void editar(Entidade entidade) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = sessao.beginTransaction();
            sessao.update(entidade);
            tx.commit();
        } catch (RuntimeException erro) {
            if (tx != null) {
                tx.rollback();
            }
            throw erro;
        } finally {
            sessao.flush();
            sessao.close();
        }

    }

    public void excluir(Entidade entidade) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = sessao.beginTransaction();
            sessao.delete(entidade);
            tx.commit();
        } catch (RuntimeException erro) {
            if (tx != null) {
                tx.rollback();
            }
            throw erro;
        } finally {
            sessao.flush();
            sessao.close();
        }
    }

    @SuppressWarnings("unchecked")
	public List<Entidade> listar() {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        try {
            Criteria consulta = sessao.createCriteria(classe).addOrder(Order.asc("nome"));
            return consulta.list();

        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.flush();
            sessao.close();
        }
    }

    @SuppressWarnings("unchecked")
	public Entidade buscar(Long id) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        try {
            Criteria consulta = sessao.createCriteria(classe);
            consulta.add(Restrictions.idEq(id));
            return (Entidade) consulta.uniqueResult();

        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.flush();
            sessao.close();
        }
    }

    @SuppressWarnings("unchecked")
	public List<Entidade> buscarPorNome(String nome) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        try {
            Criteria consulta = sessao.createCriteria(classe).addOrder(Order.asc("nome"));
            return consulta.add(Restrictions.ilike("nome", nome + "%")).list();

        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.flush();
            sessao.close();
        }
    }
    
    public void merge(Entidade entidade) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = sessao.beginTransaction();
            sessao.merge(entidade);
            tx.commit();
        } catch (RuntimeException erro) {
            if (tx != null) {
                tx.rollback();
            }
            throw erro;
        } finally {
            sessao.close();
        }

    }
}
