package com.solvd.laba.dao.jdbcMySQLimpl;

import com.solvd.laba.dao.IProductDAO;
import com.solvd.laba.model.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements IProductDAO {

    private static final Logger LOGGER = LogManager.getLogger(ProductDAO.class);

    private MyConnectionPool pool = MyConnectionPool.getInstance();

    public ProductDAO() {

    }

    @Override
    public void saveEntity(Product product) {
        Connection connection = pool.getConnection();
        String query = "INSERT INTO products (id, id_category, name, price, id_description)" +
                " VALUES ((?), (?), (?), (?), (?))";
        try (PreparedStatement pr = connection.prepareStatement(query)) {
            pr.setInt(1, product.getId());
            pr.setInt(2, product.getIdCategory());
            pr.setString(3, product.getName());
            pr.setFloat(4, product.getPrice());
            pr.setInt(5, product.getIdDescription());
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
    public Product getEntityById(int id) {
        Connection connection = pool.getConnection();
        Product result = new Product();
        String query = "SELECT * FROM products WHERE id = (?)";
        try (PreparedStatement pr = connection.prepareStatement(query)) {
            pr.setInt(1, id);
            pr.execute();
            try (ResultSet rs = pr.getResultSet()) {
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
    public void updateEntity(Product product) {
        Connection connection = pool.getConnection();
        String query = "UPDATE products SET id_category = (?), name = (?), price = (?), id_description = (?) " +
                "WHERE id = (?)";
        try (PreparedStatement pr = connection.prepareStatement(query)) {
            pr.setInt(1, product.getIdCategory());
            pr.setString(2, product.getName());
            pr.setFloat(3, product.getPrice());
            pr.setInt(4, product.getIdDescription());
            pr.setInt(5, product.getId());
            pr.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            try {
                if (connection != null) pool.releaseConnection(connection);
            } catch (SQLException e) {
                LOGGER.error(e.getMessage());
            }
        }
    }

    @Override
    public void removeEntity(int id) {
        Connection connection = pool.getConnection();
        String query = "DELETE FROM products WHERE id = (?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            try {
                if (connection != null) pool.releaseConnection(connection);
            } catch (SQLException e) {
                LOGGER.error(e.getMessage());
            }
        }
    }

    @Override
    public List<Product> getAll() {
        Connection connection = pool.getConnection();
        List<Product> resultList = new ArrayList<>();
        String query = "SELECT * FROM products";
        try (PreparedStatement pr = connection.prepareStatement(query)) {
            pr.execute();
            try (ResultSet rs = pr.getResultSet()) {
                while (rs.next()) {
                    Product product = new Product();
                    product.setId(rs.getInt("id"));
                    product.setIdCategory(rs.getInt("id_category"));
                    product.setName(rs.getString("name"));
                    product.setPrice(rs.getFloat("price"));
                    product.setIdDescription(rs.getInt("id_description"));
                    resultList.add(product);
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

    @Override
    public List<Product> getProductsByCategory(int idCategory) {
        Connection connection = pool.getConnection();
        List<Product> resultList = new ArrayList<>();
        String query = "SELECT * FROM products WHERE id_category = (?)";
        try (PreparedStatement pr = connection.prepareStatement(query)) {
            pr.setInt(1, idCategory);
            pr.execute();
            try (ResultSet rs = pr.getResultSet()) {
                while (rs.next()) {
                    Product product = new Product();
                    product.setId(rs.getInt("id"));
                    product.setIdCategory(rs.getInt("id_category"));
                    product.setName(rs.getString("name"));
                    product.setPrice(rs.getFloat("price"));
                    product.setIdDescription(rs.getInt("id_description"));
                    resultList.add(product);
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
