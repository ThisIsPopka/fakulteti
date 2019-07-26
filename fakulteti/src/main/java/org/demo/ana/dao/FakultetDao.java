package org.demo.ana.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
 
import org.demo.ana.entity.Fakulteti;
 
public class FakultetDao implements DaoInterface<Fakulteti, String> {
 
    private Session currentSession;
     
    private Transaction currentTransaction;
 
    public FakultetDao() {
    }
 
    public Session openCurrentSession() {
        currentSession = getSessionFactory().openSession();
        return currentSession;
    }
 
    public Session openCurrentSessionwithTransaction() {
        currentSession = getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }
     
    public void closeCurrentSession() {
        currentSession.close();
    }
     
    public void closeCurrentSessionwithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }
     
    private static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
        return sessionFactory;
    }
 
    public Session getCurrentSession() {
        return currentSession;
    }
 
    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }
 
    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }
 
    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }
 
    public void persist(Fakulteti entity) {
        getCurrentSession().save(entity);
    }
 
    public void update(Fakulteti entity) {
        getCurrentSession().update(entity);
    }
 
    public Fakulteti findById(String id) {
    	Fakulteti fakulteti = (Fakulteti) getCurrentSession().get(Fakulteti.class, id);
        return fakulteti; 
    }
 
    public void delete(Fakulteti entity) {
        getCurrentSession().delete(entity);
    }
 
    @SuppressWarnings("unchecked")
    public List<Fakulteti> findAll() {
        List<Fakulteti> fakulteti = (List<Fakulteti>) getCurrentSession().createQuery("from Fakulteti").list();
        return fakulteti;
    }
 
    public void deleteAll() {
        List<Fakulteti> entityList = findAll();
        for (Fakulteti entity : entityList) {
            delete(entity);
        }
    }
}

