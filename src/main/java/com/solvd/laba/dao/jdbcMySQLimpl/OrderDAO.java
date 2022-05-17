package com.solvd.laba.dao.jdbcMySQLimpl;

import com.solvd.laba.dao.IOrderDAO;
import com.solvd.laba.model.Order;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDAO implements IOrderDAO {

    private static final Logger LOGGER = LogManager.getLogger(OrderDAO.class);

    private final Connection connection;

    public OrderDAO(final Connection connection) {
        this.connection = connection;
    }

    @Override
    public void saveEntity(Order order) {
        String query = "INSERT INTO orders (id, id_customer, id_product, count, unit_price, id_delivery, id_payment)" +
                " VALUES ((?), (?), (?), (?), (?), (?), (?))";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, order.getId());
            statement.setInt(2, order.getIdCustomer());
            statement.setInt(3, order.getIdProduct());
            statement.setInt(4, order.getCount());
            statement.setFloat(5, order.getUnitPrice());
            statement.setInt(6, order.getIdDelivery());
            statement.setInt(7, order.getIdPayment());
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
    }

    @Override
    public Order getEntityById(int id) {
        Order result = new Order();
        String query = "SELECT * FROM orders WHERE id = (?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.execute();
            try (ResultSet rs = statement.getResultSet()) {
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
        }
        return result;
    }

    @Override
    public void updateEntity(Order order) {
        String query = "UPDATE orders SET id_customer = (?), id_product = (?), count = (?), unit_price = (?), " +
                "id_delivery = (?), id_payment = (?) WHERE id = (?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, order.getIdCustomer());
            statement.setInt(2, order.getIdProduct());
            statement.setInt(3, order.getCount());
            statement.setFloat(4, order.getUnitPrice());
            statement.setInt(5, order.getIdDelivery());
            statement.setInt(6, order.getIdPayment());
            statement.setInt(7, order.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
    }

    @Override
    public void removeEntity(int id) {
        String query = "DELETE FROM orders WHERE id = (?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
    }
}
