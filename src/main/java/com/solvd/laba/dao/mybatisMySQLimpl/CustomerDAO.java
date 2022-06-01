package com.solvd.laba.dao.mybatisMySQLimpl;

import com.solvd.laba.dao.ICustomerDAO;
import com.solvd.laba.model.Customer;
import org.apache.ibatis.session.SqlSession;

public class CustomerDAO implements ICustomerDAO, ISession {
    @Override
    public void saveEntity(Customer customer) {
        try(SqlSession session = getSqlSession().openSession()) {
            session.insert("saveEntity", customer);
            session.commit();
        }
    }

    @Override
    public Customer getEntityById(int id) {
        ICustomerDAO customerDAO;
        try (SqlSession session = getSqlSession().openSession()) {
            customerDAO = session.getMapper(ICustomerDAO.class);
            session.commit();
            return customerDAO.getEntityById(id);
        }
    }

    @Override
    public void updateEntity(Customer customer) {
        try(SqlSession session = getSqlSession().openSession()) {
            session.update("updateEntity", customer);
            session.commit();
        }
    }

    @Override
    public void removeEntity(int id) {
        try(SqlSession session = getSqlSession().openSession()) {
            session.delete("removeEntity", id);
            session.commit();
        }
    }

    @Override
    public Customer getCustomerByUserId(int idUser) {
        ICustomerDAO customerDAO;
        try (SqlSession session = getSqlSession().openSession()) {
            customerDAO = session.getMapper(ICustomerDAO.class);
            session.commit();
            return customerDAO.getCustomerByUserId(idUser);
        }
    }
}
