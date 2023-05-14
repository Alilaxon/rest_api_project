package com.epam.esm.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:app.properties")
public class JdbcConfiguration {

    @Bean
    DataSource dataSource(@Value("${user}") String user,
                          @Value("${password}") String password,
                          @Value("${driver}") String className,
                          @Value("${url}") String connectionUrl
    ) {
        HikariConfig config = new HikariConfig();

        config.setDriverClassName(className);
        config.setJdbcUrl(connectionUrl);
        config.setUsername(user);
        config.setPassword(password);

        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        return new HikariDataSource(config);
    }
}
