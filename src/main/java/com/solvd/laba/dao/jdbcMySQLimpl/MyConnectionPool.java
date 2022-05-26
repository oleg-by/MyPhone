package com.solvd.laba.dao.jdbcMySQLimpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;

public class MyConnectionPool {

    private static final Logger LOGGER = LogManager.getLogger(MyConnectionPool.class);
    private static MyConnectionPool instance = null;
    private static final int INITIAL_POOL_SIZE = 5;

    private MyConnectionPool() {
    }

    private static List<Connection> freeConnections = new ArrayList<>();
    private static List<Connection> usedConnections = new ArrayList<>();

    public static synchronized MyConnectionPool getInstance() {
        if (instance == null) {
            instance = new MyConnectionPool();
            create();
        }
        return instance;
    }

    public static void create() {
        Properties p = new Properties();
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/db.properties");
            p.load(fileInputStream);
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            LOGGER.error(e.getMessage());
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }

        String url = p.getProperty("jdbc.url");
        String userName = p.getProperty("jdbc.username");
        String password = p.getProperty("jdbc.password");

        for (int i = 0; i < INITIAL_POOL_SIZE; i++) {
            freeConnections.add(createConnection(url, userName, password));
        }
    }

    public synchronized Connection getConnection() {
        Connection connection = freeConnections.remove(freeConnections.size() - 1);
        usedConnections.add(connection);
        return connection;
    }

    public synchronized void releaseConnection(Connection connection) throws SQLException {
        if (connection != null) {
            if (usedConnections.remove(connection)) {
                freeConnections.add(connection);
            } else {
                throw new SQLException("The connection has already returned or it's not for this pool.");
            }
        }
    }

    private static Connection createConnection(String url, String user, String password) {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
        return null;
    }

    public int getSize() {
        return freeConnections.size() + usedConnections.size();
    }

}
