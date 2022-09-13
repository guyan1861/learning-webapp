package com.guyan.multiple.datasource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: GuYan
 * @Time: 2022/9/12 11:25
 * @Description: 配置多个数据源，1主1从
 **/
@Configuration
public class DataSourceConfig {

    @Autowired
    private Environment env;

    @Bean(name = "master")
    public DataSource masterDatasource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("master.datasource.driver-class-name"));
        dataSource.setUrl(env.getProperty("master.datasource.url"));
        dataSource.setUsername(env.getProperty("master.datasource.username"));
        dataSource.setPassword(env.getProperty("master.datasource.password"));
        return dataSource;
    }

    @Bean(name = "slave")
    public DataSource slaveDatasource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("slave.datasource.driver-class-name"));
        dataSource.setUrl(env.getProperty("slave.datasource.url"));
        dataSource.setUsername(env.getProperty("slave.datasource.username"));
        dataSource.setPassword(env.getProperty("slave.datasource.password"));
        return dataSource;
    }

    @Bean
    @Primary
    public DataSource primaryDataSource(@Qualifier("master") DataSource masterDataSource, @Qualifier("slave") DataSource slaveDataSource) {
        RoutingDataSource routingDataSource = new RoutingDataSource();
        Map<Object, Object> map = new HashMap<>();
        map.put("master", masterDataSource);
        map.put("slave", slaveDataSource);
        routingDataSource.setTargetDataSources(map);
        routingDataSource.setDefaultTargetDataSource(masterDataSource);
        return routingDataSource;
    }
}
