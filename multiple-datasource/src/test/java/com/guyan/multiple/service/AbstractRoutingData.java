package com.guyan.multiple.service;

import com.guyan.multiple.config.RoutingDataSourceContext;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @Author: GuYan
 * @Time: 2022/9/13 22:10
 * @Description: TODO
 **/

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class AbstractRoutingData {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void test() throws SQLException {
        List<Map<String, Object>> forList;
        RoutingDataSourceContext master = new RoutingDataSourceContext("master");
        forList = jdbcTemplate.queryForList("select id from t1 limit 15");
        log.info("master 查询数据：{}", forList);
        RoutingDataSourceContext slave = new RoutingDataSourceContext("slave");
        forList = jdbcTemplate.queryForList("select id from t1 limit 15");
        log.info("slave 查询数据：{}", forList);
    }
}
