package com.guyan.multiple.service;

import com.guyan.multiple.datasource.ManagementCenter;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
class DbServiceImplTest {

    @Autowired
    private DbService dbService;

    @Autowired
    private ManagementCenter managementCenter;

    @Test
    //@Transactional
    void insertOne() {
        //String sql = "insert into t1 (id) VALUES (14),(15),(16);";
        //// 使用主库 master
        //dbService.insertOne(managementCenter.getMasterDataSource(), sql);
        //
        //sql = "select id from t1 limit 15;";
        //// 使用从库 slave1
        //List<Map<String, Object>> entities = dbService.query(managementCenter.getMasterDataSource(), sql);
        //for (Map item : entities) {
        //    System.out.println(item.toString());
        //}
    }

    @Test
    void query() {

    }
}