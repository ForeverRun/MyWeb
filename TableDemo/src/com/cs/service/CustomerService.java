package com.cs.service;

import com.cs.dao.CustomerDao;
import com.cs.domain.Customer;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Tang on 2016/1/21.
 */
public class CustomerService {
    CustomerDao csd = new CustomerDao();
    //查询所有顾客信息
    public List<Customer> findAll() throws SQLException {
       return csd.findAllCustomer();
    }

    public void delById(String id) throws SQLException {
        csd.delByIdItem(id);
    }

    public Customer findById(String id) throws SQLException {
      return csd.findById(id);
    }

    public void updateItem(Customer cs) throws SQLException {
        csd.updateItem(cs);
    }
}
