package edu.springdata.dao;

import edu.springdata.model.ObjectEdu;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ObjectHibernateDao {

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory(){
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    public void save(ObjectEdu objectEdu){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(objectEdu);
        session.getTransaction().commit();
        session.close();
    }
}
