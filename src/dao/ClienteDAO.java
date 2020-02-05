/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 https://www.youtube.com/watch?v=Iy4iLFjoC-A
 */
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
import tables.Cliente;
import tables.Cliente_;

/**
 *
 * @author Su
 */
public class ClienteDAO {

    //Salvar cliente
    public int saveClienteDAO(Cliente objCliente) {
        Session session = null;
        Integer idClienteInserido = 0;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        try {
            session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            idClienteInserido = (Integer) session.save(objCliente);
            transaction.commit();
        } catch (HibernateException objError) {
            objError.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return idClienteInserido;
    }

    //Editar dados do cliente
    public Boolean updateClienteDAO(Cliente objUpdate) {
        Session session = null;
        Boolean idClienteInserido = false;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        try {
            session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.update(objUpdate);
            transaction.commit();
            idClienteInserido = true;
        } catch (HibernateException obj) {
            obj.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return idClienteInserido;
    }

    //Removar Cliente
    public Boolean removeClienteDAO(Cliente objCliente) {
        Session session = null;
        Boolean retorno = false;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        try {
            session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.remove(objCliente);
            transaction.commit();
            retorno = true;

        } catch (HibernateException objError) {
            objError.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return retorno;
    }

    //Buscar todos os clientes
    public List<Cliente> getAllClientesDAO() {
        List<Cliente> objListaCliente = null;
        Session session = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        try {
            session = sessionFactory.openSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Cliente> criteriaQuery = builder.createQuery(Cliente.class);
            criteriaQuery.from(Cliente.class);
            objListaCliente = session.createQuery(criteriaQuery).getResultList();

        } catch (HibernateException objError) {
            objError.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return objListaCliente;
    }

    //Buscar cliente pelo nome
    public List<Cliente> getAllByNameClienteDAO(String txtPesquisa) {
        List<Cliente> objListaCliente = null;
        Session session = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try {
            session = sessionFactory.openSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Cliente> criteriaQuery = builder.createQuery(Cliente.class);
            Root<Cliente> name = criteriaQuery.from(Cliente.class);
            Predicate nameRestriction = builder.and(
                    builder.like(name.get(Cliente_.nome), txtPesquisa + "%")
            );
            criteriaQuery.where(nameRestriction);
            objListaCliente = session.createQuery(criteriaQuery).getResultList();

        } catch (HibernateException objError) {
            objError.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return objListaCliente;
    }
    
     //Buscar cliente pelo nome completo
    public List<Cliente> getAllByNameFullClienteDAO(String txtPesquisa) {
        List<Cliente> objListaCliente = null;
        Session session = null;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try {
            session = sessionFactory.openSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Cliente> criteriaQuery = builder.createQuery(Cliente.class);
            Root<Cliente> name = criteriaQuery.from(Cliente.class);
            Predicate nameRestriction = builder.and(
                    builder.like(name.get(Cliente_.nome),"%" + txtPesquisa + "%")
            );
            criteriaQuery.where(nameRestriction);
            objListaCliente = session.createQuery(criteriaQuery).getResultList();

        } catch (HibernateException objError) {
            objError.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return objListaCliente;
    }

}

/* select a.id_aluguel,a.data_aluguel,a.data_devolucao,b.nome from tbl_aluguel as a 
inner join tbl_cliente as b on a.fk_id_cliente = b.id_cliente*/
