package com.solvd.laba.services;

import com.solvd.laba.dao.IBaseDAO;
import com.solvd.laba.dao.jdbcMySQLimpl.*;

public class JDBCFactory extends AbstractFactory{

    public IBaseDAO getDAO(String entity) {
        switch (entity) {
            case "address":
                return new AddressDAO();
            case "customer":
                return new CustomerDAO();
            case "order":
                return new OrderDAO();
            case "product":
                return new ProductDAO();
            case "user":
                return new UserDAO();
            default:
                return null;
        }
    }

}
