package com.solvd.laba.dao.mybatisMySQLimpl;

import com.solvd.laba.dao.ICustomerDAO;
import com.solvd.laba.model.Customer;
import com.solvd.laba.model.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class CustomerDAO implements ICustomerDAO, ISession {

    private static final Logger LOGGER = LogManager.getLogger(CustomerDAO.class);

    @Override
    public void saveEntity(Customer customer) {
        try (SqlSession session = getSqlSession().openSession()) {
            session.insert("saveCustomer", customer);
            session.commit();
            LOGGER.info("The Customer with ID = " + customer.getId() + " has been written in DB successfully.");
        } catch (SqlSessionException e) {
            LOGGER.error(e.getMessage());
        }
    }

    @Override
    public Customer getEntityById(int id) {
        try (SqlSession session = getSqlSession().openSession()) {
            Customer customer = session.selectOne("getCustomerById", id);
            session.commit();
            return customer;
        } catch (SqlSessionException e) {
            LOGGER.error(e.getMessage());
        }
        return null;
    }

    @Override
    public void updateEntity(Customer customer) {
        try (SqlSession session = getSqlSession().openSession()) {
            session.update("updateCustomer", customer);
            session.commit();
        } catch (SqlSessionException e) {
            LOGGER.error(e.getMessage());
        }
    }

    @Override
    public void removeEntity(int id) {
        try (SqlSession session = getSqlSession().openSession()) {
            session.delete("removeCustomer", id);
            session.commit();
            LOGGER.info("The Customer with ID = " + id + " has been removed successfully.");
        } catch (SqlSessionException e) {
            LOGGER.error(e.getMessage());
        }
    }

    @Override
    public List<Customer> getAll() {
        try (SqlSession session = getSqlSession().openSession()) {
            List<Customer> customers = session.selectList("getAllCustomers");
            session.commit();
            return customers;
        } catch (SqlSessionException e) {
            LOGGER.error(e.getMessage());
        }
        return null;
    }

    @Override
    public Customer getCustomerByUserId(int idUser) {
        try (SqlSession session = getSqlSession().openSession()) {
            Customer customer = session.selectOne("getCustomerByUserId", idUser);
            session.commit();
            return customer;
        } catch (SqlSessionException e) {
            LOGGER.error(e.getMessage());
        }
        return null;
    }
}
