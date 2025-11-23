package com.poly.dao;

import com.poly.entity.User;
import com.poly.utils.XJPA;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class UserDAO {
    EntityManager em = XJPA.getEntityManager();

    public User findById(String id) {
        return em.find(User.class, id);
    }

    // BÀI 2: Tìm theo ID hoặc Email
    public User findByIdOrEmail(String username) {
        String jpql = "SELECT o FROM User o WHERE o.id = :id OR o.email = :email";
        TypedQuery<User> query = em.createQuery(jpql, User.class);
        query.setParameter("id", username);
        query.setParameter("email", username);

        try {
            return query.getSingleResult();
        } catch (Exception e) {
            return null; // Không tìm thấy
        }
    }
}