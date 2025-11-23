package com.poly.dao;

import com.poly.entity.User;
import com.poly.utils.XJPA;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class UserDAO {
    EntityManager em = XJPA.getEntityManager();

    @Override
    protected void finalize() throws Throwable {
        if(em.isOpen()) em.close();
        super.finalize();
    }

    public void create(User user) {
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.persist(user);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
            throw new RuntimeException(e);
        }
    }

    public void update(User user) {
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.merge(user);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
            throw new RuntimeException(e);
        }
    }

    public void remove(String id) {
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            User user = this.findById(id);
            if (user != null) {
                em.remove(user);
            }
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
            throw new RuntimeException(e);
        }
    }

    public User findById(String id) {
        return em.find(User.class, id);
    }

    public List<User> findAll() {
        String jpql = "SELECT o FROM User o";
        TypedQuery<User> query = em.createQuery(jpql, User.class);
        return query.getResultList();
    }
}