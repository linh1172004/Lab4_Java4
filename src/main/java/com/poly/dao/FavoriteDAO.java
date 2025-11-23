package com.poly.dao;

import com.poly.entity.Favorite;
import com.poly.utils.XJPA;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class FavoriteDAO {
    EntityManager em = XJPA.getEntityManager();

    // Hàm lấy tất cả lượt thích (Dùng cho Bài 4)
    public List<Favorite> findAll() {
        String jpql = "SELECT o FROM Favorite o";
        TypedQuery<Favorite> query = em.createQuery(jpql, Favorite.class);
        return query.getResultList();
    }
}