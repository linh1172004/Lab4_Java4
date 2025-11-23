package com.poly.dao;

import com.poly.entity.Video;
import com.poly.utils.XJPA;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class VideoDAO {
    EntityManager em = XJPA.getEntityManager();

    public List<Video> findAll() {
        return em.createQuery("SELECT o FROM Video o", Video.class).getResultList();
    }

    // BÀI 3: Tìm video theo từ khóa trong title
    public List<Video> findByKeyword(String keyword) {
        String jpql = "SELECT o FROM Video o WHERE o.title LIKE :keyword";
        TypedQuery<Video> query = em.createQuery(jpql, Video.class);
        query.setParameter("keyword", "%" + keyword + "%");
        return query.getResultList();
    }

    // BÀI 1: Tìm video được thích
    public List<Video> findFavorites() {
        String jpql = "SELECT o FROM Video o WHERE o.favorites IS NOT EMPTY";
        return em.createQuery(jpql, Video.class).getResultList();
    }
}