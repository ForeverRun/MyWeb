package com.cs.web.servlet;

import com.cs.domain.Customer;
import com.cs.service.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Tang on 2016/1/21.
 */
@WebServlet(name = "CustomerFindAllServlet")
public class CustomerFindAllServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");

        CustomerService csr = new CustomerService();
        try {
            List<Customer> cs = csr.findAll();
            request.setAttribute("cs",cs);

            request.getRequestDispatcher("/showCustomers.jsp").forward(request,response);
            return;
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().write("查询客户信息失败");
            return;
        }
    }
}
