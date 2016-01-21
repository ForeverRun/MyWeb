package com.cs.web.servlet;

import com.cs.service.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Tang on 2016/1/21.
 */
@WebServlet(name = "DelByIdServlet")
public class DelByIdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/heml;charset=utf-8");

        String id = request.getParameter("id");
        CustomerService cs = new CustomerService();
        try {
            cs.delById(id);
            response.sendRedirect(request.getContextPath()+"/findAll");
            return;
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().write("删除失败");
            return;
        }
    }
}
