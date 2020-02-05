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
import tables.Login;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import tables.Login_;
/**
 *
 * @author Su
 */
public class LoginDAO {
    
    Session session = null;
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    List<Login> objListaLogin = null;
    CriteriaBuilder builder = null;
    CriteriaQuery<Login> criteriaQuery = null;
    Root<Login> objLogin = null;
    Boolean temDados = false;
    
    public List<Login> getUsuarioSenha(String usuario,String senha){
        try{
        session = sessionFactory.openSession();
        builder = session.getCriteriaBuilder();
        criteriaQuery = builder.createQuery(Login.class);
        objLogin = criteriaQuery.from(Login.class);
        Predicate loginSenhaRestriction = builder.and(
        builder.like(objLogin.get(Login_.LOGIN), usuario),
        builder.like(objLogin.get(Login_.SENHA), senha)
        ); 
        criteriaQuery.where(loginSenhaRestriction);
        objListaLogin = session.createQuery(criteriaQuery).getResultList();
        }catch(HibernateException objError){
        objError.printStackTrace();
        }finally{
         if(session != null) session.close();
        }
       return objListaLogin;
    }
    
    
}
