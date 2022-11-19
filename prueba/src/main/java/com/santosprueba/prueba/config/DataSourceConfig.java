package com.santosprueba.prueba.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {
    @Bean
    public DataSource dataSource(){
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();

//        dataSourceBuilder.url("jdbc:sqlserver://192.168.10.136;databaseName=PRUEBA;trustServerCertificate=true");
        dataSourceBuilder.url("jdbc:sqlserver://localhost;databaseName=PRUEBA;trustServerCertificate=true");
        dataSourceBuilder.username("test");
        dataSourceBuilder.password("test1234");
//        dataSourceBuilder.username("sa");
//        dataSourceBuilder.password("sqlserver");
        return dataSourceBuilder.build();
    }
}
