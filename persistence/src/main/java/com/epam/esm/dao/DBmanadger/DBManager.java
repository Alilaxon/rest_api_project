package com.epam.esm.dao.DBmanadger;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DBManager {

    private static DBManager instance;
    private final HikariDataSource dataSource;

    static Properties properties = new Properties();

    static {

        try {
            properties.load(DBManager.class.getResourceAsStream("/app.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private DBManager() {
        HikariConfig config = new HikariConfig();

        config.setDriverClassName(properties.getProperty("driver"));

        config.setJdbcUrl(properties.getProperty("url"));
        config.setUsername(properties.getProperty("user"));
        config.setPassword(properties.getProperty("password"));


        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        dataSource = new HikariDataSource(config);

    }


    public static synchronized DBManager getInstance() {
        if (instance == null) {
            try {
                instance = new DBManager();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return instance;
    }


    public Connection getConnection() throws SQLException {

        return dataSource.getConnection();
    }


}
