package com.solvd.laba.dao.jdbcMySQLimpl;

import com.solvd.laba.dao.IAddressDAO;
import com.solvd.laba.model.Address;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddressDAO implements IAddressDAO {

    private static final Logger LOGGER = LogManager.getLogger(AddressDAO.class);

    private MyConnectionPool pool = MyConnectionPool.getInstance();

    public AddressDAO() {

    }

    @Override
    public void saveEntity(Address address) {
        Connection connection = pool.getConnection();
        String query = "INSERT INTO addresses (id, country, city, street, building_number, corp, apt, floor)" +
                " VALUES ((?), (?), (?), (?), (?), (?), (?), (?))";
        try (PreparedStatement pr = connection.prepareStatement(query)) {
            pr.setInt(1, address.getId());
            pr.setString(2, address.getCountry());
            pr.setString(3, address.getCity());
            pr.setString(4, address.getStreet());
            pr.setInt(5, address.getBuildingNumber());
            pr.setInt(6, address.getCorp());
            pr.setInt(7, address.getApt());
            pr.setInt(8, address.getFloor());
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
    public Address getEntityById(int id) {
        Connection connection = pool.getConnection();
        Address result = new Address();
        String query = "SELECT * FROM addresses WHERE id = (?)";
        try (PreparedStatement pr = connection.prepareStatement(query)) {
            pr.setInt(1, id);
            pr.execute();
            try (ResultSet rs = pr.getResultSet()) {
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
    public void updateEntity(Address address) {
        Connection connection = pool.getConnection();
        String query = "UPDATE addresses SET country = (?), city = (?), street = (?), building_number = (?), corp = (?), apt = (?), floor = (?)"
                + " WHERE id = (?)";
        try (PreparedStatement pr = connection.prepareStatement(query)) {
            pr.setString(1, address.getCountry());
            pr.setString(2, address.getCity());
            pr.setString(3, address.getStreet());
            pr.setInt(4, address.getBuildingNumber());
            pr.setInt(5, address.getCorp());
            pr.setInt(6, address.getApt());
            pr.setInt(7, address.getFloor());
            pr.setInt(8, address.getId());
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
        String query = "DELETE FROM addresses WHERE id = (?)";
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
    public List<Address> getAddressesByCity(String city) {
        Connection connection = pool.getConnection();
        List<Address> resultList = new ArrayList<>();
        String query = "SELECT * FROM addresses WHERE city = (?)";
        try (PreparedStatement pr = connection.prepareStatement(query)) {
            pr.setString(1, city);
            pr.execute();
            try (ResultSet rs = pr.getResultSet()) {
                while (rs.next()) {
                    Address address = new Address();
                    address.setId(rs.getInt("id"));
                    address.setCountry(rs.getString("country"));
                    address.setCity(rs.getString("city"));
                    address.setStreet(rs.getString("street"));
                    address.setBuildingNumber(rs.getInt("building_number"));
                    address.setCorp(rs.getInt("corp"));
                    address.setApt(rs.getInt("apt"));
                    address.setFloor(rs.getInt("floor"));
                    resultList.add(address);
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
        return resultList;
    }
}
