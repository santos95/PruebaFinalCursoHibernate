package com.prueba.santosapp.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Value("${usr}")
    private String usr;
    @Value("${clv}")
    private String clv;
    @Bean
    public DataSource dataSource(){
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();

        dataSourceBuilder.url("jdbc:sqlserver://localhost;databaseName=PRUEBA;trustServerCertificate=true");
        //dataSourceBuilder.username("sa");
        //dataSourceBuilder.password("sqlserver");
        dataSourceBuilder.username(usr);
        dataSourceBuilder.password(clv);
        return dataSourceBuilder.build();
    }

}
