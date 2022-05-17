package com.solvd.laba.dao.jdbcMySQLimpl;

import com.solvd.laba.dao.IProductDAO;
import com.solvd.laba.model.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDAO implements IProductDAO {

    private static final Logger LOGGER = LogManager.getLogger(ProductDAO.class);

    private final Connection connection;

    public ProductDAO(final Connection connection) {
        this.connection = connection;
    }

    @Override
    public void saveEntity(Product product) {
        String query = "INSERT INTO products (id, id_category, name, price, id_description)" +
                " VALUES ((?), (?), (?), (?), (?))";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, product.getId());
            statement.setInt(2, product.getIdCategory());
            statement.setString(3, product.getName());
            statement.setFloat(4, product.getPrice());
            statement.setInt(5, product.getIdDescription());
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }

    }

    @Override
    public Product getEntityById(int id) {
        Product result = new Product();
        String query = "SELECT * FROM products WHERE id = (?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.execute();
            try (ResultSet rs = statement.getResultSet()) {
                while (rs.next()) {
                    result.setId(rs.getInt("id"));
                    result.setIdCategory(rs.getInt("id_category"));
                    result.setName(rs.getString("name"));
                    result.setPrice(rs.getFloat("price"));
                    result.setIdDescription(rs.getInt("id_description"));
                }
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
        return result;
    }

    @Override
    public void updateEntity(Product product) {
        String query = "UPDATE products SET id_category = (?), name = (?), price = (?), id_description = (?) " +
                "WHERE id = (?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, product.getIdCategory());
            statement.setString(2, product.getName());
            statement.setFloat(3, product.getPrice());
            statement.setInt(4, product.getIdDescription());
            statement.setInt(5, product.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
    }

    @Override
    public void removeEntity(int id) {
        String query = "DELETE FROM products WHERE id = (?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
    }
}
