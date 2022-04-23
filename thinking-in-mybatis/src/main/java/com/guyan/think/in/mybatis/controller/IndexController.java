package com.guyan.think.in.mybatis.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class IndexController {

    @GetMapping("/index/{name}")
    public Map<String, String> index(@PathVariable String name) {
        HashMap<String, String> map = new HashMap<>();
        map.put("hello", name);
        return map;
    }

}
