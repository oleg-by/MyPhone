package com.solvd.laba.dao.jdbcMySQLimpl;

import com.solvd.laba.dao.IUserDAO;
import com.solvd.laba.enums.AccountType;
import com.solvd.laba.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IUserDAO {

    private static final Logger LOGGER = LogManager.getLogger(UserDAO.class);

    private MyConnectionPool pool = MyConnectionPool.getInstance();

    public UserDAO() {

    }

    @Override
    public void saveEntity(User user) {
        Connection connection = pool.getConnection();
        String query = "INSERT INTO users (id, username, email, password, create_time, account_type, birth, age)" +
                " VALUES ((?), (?), (?), (?), (?), (?), (?), (?))";
        try (PreparedStatement pr = connection.prepareStatement(query)) {
            pr.setInt(1, user.getId());
            pr.setString(2, user.getUsername());
            pr.setString(3, user.getEmail());
            pr.setString(4, user.getPassword());
            pr.setString(5, user.getCreateTime());
            pr.setString(6, user.getAccountType().toString());
            pr.setString(7, user.getBirth());
            pr.setInt(8, user.getAge());
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
    public User getEntityById(int id) {
        Connection connection = pool.getConnection();
        User result = new User();
        String query = "SELECT * FROM users WHERE id = (?)";
        try (PreparedStatement pr = connection.prepareStatement(query)) {
            pr.setInt(1, id);
            pr.execute();
            try (ResultSet rs = pr.getResultSet()) {
                while (rs.next()) {
                    result.setId(rs.getInt("id"));
                    result.setUsername(rs.getString("username"));
                    result.setEmail(rs.getString("email"));
                    result.setPassword(rs.getString("password"));
                    result.setCreateTime(rs.getString("create_time"));
                    result.setAccountType(AccountType.valueOf(rs.getString("account_type").toUpperCase()));
                    result.setBirth(rs.getString("birth"));
                }
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            try {
                if (connection != null) pool.releaseConnection(connection);
            } catch (SQLException e) {
                LOGGER.error(e.getMessage());
            }
        }
        return result;
    }

    @Override
    public void updateEntity(User user) {
        Connection connection = pool.getConnection();
        String query = "UPDATE users SET username = (?), email = (?), password = (?), account_type = (?), birth = (?), age = (?)"
                + " WHERE id = (?)";
        try (PreparedStatement pr = connection.prepareStatement(query)) {
            pr.setString(1, user.getUsername());
            pr.setString(2, user.getEmail());
            pr.setString(3, user.getPassword());
            pr.setString(4, user.getAccountType().toString());
            pr.setString(5, user.getBirth());
            pr.setInt(6, user.getAge());
            pr.setInt(7, user.getId());
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
        String query = "DELETE FROM users WHERE id = (?)";
        try (PreparedStatement pr = connection.prepareStatement(query)) {
            pr.setInt(1, id);
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
    public List<User> getAll() {
        Connection connection = pool.getConnection();
        List<User> resultList = new ArrayList<>();
        String query = "SELECT * FROM users";
        try (PreparedStatement pr = connection.prepareStatement(query)) {
            pr.execute();
            try (ResultSet rs = pr.getResultSet()) {
                while (rs.next()) {
                    User user = new User();
                    user.setId(rs.getInt("id"));
                    user.setUsername(rs.getString("username"));
                    user.setEmail(rs.getString("email"));
                    user.setPassword(rs.getString("password"));
                    user.setCreateTime(rs.getString("create_time"));
                    user.setAccountType(AccountType.valueOf(rs.getString("account_type").toUpperCase()));
                    user.setBirth(rs.getString("birth"));
                    resultList.add(user);
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

    @Override
    public User getUserByEmail(String email) {
        Connection connection = pool.getConnection();
        User result = new User();
        String query = "SELECT * FROM users WHERE email = (?)";
        try (PreparedStatement pr = connection.prepareStatement(query)) {
            pr.setString(1, email);
            pr.execute();
            try (ResultSet rs = pr.getResultSet()) {
                while (rs.next()) {
                    result.setId(rs.getInt("id"));
                    result.setUsername(rs.getString("username"));
                    result.setEmail(rs.getString("email"));
                    result.setPassword(rs.getString("password"));
                    result.setCreateTime(rs.getString("create_time"));
                    result.setAccountType(AccountType.valueOf(rs.getString("account_type").toUpperCase()));
                    result.setBirth(rs.getString("birth"));
                }
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        } finally {
            try {
                if (connection != null) pool.releaseConnection(connection);
            } catch (SQLException e) {
                LOGGER.error(e.getMessage());
            }
        }
        return result;
    }
}
