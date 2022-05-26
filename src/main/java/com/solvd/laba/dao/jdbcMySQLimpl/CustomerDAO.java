package com.solvd.laba.dao.jdbcMySQLimpl;

import com.solvd.laba.dao.ICustomerDAO;
import com.solvd.laba.model.Customer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDAO implements ICustomerDAO {

    private static final Logger LOGGER = LogManager.getLogger(CustomerDAO.class);

    private MyConnectionPool pool = MyConnectionPool.getInstance();

    public CustomerDAO() {

    }

    @Override
    public void saveEntity(Customer customer) {
        Connection connection = pool.getConnection();
        String query = "INSERT INTO customers (id, first_name, last_name, phone_number, id_address_c, id_user)" +
                " VALUES ((?), (?), (?), (?), (?), (?))";
        try (PreparedStatement pr = connection.prepareStatement(query)) {
            pr.setInt(1, customer.getId());
            pr.setString(2, customer.getFirstName());
            pr.setString(3, customer.getLastName());
            pr.setLong(4, customer.getPhoneNumber());
            pr.setInt(5, customer.getIdAddressC());
            pr.setInt(6, customer.getIdUser());
            pr.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            if (connection != null) {
                try {
                    pool.releaseConnection(connection);
                } catch (SQLException e) {
                    LOGGER.error(e.getMessage());
                }
            }
        }
    }

    @Override
    public Customer getEntityById(int id) {
        Connection connection = pool.getConnection();
        Customer result = new Customer();
        String query = "SELECT * FROM customers WHERE id = (?)";
        try (PreparedStatement pr = connection.prepareStatement(query)) {
            pr.setInt(1, id);
            pr.execute();
            try (ResultSet rs = pr.getResultSet()) {
                while (rs.next()) {
                    result.setId(rs.getInt("id"));
                    result.setFirstName(rs.getString("first_name"));
                    result.setLastName(rs.getString("last_name"));
                    result.setPhoneNumber(rs.getLong("phone_number"));
                    result.setIdAddressC(rs.getInt("id_address_c"));
                    result.setIdUser(rs.getInt("id_user"));
                }
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            if (connection != null) {
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
    public void updateEntity(Customer customer) {
        Connection connection = pool.getConnection();
        String query = "UPDATE customers SET first_name = (?), last_name = (?), phone_number = (?), id_address_c = (?), id_user = (?)"
                + " WHERE id = (?)";
        try (PreparedStatement pr = connection.prepareStatement(query)) {
            pr.setString(1, customer.getFirstName());
            pr.setString(2, customer.getLastName());
            pr.setLong(3, customer.getPhoneNumber());
            pr.setInt(4, customer.getIdAddressC());
            pr.setInt(5, customer.getIdUser());
            pr.setInt(6, customer.getId());
            pr.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            if (connection != null) {
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
        String query = "DELETE FROM customers WHERE id = (?)";
        try (PreparedStatement pr = connection.prepareStatement(query)) {
            pr.setInt(1, id);
            pr.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            if (connection != null) {
                try {
                    pool.releaseConnection(connection);
                } catch (SQLException e) {
                    LOGGER.error(e.getMessage());
                }
            }
        }
    }

    @Override
    public Customer getCustomerByUserId(int idUser) {
        Connection connection = pool.getConnection();
        Customer result = new Customer();
        String query = "SELECT * FROM customers WHERE id_user = (?)";
        try (PreparedStatement pr = connection.prepareStatement(query)) {
            pr.setInt(1, idUser);
            pr.execute();
            try (ResultSet rs = pr.getResultSet()) {
                while (rs.next()) {
                    result.setId(rs.getInt("id"));
                    result.setFirstName(rs.getString("first_name"));
                    result.setLastName(rs.getString("last_name"));
                    result.setPhoneNumber(rs.getLong("phone_number"));
                    result.setIdAddressC(rs.getInt("id_address_c"));
                    result.setIdUser(rs.getInt("id_user"));
                }
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            if (connection != null) {
                try {
                    pool.releaseConnection(connection);
                } catch (SQLException e) {
                    LOGGER.error(e.getMessage());
                }
            }
        }
        return result;
    }
}
