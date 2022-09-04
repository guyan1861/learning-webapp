package com.guyan.think.in.mybatis.controller;

import com.guyan.think.in.mybatis.utils.GeneralResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/api")
public class IndexController {

    @GetMapping("/index/{name}")
    public GeneralResult index(@PathVariable String name) {
        HashMap<String, String> map = new HashMap<>();
        map.put("hello", name);
        GeneralResult success = GeneralResult.success("200", "success", map);
        return success;
    }

}
