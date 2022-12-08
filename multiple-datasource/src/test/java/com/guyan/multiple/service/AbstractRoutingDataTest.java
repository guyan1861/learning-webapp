package com.guyan.multiple.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLException;

/**
 * @Author: GuYan
 * @Time: 2022/9/13 22:10
 * @Description: TODO
 **/

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class AbstractRoutingDataTest {

    //@Autowired
    //private JdbcTemplate jdbcTemplate;

    @Test
    public void test() {
        //List<Map<String, Object>> forList;
        //RoutingDataSourceContext master = new RoutingDataSourceContext("master");
        //forList = jdbcTemplate.queryForList("select id from t1 limit 15");
        //log.info("master 查询数据：{}", forList);
        //master.close();
        //RoutingDataSourceContext slave = new RoutingDataSourceContext("slave");
        //forList = jdbcTemplate.queryForList("select id from t1 limit 15");
        //log.info("slave 查询数据：{}", forList);
    }
}
