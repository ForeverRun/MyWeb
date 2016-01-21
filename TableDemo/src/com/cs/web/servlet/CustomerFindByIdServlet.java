package com.cs.web.servlet;

import com.cs.domain.Customer;
import com.cs.service.CustomerService;
import com.cs.utils.DataSourceUtils;

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
@WebServlet(name = "CustomerFindByIdServlet")
public class CustomerFindByIdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String id = request.getParameter("id");
        CustomerService cs = new CustomerService();
        try {
            Customer co = cs.findById(id);
            request.setAttribute("co",co);
            request.getRequestDispatcher("/customerInfo.jsp").forward(request,response);
            return;
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().write("根据id查询失败");
            return;
        }
    }
}
