package com.solvd.laba.dao.jdbcMySQLimpl;

import com.solvd.laba.dao.IOrderDAO;
import com.solvd.laba.model.Order;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO implements IOrderDAO {

    private static final Logger LOGGER = LogManager.getLogger(OrderDAO.class);

    private MyConnectionPool pool = MyConnectionPool.getInstance();

    public OrderDAO() {

    }

    @Override
    public void saveEntity(Order order) {
        Connection connection = pool.getConnection();
        String query = "INSERT INTO orders (id, id_customer, id_product, count, unit_price, id_delivery, id_payment)" +
                " VALUES ((?), (?), (?), (?), (?), (?), (?))";
        try (PreparedStatement pr = connection.prepareStatement(query)) {
            pr.setInt(1, order.getId());
            pr.setInt(2, order.getIdCustomer());
            pr.setInt(3, order.getIdProduct());
            pr.setInt(4, order.getCount());
            pr.setFloat(5, order.getUnitPrice());
            pr.setInt(6, order.getIdDelivery());
            pr.setInt(7, order.getIdPayment());
            pr.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            if(connection != null) {
                try {
                    pool.releaseConnection(connection);
                } catch (SQLException e) {
                    LOGGER.error(e.getMessage());
                }
            }
        }
    }

    @Override
    public Order getEntityById(int id) {
        Connection connection = pool.getConnection();
        Order result = new Order();
        String query = "SELECT * FROM orders WHERE id = (?)";
        try (PreparedStatement pr = connection.prepareStatement(query)) {
            pr.setInt(1, id);
            pr.execute();
            try (ResultSet rs = pr.getResultSet()) {
                while (rs.next()) {
                    result.setId(rs.getInt("id"));
                    result.setIdCustomer(rs.getInt("id_customer"));
                    result.setIdProduct(rs.getInt("id_product"));
                    result.setCount(rs.getInt("count"));
                    result.setUnitPrice(rs.getFloat("unit_price"));
                    result.setIdDelivery(rs.getInt("id_delivery"));
                    result.setIdPayment(rs.getInt("id_payment"));
                }
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            if(connection != null) {
                try {
                    pool.releaseConnection(connection);
                } catch (SQLException e) {
                    LOGGER.error(e.getMessage());
                }
            }
        }
        return result;
    }

    @Override
    public void updateEntity(Order order) {
        Connection connection = pool.getConnection();
        String query = "UPDATE orders SET id_customer = (?), id_product = (?), count = (?), unit_price = (?), " +
                "id_delivery = (?), id_payment = (?) WHERE id = (?)";
        try (PreparedStatement pr = connection.prepareStatement(query)) {
            pr.setInt(1, order.getIdCustomer());
            pr.setInt(2, order.getIdProduct());
            pr.setInt(3, order.getCount());
            pr.setFloat(4, order.getUnitPrice());
            pr.setInt(5, order.getIdDelivery());
            pr.setInt(6, order.getIdPayment());
            pr.setInt(7, order.getId());
            pr.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            if(connection != null) {
                try {
                    pool.releaseConnection(connection);
                } catch (SQLException e) {
                    LOGGER.error(e.getMessage());
                }
            }
        }
    }

    @Override
    public void removeEntity(int id) {
        Connection connection = pool.getConnection();
        String query = "DELETE FROM orders WHERE id = (?)";
        try (PreparedStatement pr = connection.prepareStatement(query)) {
            pr.setInt(1, id);
            pr.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            if(connection != null) {
                try {
                    pool.releaseConnection(connection);
                } catch (SQLException e) {
                    LOGGER.error(e.getMessage());
                }
            }
        }
    }

    @Override
    public List<Order> getOrdersByCustomerId(int idCustomer) {
        Connection connection = pool.getConnection();
        List<Order> resultList = new ArrayList<>();
        String query = "SELECT * FROM orders WHERE id_customer = (?)";
        try (PreparedStatement pr = connection.prepareStatement(query)) {
            pr.setInt(1, idCustomer);
            pr.execute();
            try (ResultSet rs = pr.getResultSet()) {
                while (rs.next()) {
                    Order order = new Order();
                    order.setId(rs.getInt("id"));
                    order.setIdCustomer(rs.getInt("id_customer"));
                    order.setIdProduct(rs.getInt("id_product"));
                    order.setCount(rs.getInt("count"));
                    order.setUnitPrice(rs.getFloat("unit_price"));
                    order.setIdDelivery(rs.getInt("id_delivery"));
                    order.setIdPayment(rs.getInt("id_payment"));
                    resultList.add(order);
                }
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            if(connection != null) {
                try {
                    pool.releaseConnection(connection);
                } catch (SQLException e) {
                    LOGGER.error(e.getMessage());
                }
            }
        }
        return resultList;
    }
}
