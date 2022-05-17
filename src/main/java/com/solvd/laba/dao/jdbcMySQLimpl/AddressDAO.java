package com.solvd.laba.dao.jdbcMySQLimpl;

import com.solvd.laba.dao.IAddressDAO;
import com.solvd.laba.model.Address;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddressDAO implements IAddressDAO {

    private static final Logger LOGGER = LogManager.getLogger(AddressDAO.class);

    private final Connection connection;

    public AddressDAO(final Connection connection) {
        this.connection = connection;
    }

    @Override
    public void saveEntity(Address address) {
        String query = "INSERT INTO addresses (id, country, city, street, building_number, corp, apt, floor)" +
                " VALUES ((?), (?), (?), (?), (?), (?), (?), (?))";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, address.getId());
            statement.setString(2, address.getCountry());
            statement.setString(3, address.getCity());
            statement.setString(4, address.getStreet());
            statement.setInt(5, address.getBuildingNumber());
            statement.setInt(6, address.getCorp());
            statement.setInt(7, address.getApt());
            statement.setInt(8, address.getFloor());
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
    }

    @Override
    public Address getEntityById(int id) {
        Address result = new Address();
        String query = "SELECT * FROM addresses WHERE id = (?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.execute();
            ResultSet rs = statement.getResultSet();
            while (rs.next()) {
                result.setId(rs.getInt("id"));
                result.setCountry(rs.getString("country"));
                result.setCity(rs.getString("city"));
                result.setStreet(rs.getString("street"));
                result.setBuildingNumber(rs.getInt("building_number"));
                result.setCorp(rs.getInt("corp"));
                result.setApt(rs.getInt("apt"));
                result.setFloor(rs.getInt("floor"));
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
        return result;
    }

    @Override
    public void updateEntity(Address address) {
        String query = "UPDATE addresses SET country = (?), city = (?), street = (?), building_number = (?), corp = (?), apt = (?), floor = (?)"
                + " WHERE id = (?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, address.getCountry());
            statement.setString(2, address.getCity());
            statement.setString(3, address.getStreet());
            statement.setInt(4, address.getBuildingNumber());
            statement.setInt(5, address.getCorp());
            statement.setInt(6, address.getApt());
            statement.setInt(7, address.getFloor());
            statement.setInt(8, address.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
    }

    @Override
    public void removeEntity(int id) {
        String query = "DELETE FROM addresses WHERE id = (?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
    }
}
