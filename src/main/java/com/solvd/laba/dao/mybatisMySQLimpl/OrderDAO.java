package com.solvd.laba.dao.mybatisMySQLimpl;

import com.solvd.laba.dao.IOrderDAO;
import com.solvd.laba.model.Order;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class OrderDAO implements IOrderDAO, ISession {

    private static final Logger LOGGER = LogManager.getLogger(OrderDAO.class);

    @Override
    public void saveEntity(Order order) {
        try (SqlSession session = getSqlSession().openSession()) {
            session.insert("saveOrder", order);
            session.commit();
            LOGGER.info("The Order with ID = " + order.getId() + " has been written in DB successfully.");
        } catch (SqlSessionException e) {
            LOGGER.error(e.getMessage());
        }
    }

    @Override
    public Order getEntityById(int id) {
        try (SqlSession session = getSqlSession().openSession()) {
            Order order = session.selectOne("getOrderById", id);
            session.commit();
            return order;
        } catch (SqlSessionException e) {
            LOGGER.error(e.getMessage());
        }
        return null;
    }

    @Override
    public void updateEntity(Order order) {
        try (SqlSession session = getSqlSession().openSession()) {
            session.update("updateOrder", order);
            session.commit();
        } catch (SqlSessionException e) {
            LOGGER.error(e.getMessage());
        }
    }

    @Override
    public void removeEntity(int id) {
        try (SqlSession session = getSqlSession().openSession()) {
            session.delete("removeOrder", id);
            session.commit();
            LOGGER.info("The Order with ID = " + id + " has been removed successfully.");
        } catch (SqlSessionException e) {
            LOGGER.error(e.getMessage());
        }
    }

    @Override
    public List<Order> getOrdersByCustomerId(int idCustomer) {
        try (SqlSession session = getSqlSession().openSession()) {
            List<Order> orders = session.selectList("getOrdersByCustomerId", idCustomer);
            session.commit();
            return orders;
        } catch (SqlSessionException e) {
            LOGGER.error(e.getMessage());
        }
        return null;
    }
}
