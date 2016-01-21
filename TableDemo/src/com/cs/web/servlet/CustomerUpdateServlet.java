package com.cs.web.servlet;

import com.cs.domain.Customer;
import com.cs.service.CustomerService;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by Tang on 2016/1/21.
 */
@WebServlet(name = "CustomerUpdateServlet")
public class CustomerUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        Customer cs = new Customer();

        DateConverter dc = new DateConverter(); // 这是一个日期类型转换器.
        dc.setPattern("yyyy-MM-dd");
        try {
            ConvertUtils.register(dc, Date.class);
            BeanUtils.populate(cs,request.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(cs);
        CustomerService cts = new CustomerService();
        try {
            cts.updateItem(cs);
            request.getRequestDispatcher("/findAll").forward(request,response);
            return;
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().write("修改失败");
            return;
        }
    }
}
