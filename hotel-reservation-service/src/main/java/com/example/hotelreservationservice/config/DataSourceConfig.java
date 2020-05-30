package com.example.hotelreservationservice.config;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Configuration
public class DataSourceConfig {

    @Value("${secrets.path.dataSourceDriverClassName}")
    private String dataSourceDriverClassNamePath;

    @Value("${secrets.path.dataSourceUrl}")
    private String dataSourceUrlPath;

    @Value("${secrets.path.dataSourceUsername}")
    private String dataSourceUsernamePath;

    @Value("${secrets.path.dataSourcePassword}")
    private String dataSourcePasswordPath;

    @Bean
    public DataSource getDataSource() throws IOException {
        String driverClassName = FileUtils.readFileToString(new File(dataSourceDriverClassNamePath), StandardCharsets.UTF_8);
        String url = FileUtils.readFileToString(new File(dataSourceUrlPath), StandardCharsets.UTF_8);
        String username = FileUtils.readFileToString(new File(dataSourceUsernamePath), StandardCharsets.UTF_8);
        String password = FileUtils.readFileToString(new File(dataSourcePasswordPath), StandardCharsets.UTF_8);

        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(driverClassName);
        dataSourceBuilder.url(url);
        dataSourceBuilder.username(username);
        dataSourceBuilder.password(password);
        return dataSourceBuilder.build();
    }

}