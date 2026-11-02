package com.ch12.jdbctemplate_mysqlcustomdatasource.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.init.DataSourceScriptDatabaseInitializer;
import org.springframework.boot.sql.init.DatabaseInitializationMode;
import org.springframework.boot.sql.init.DatabaseInitializationSettings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.Collections;

@Configuration
public class ProjectConfig {

    @Value("${custom.datasource.url}")
    private String jdbcUrl;

    @Value("${custom.datasource.username}")
    private String userName;

    @Value("${custom.datasource.password}")
    private String password;

    @Value("${custom.postgresql.datasource.url}")
    private String postgresqlJdbcUrl;

    @Value("${custom.postgresql.datasource.username}")
    private String postgresqlUserName;

    @Value("${custom.postgresql.datasource.password}")
    private String postgresqlPassword;

    @Bean("mysqlDataSource")
    public DataSource mysqlDataSource(){
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);

        dataSource.setConnectionTimeout(1000);

        return dataSource;
    }

    @Bean("postgresqlDataSource")
    public DataSource postgresqlDataSource(){
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(postgresqlJdbcUrl);
        dataSource.setUsername(postgresqlUserName);
        dataSource.setPassword(postgresqlPassword);

        return dataSource;
    }

    @Bean("mysqlJdbcTemplate")
    public JdbcTemplate mysqlJdbcTemplate(@Qualifier("mysqlDataSource") DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

    @Bean("postgresqlJdbcTemplate")
    public JdbcTemplate postgresqlJdbcTemplate(@Qualifier("postgresqlDataSource") DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public DataSourceScriptDatabaseInitializer dataSourceScriptMysqlDatabaseInitializer(
            @Qualifier("mysqlDataSource") DataSource dataSource
    ){
        DatabaseInitializationSettings settings = new DatabaseInitializationSettings();
        settings.setSchemaLocations(Collections.singletonList("classpath:mysql-schema.sql"));
        settings.setMode(DatabaseInitializationMode.ALWAYS);

        return new DataSourceScriptDatabaseInitializer(dataSource, settings);
    }

    @Bean
    public DataSourceScriptDatabaseInitializer dataSourceScriptPostgresDatabaseInitializer(
            @Qualifier("postgresqlDataSource") DataSource dataSource){
        DatabaseInitializationSettings settings = new DatabaseInitializationSettings();
        settings.setSchemaLocations(Collections.singletonList("classpath:postgres-schema.sql"));
        settings.setMode(DatabaseInitializationMode.ALWAYS);

        return new DataSourceScriptDatabaseInitializer(dataSource, settings);
    }
}
