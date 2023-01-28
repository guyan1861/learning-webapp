package com.guyan.think.in.mybatis.controller.user;

import com.guyan.think.in.mybatis.pojo.User;
import com.guyan.think.in.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/userController")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user/putUser")
    public Map<String, User> getUser(User user) {
        HashMap<String, User> map = new HashMap<>();
        Integer integer = userService.putUser(user);
        if (integer > 0) {
            map.put("success", user);
        } else {
            map.put("error", user);
        }
        return map;
    }
}
