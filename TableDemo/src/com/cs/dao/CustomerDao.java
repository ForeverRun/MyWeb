package com.cs.dao;

import com.cs.domain.Customer;
import com.cs.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Tang on 2016/1/21.
 */
public class CustomerDao {
    public List<Customer> findAllCustomer() throws SQLException {
        String sql = "select * from customer";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDatasource());
      return runner.query(sql,new BeanListHandler<Customer>(Customer.class));
    }

    public void delByIdItem(String id) throws SQLException {
        String sql = "delete from customer where id = ?";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDatasource());
         runner.update(sql,id);
    }

    public Customer findById(String id) throws SQLException {
        String sql = "select * from customer where id=?";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDatasource());
        return runner.query(sql,new BeanHandler<Customer>(Customer.class),id);
    }

    public void updateItem(Customer cs) throws SQLException {
        String sql ="update customer set name=?,gender=?,birthday=?,cellphone=?,email=?,preference=?,type=?,description=? where id=?";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDatasource());
        runner.update(sql,cs.getName(),cs.getGender(),cs.getBirthday(),
                cs.getCellphone(),cs.getEmail(),cs.getPreference(),
                cs.getType(), cs.getDescription(),cs.getId());
    }
}
