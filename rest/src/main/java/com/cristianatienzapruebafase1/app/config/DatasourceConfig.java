package com.cristianatienzapruebafase1.app.config;

import javax.sql.DataSource;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatasourceConfig {
  
    @Value("${datasource.url}")
    private String url;
    
    @Value("${datasource.username}")
    private String username;
    
    @Value("${datasource.password}")
    private String password;
    
    @Value("${datasource.driver-class-name}")
    private String driverClassName;
    
    @Bean
    public DataSource datasource() {
      
        return DataSourceBuilder.create()
          .driverClassName(driverClassName)
          .url(url)
          .username(username)
          .password(password)
          .build(); 
    }
}