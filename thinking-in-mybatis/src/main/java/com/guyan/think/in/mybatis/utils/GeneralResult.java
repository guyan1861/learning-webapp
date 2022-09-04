package com.guyan.think.in.mybatis.utils;

import com.alibaba.druid.util.StringUtils;
import lombok.Builder;
import lombok.Data;

/**
 * @Author: GuYan
 * @Time: 2022/9/4 09:49
 * @Description: TODO
 **/

@Data
@Builder
public class GeneralResult {

    private String code;

    private String message;

    private Object result;

    public static GeneralResult success(String code, String message, Object result) {
        GeneralResult generalResult = null;
        if(!StringUtils.isEmpty(code) && !StringUtils.isEmpty(message)) {
            generalResult = GeneralResult.builder().code("200").message(message).result(result).build();
        }
        return generalResult;
    }

    public static GeneralResult error(String code, String message, Object result) {
        GeneralResult generalResult = null;
        if(!StringUtils.isEmpty(code) && !StringUtils.isEmpty(message)) {
            generalResult = GeneralResult.builder().code("200").message(message).result(result).build();
        }
        return generalResult;
    }
}
