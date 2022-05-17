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

    private final Connection connection;

    public CustomerDAO(final Connection connection) {
        this.connection = connection;
    }

    @Override
    public void saveEntity(Customer customer) {
        String query = "INSERT INTO customers (id, first_name, last_name, phone_number, id_address_c, id_user)" +
                " VALUES ((?), (?), (?), (?), (?), (?))";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, customer.getId());
            statement.setString(2, customer.getFirstName());
            statement.setString(3, customer.getLastName());
            statement.setLong(4, customer.getPhoneNumber());
            statement.setInt(5, customer.getIdAddressC());
            statement.setInt(6, customer.getIdUser());
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
    }

    @Override
    public Customer getEntityById(int id) {
        Customer result = new Customer();
        String query = "SELECT * FROM customers WHERE id = (?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.execute();
            ResultSet rs = statement.getResultSet();
            while (rs.next()) {
                result.setId(rs.getInt("id"));
                result.setFirstName(rs.getString("first_name"));
                result.setLastName(rs.getString("last_name"));
                result.setPhoneNumber(rs.getLong("phone_number"));
                result.setIdAddressC(rs.getInt("id_address_c"));
                result.setIdUser(rs.getInt("id_user"));
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
        return result;
    }

    @Override
    public void updateEntity(Customer customer) {
        String query = "UPDATE customers SET first_name = (?), last_name = (?), phone_number = (?), id_address_c = (?), id_user = (?)"
                + " WHERE id = (?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, customer.getFirstName());
            statement.setString(2, customer.getLastName());
            statement.setLong(3, customer.getPhoneNumber());
            statement.setInt(4, customer.getIdAddressC());
            statement.setInt(5, customer.getIdUser());
            statement.setInt(6, customer.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
    }

    @Override
    public void removeEntity(int id) {
        String query = "DELETE FROM customers WHERE id = (?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
    }
}
