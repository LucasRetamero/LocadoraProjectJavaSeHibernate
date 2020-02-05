package dao;

import connection.HibernateUtil;
import controller.AluguelTableController;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ListJoin;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import tables.Aluguel;
import tables.Aluguel_;

public class AluguelDAO {

    //Executar query
    public Boolean executeQueryAluguelDAO(Aluguel aluguelParam, int typeParam) {
        Session session = null;
        Boolean returnAction = false;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        try {
            session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            switch (typeParam) {
                case 1: //Salvar dados 
                    session.save(aluguelParam);
                    returnAction = true;
                    break;
                case 2: //Editar dados
                    session.update(aluguelParam);
                    returnAction = true;
                    break;
                case 3: //Removar dados
                    session.remove(aluguelParam);
                    returnAction = true;
                    break;
            }
            transaction.commit();
        } catch (HibernateException objError) {
            objError.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return returnAction;
    }

    //Buscar todos os clientes
    public List<Aluguel> getAllAlugueisDAO() {
        List<Aluguel> objLista = null;
        Session session = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        try {
            session = sessionFactory.openSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Aluguel> criteriaQuery = builder.createQuery(Aluguel.class);
            criteriaQuery.from(Aluguel.class);
            objLista = session.createQuery(criteriaQuery).getResultList();
        } catch (HibernateException objError) {
            objError.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return objLista;
    }

    //Buscar aluguel pelo chave estrangeira cliente
    public List<Aluguel> getAllByFkClienteDAO(int fkClienteParam) {
        List<Aluguel> objLista = null;
        Session session = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try {
            session = sessionFactory.openSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Aluguel> criteriaQuery = builder.createQuery(Aluguel.class);
            Root<Aluguel> root = criteriaQuery.from(Aluguel.class);
            criteriaQuery.where(builder.equal(root.get("fk_id_cliente"), fkClienteParam));
            objLista = session.createQuery(criteriaQuery).getResultList();

        } catch (HibernateException objError) {
            objError.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return objLista;
    }

    //Buscar aluguel pelo chave estrangeira Filme
    public List<Aluguel> getAllByFkFilmeDAO(int fkFilmeParam) {
        List<Aluguel> objLista = null;
        Session session = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try {
            session = sessionFactory.openSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Aluguel> criteriaQuery = builder.createQuery(Aluguel.class);
            Root<Aluguel> root = criteriaQuery.from(Aluguel.class);
            criteriaQuery.where(builder.equal(root.get("fk_id_filme"), fkFilmeParam));
            objLista = session.createQuery(criteriaQuery).getResultList();

        } catch (HibernateException objError) {
            objError.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return objLista;
    }
    
    //Buscar aluguel pelo data de aluguel
     public List<Aluguel> getAllByDataAluguelDAO(java.sql.Date dtParam) {
        List<Aluguel> objLista = null;
        Session session = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try {
            session = sessionFactory.openSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Aluguel> criteriaQuery = builder.createQuery(Aluguel.class);
            Root<Aluguel> root = criteriaQuery.from(Aluguel.class);
            criteriaQuery.where(builder.equal(root.get("data_aluguel"), dtParam));
            objLista = session.createQuery(criteriaQuery).getResultList();
        } catch (HibernateException objError) {
            objError.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return objLista;
    }
     
    //Buscar aluguel pelo data de devolução
    public List<Aluguel> getAllByDataDevolucaoDAO(java.sql.Date dtParam) {
        List<Aluguel> objLista = null;
        Session session = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try {
            session = sessionFactory.openSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Aluguel> criteriaQuery = builder.createQuery(Aluguel.class);
            Root<Aluguel> root = criteriaQuery.from(Aluguel.class);
            criteriaQuery.where(builder.equal(root.get("data_aluguel"), dtParam));
            objLista = session.createQuery(criteriaQuery).getResultList();
        } catch (HibernateException objError) {
            objError.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return objLista;
    }

}


/*select a.id_aluguel,a.data_aluguel,a.data_devolucao,b.nome,c.titulo from tbl_aluguel as a 
inner join tbl_cliente as b on a.fk_id_cliente = b.id_cliente
inner join tbl_filme as c on a.fk_id_filme = c.id_filme*/
