package com.cs.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import javax.sql.DataSource;


import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Tang on 2016/1/21.
 */
public class DataSourceUtils {
    private static ComboPooledDataSource dataSource = new ComboPooledDataSource();
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
    public static DataSource getDatasource(){
        return  dataSource;
    }
}
