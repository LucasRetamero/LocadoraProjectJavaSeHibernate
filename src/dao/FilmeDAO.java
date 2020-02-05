package dao;

import connection.HibernateUtil;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import tables.Filme;
import tables.Filme_;

public class FilmeDAO {

    //Salvar dados
    public int saveFilmeDAO(Filme objFilme) {
        Session session = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        int idFilme = 0;
        try {
            session = sessionFactory.openSession();
            Transaction objTransaction = session.beginTransaction();
            idFilme = (Integer) session.save(objFilme);
            objTransaction.commit();
        } catch (HibernateException objError) {
            objError.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return idFilme;
    }

    //Editar dados
    public Boolean editFilmeDAO(Filme objFilme) {
        Session session = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Boolean idFilme = false;
        try {
            session = sessionFactory.openSession();
            Transaction objTransaction = session.beginTransaction();
            session.update(objFilme);
            objTransaction.commit();
            idFilme = true;
        } catch (HibernateException objError) {
            objError.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return idFilme;
    }

    //Editar dados
    public Boolean removeFilmeDAO(Filme objFilme) {
        Session session = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Boolean idFilme = false;
        try {
            session = sessionFactory.openSession();
            Transaction objTransaction = session.beginTransaction();
            session.remove(objFilme);
            objTransaction.commit();
            idFilme = true;
        } catch (HibernateException objError) {
            objError.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return idFilme;
    }

    //Buscar todos os filmes
    public List<Filme> getAllFilmeDAO() {
        List<Filme> objListaFilme = null;
        Session session = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        try {
            session = sessionFactory.openSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Filme> criteriaQuery = builder.createQuery(Filme.class);
            criteriaQuery.from(Filme.class);
            objListaFilme = session.createQuery(criteriaQuery).getResultList();

        } catch (HibernateException objError) {
            objError.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return objListaFilme;
    }

    //Buscar pela iniciais do titulo
    public List<Filme> getAllByTitleFilmeDAO(String txtPesquisa) {
        List<Filme> objListaFilme = null;
        Session session = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try {
            session = sessionFactory.openSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Filme> criteriaQuery = builder.createQuery(Filme.class);
            Root<Filme> name = criteriaQuery.from(Filme.class);
            Predicate nameRestriction = builder.and(
                    builder.like(name.get(Filme_.titulo), txtPesquisa + "%")
            );
            criteriaQuery.where(nameRestriction);
            objListaFilme = session.createQuery(criteriaQuery).getResultList();

        } catch (HibernateException objError) {
            objError.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return objListaFilme;
    }
    
    //Buscar filme pelo titulo completo
    public List<Filme> getAllByTitleFullFilmeDAO(String txtPesquisaParam) {
        List<Filme> objListaFilme = null;
        Session session = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try {
            session = sessionFactory.openSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Filme> criteriaQuery = builder.createQuery(Filme.class);
            Root<Filme> name = criteriaQuery.from(Filme.class);
            Predicate nameRestriction = builder.and(
                    builder.like(name.get(Filme_.titulo), "%" + txtPesquisaParam + "%")
            );
            criteriaQuery.where(nameRestriction);
            objListaFilme = session.createQuery(criteriaQuery).getResultList();

        } catch (HibernateException objError) {
            objError.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return objListaFilme;
    }
}
