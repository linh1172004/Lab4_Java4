package com.poly.servlet;

import com.poly.dao.UserDAO;
import com.poly.entity.User;
import org.apache.commons.beanutils.BeanUtils;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({
        "/user/crud/index",
        "/user/crud/create",
        "/user/crud/update",
        "/user/crud/delete",
        "/user/crud/reset",
        "/user/crud/edit/*"
})
public class UserCRUDServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDAO dao = new UserDAO();
        User form = new User();
        String message = "";

        try {
            BeanUtils.populate(form, req.getParameterMap());
        } catch (Exception e) {
            e.printStackTrace();
        }

        String path = req.getServletPath();

        if (path.contains("edit")) {
            String id = req.getPathInfo().substring(1);
            form = dao.findById(id);
            message = "Đang chỉnh sửa: " + id;
        } else if (path.contains("create")) {
            try {
                dao.create(form);
                message = "Tạo mới thành công!";
                form = new User();
            } catch (Exception e) {
                message = "Lỗi tạo mới: " + e.getMessage();
            }
        } else if (path.contains("update")) {
            try {
                dao.update(form);
                message = "Cập nhật thành công!";
            } catch (Exception e) {
                message = "Lỗi cập nhật: " + e.getMessage();
            }
        } else if (path.contains("delete")) {
            try {
                dao.remove(form.getId());
                message = "Xóa thành công!";
                form = new User();
            } catch (Exception e) {
                message = "Lỗi xóa: " + e.getMessage();
            }
        } else if (path.contains("reset")) {
            form = new User();
        }

        req.setAttribute("user", form);
        req.setAttribute("items", dao.findAll());
        req.setAttribute("message", message);
        req.getRequestDispatcher("/pages/user-crud.jsp").forward(req, resp);
    }
}