/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import connection.HibernateUtil;
import org.hibernate.HibernateException;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import tables.Cliente;
import tables.Genero;
import tables.Genero_;
import tables.Login;
import tables.Login_;

/**
 *
 * @author Su
 */
public class GeneroDAO {
      
    //Buscar todos os clientes
    public List<Genero> getAllGeneroDAO(){
     List<Genero> objListaGenero = null;     
     Session session = null;
     SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
     
     try{
       session = sessionFactory.openSession();
       CriteriaBuilder builder = session.getCriteriaBuilder();
       CriteriaQuery<Genero> criteriaQuery = builder.createQuery(Genero.class);
       criteriaQuery.from(Genero.class);
       objListaGenero = session.createQuery(criteriaQuery).getResultList();
  
     }catch(HibernateException objError){
       objError.printStackTrace();
     }finally{
      if(session != null) session.close(); 
      }
     
     return objListaGenero;
    }
}
