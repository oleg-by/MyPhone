package com.solvd.laba.dao.jdbcMySQLimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class MyConnectionPool {
    private final String dbUrl;
    private final String userName;
    private final String password;
    private final int Size;
    private int connNumber = 0;

    private static final String SQL_TEST_QUERY = "SELECT 1";

    Stack<Connection> freePool = new Stack<>();
    Set<Connection> occupiedPool = new HashSet<>();

    public MyConnectionPool(String dbUrl, String userName, String password, int maxSize) {
        this.dbUrl = dbUrl;
        this.userName = userName;
        this.password = password;
        this.Size = maxSize;
    }

    public synchronized Connection getConnection() throws SQLException {
        Connection connection;
        if (isFull()) {
            throw new SQLException("The connection pool is full.");
        }
        connection = getConnectionFromPool();
        if (connection == null) {
            connection = createNewConnectionForPool();
        }
        connection = makeAvailable(connection);
        return connection;
    }

    public synchronized void returnConnection(Connection connection) throws SQLException {
        if (connection == null) {
            throw new NullPointerException();
        }
        if (!occupiedPool.remove(connection)) {
            throw new SQLException("The connection has already returned or it's not for this pool.");
        }
        freePool.push(connection);
    }

    private synchronized boolean isFull() {
        return ((freePool.size() == 0) && (connNumber >= Size));
    }

    private Connection createNewConnectionForPool() throws SQLException {
        Connection connection = DriverManager.getConnection(dbUrl, userName, password);
        connNumber++;
        occupiedPool.add(connection);
        return connection;
    }

    private Connection getConnectionFromPool() {
        Connection connection = null;
        if (freePool.size() > 0) {
            connection = freePool.pop();
            occupiedPool.add(connection);
        }
        return connection;
    }

    private Connection makeAvailable(Connection connection) throws SQLException {
        if (isConnectionAvailable(connection)) {
            return connection;
        }
        occupiedPool.remove(connection);
        connNumber--;
        connection.close();
        connection = DriverManager.getConnection(dbUrl, userName, password);
        occupiedPool.add(connection);
        connNumber++;
        return connection;
    }

    private boolean isConnectionAvailable(Connection connection) {
        try (Statement st = connection.createStatement()) {
            st.executeQuery(SQL_TEST_QUERY);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
}
