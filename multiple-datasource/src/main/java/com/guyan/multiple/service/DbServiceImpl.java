package com.guyan.multiple.service;

import com.guyan.multiple.annotation.ReadAnnotation;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: GuYan
 * @Time: 2022/9/12 11:57
 * @Description: TODO
 **/
@Service
public class DbServiceImpl implements DbService {

    @SneakyThrows
    @Override
    public void insertOne(DataSource dataSource, String sql) {
        System.out.println(dataSource.getConnection().getMetaData().getURL());
        try (Connection conn = dataSource.getConnection(); Statement statement = conn.createStatement()) {
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @SneakyThrows
    @Override
    @ReadAnnotation
    public List<Map<String, Object>> query(DataSource dataSource, String sql) {
        System.out.println(dataSource.getConnection().getMetaData().getURL());
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            List<Map<String, Object>> entities = new ArrayList<>();
            conn = dataSource.getConnection();
            statement = conn.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Map<String, Object> data = new HashMap<>(3);
                data.put("id", resultSet.getLong("id"));
                entities.add(data);
            }
            return entities;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(resultSet != null) {
                resultSet.close();
            }
            if(statement != null) {
                statement.close();
            }
            if(conn != null) {
                conn.close();
            }
        }
        return null;
    }
}
