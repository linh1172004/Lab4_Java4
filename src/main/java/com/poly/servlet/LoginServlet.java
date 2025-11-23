package com.poly.servlet;

import com.poly.dao.UserDAO;
import com.poly.entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/lab4/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/pages/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username"); // Nhập ID hoặc Email
        String password = req.getParameter("password");

        UserDAO dao = new UserDAO();
        // Gọi hàm tìm theo ID hoặc Email
        User user = dao.findByIdOrEmail(username);

        if (user == null) {
            req.setAttribute("message", "Sai tên đăng nhập hoặc Email!");
        } else if (!user.getPassword().equals(password)) {
            req.setAttribute("message", "Sai mật khẩu!");
        } else {
            req.setAttribute("message", "Đăng nhập thành công! Xin chào: " + user.getFullname());
        }
        req.getRequestDispatcher("/pages/login.jsp").forward(req, resp);
    }
}