package com.poly.dao;

import com.poly.utils.XJPA;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class ShareDAO {
    EntityManager em = XJPA.getEntityManager();

    // BÀI 4: Thống kê chia sẻ (Title, Count, MinDate, MaxDate)
    // Kết quả trả về là một mảng Object[] vì nó tổng hợp nhiều cột
    public List<Object[]> reportShare() {
        String jpql = "SELECT o.video.title, count(o), min(o.shareDate), max(o.shareDate) " +
                "FROM Share o GROUP BY o.video.title";
        TypedQuery<Object[]> query = em.createQuery(jpql, Object[].class);
        return query.getResultList();
    }
}