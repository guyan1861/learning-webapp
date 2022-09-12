package com.guyan.multiple.datasource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * @Author: GuYan
 * @Time: 2022/9/12 11:34
 * @Description: 模拟数据源模拟读写分离，master负责写，slave负责读
 **/
@Component
public class ManagementCenter {

    @Autowired
    @Qualifier("master")
    private DataSource masterDataSource;

    @Autowired
    @Qualifier("slave")
    private DataSource slaveDataSource;


    public DataSource getMasterDataSource() {
        return masterDataSource;
    }

    public DataSource getSlaveDataSource() {
        return slaveDataSource;
    }
}
