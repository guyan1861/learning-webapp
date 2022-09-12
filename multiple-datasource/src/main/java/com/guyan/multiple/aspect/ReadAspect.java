package com.guyan.multiple.aspect;

import com.guyan.multiple.datasource.ManagementCenter;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @Author: GuYan
 * @Time: 2022/9/12 11:46
 * @Description: TODO
 **/
@Aspect
@Component
public class ReadAspect {

    @Autowired
    private ManagementCenter managementCenter;

    @Pointcut("@annotation(com.guyan.multiple.annotation.ReadAnnotation)")
    public void read() {
    }

    /**
     * 获取参数，改变 DataSource 为 slave 节点
     * @param point
     * @return
     * @throws Throwable
     */
    @Around("read()")
    public List<Map<String, Object>> setDatabaseSource(ProceedingJoinPoint point) throws Throwable {
        System.out.println("data source change......");
        Object[] argv = point.getArgs();
        argv[0] = managementCenter.getSlaveDataSource();
        return (List<Map<String, Object>>) point.proceed(argv);
    }
}
