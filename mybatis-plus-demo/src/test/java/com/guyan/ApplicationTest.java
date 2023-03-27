package com.guyan;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.guyan.entity.po.UserPO;
import com.guyan.mapper.UserMapper;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class ApplicationTest {

    @Resource
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<UserPO> userList = userMapper.selectList(null);
        Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }

    @Test
    public void testSave() {
        System.out.println("---------------insert into method test");
        UserPO userPO = new UserPO();
        userPO.setAge(18);
        userPO.setEmail("test6@baomidou.com");
        userPO.setId(6L);
        userPO.setName("王达瓦");
        userMapper.insert(userPO);
    }

    @Test
    public void testSelectById() {
        System.out.println("---------------SelectById method test");
        UserPO userPO = userMapper.selectById(6L);
        System.out.println(userPO);
    }
}
