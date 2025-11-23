package com.poly.servlet;

import com.poly.dao.ShareDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/lab4/report")
public class ReportServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ShareDAO dao = new ShareDAO();
        // Lấy danh sách mảng Object[]
        List<Object[]> list = dao.reportShare();

        req.setAttribute("items", list);
        req.getRequestDispatcher("/pages/report.jsp").forward(req, resp);
    }
}