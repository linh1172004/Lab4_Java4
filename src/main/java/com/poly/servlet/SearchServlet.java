package com.poly.servlet;

import com.poly.dao.VideoDAO;
import com.poly.entity.Video;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/lab4/search")
public class SearchServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String keyword = req.getParameter("keyword");
        VideoDAO dao = new VideoDAO();
        List<Video> list;

        if (keyword != null && !keyword.isEmpty()) {
            list = dao.findByKeyword(keyword); // Tìm theo từ khóa
        } else {
            list = dao.findAll(); // Hiện tất cả nếu không tìm
        }

        req.setAttribute("items", list);
        req.getRequestDispatcher("/pages/search.jsp").forward(req, resp);
    }
}