package com.etf.nbp.database;

import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Service
public class DatabaseService {
    private final String username = System.getenv("DB_USERNAME");

    private final String password = System.getenv("DB_PASSWORD");

    private final String hostname = System.getenv("DB_HOSTNAME");

    private final String sid = System.getenv("DB_SID");

    private Connection connection;
    public void startConnection() {
        connection = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            String url = "jdbc:oracle:thin:@" + hostname + "/" + sid;
            connection = DriverManager.getConnection(url, username, password);
            connection.setAutoCommit(false);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        if (connection == null) {
            startConnection();
//            throw new IllegalStateException("Connection has not been established.");
        }
        return connection;
    }

    @PreDestroy
    public void disconnect() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                connection = null;
            }
        }
    }
}
