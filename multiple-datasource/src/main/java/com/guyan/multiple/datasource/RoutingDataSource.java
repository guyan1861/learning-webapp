package com.guyan.multiple.datasource;

import com.guyan.multiple.config.RoutingDataSourceContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @Author: GuYan
 * @Time: 2022/9/13 21:28
 * @Description: TODO
 **/
@Slf4j
public class RoutingDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        log.info("数据源切换为：{}", RoutingDataSourceContext.getDatasourceRoutingKey());
        return RoutingDataSourceContext.getDatasourceRoutingKey();
    }
}
