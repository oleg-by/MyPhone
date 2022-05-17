package com.solvd.laba.dao.jdbcMySQLimpl;

import com.solvd.laba.dao.IUserDAO;
import com.solvd.laba.enums.AccountType;
import com.solvd.laba.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.*;

public class UserDAO implements IUserDAO {

    private static final Logger LOGGER = LogManager.getLogger(UserDAO.class);

    private final Connection connection;

    public UserDAO(final Connection connection) {
        this.connection = connection;
    }

    @Override
    public void saveEntity(User user) {
        String query = "INSERT INTO users (id, username, email, password, create_time, account_type, birth, age)" +
                " VALUES ((?), (?), (?), (?), (?), (?), (?), (?))";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, user.getId());
            statement.setString(2, user.getUsername());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getPassword());
            statement.setString(5, user.getCreateTime());
            statement.setString(6, user.getAccountType().toString());
            statement.setString(7, user.getBirth());
            statement.setInt(8, user.getAge());
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
    }

    @Override
    public User getEntityById(int id) {
        User result = new User();
        String query = "SELECT * FROM users WHERE id = (?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.execute();
            ResultSet rs = statement.getResultSet();
            while (rs.next()) {
                result.setId(rs.getInt("id"));
                result.setUsername(rs.getString("username"));
                result.setEmail(rs.getString("email"));
                result.setPassword(rs.getString("password"));
                result.setCreateTime(rs.getString("create_time"));
                result.setAccountType(AccountType.valueOf(rs.getString("account_type").toUpperCase()));
                result.setBirth(rs.getString("birth"));
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
        return result;
    }

    @Override
    public void updateEntity(User user) {
        String query = "UPDATE users SET username = (?), email = (?), password = (?), account_type = (?), birth = (?), age = (?)"
                + " WHERE id = (?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getAccountType().toString());
            statement.setString(5, user.getBirth());
            statement.setInt(6, user.getAge());
            statement.setInt(7, user.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
    }

    @Override
    public void removeEntity(int id) {
        String query = "DELETE FROM users WHERE id = (?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
    }
}
