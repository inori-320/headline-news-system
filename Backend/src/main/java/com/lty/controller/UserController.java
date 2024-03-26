package com.lty.controller;

import com.lty.pojo.User;
import com.lty.service.UserService;
import com.lty.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author lty
 */
@RestController
@RequestMapping("user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("login")
    public Result login(@RequestBody User user){
        return userService.login(user);
    }

    @GetMapping("getUserInfo")
    public Result getUserInfo(@RequestHeader String token){
        return userService.getUserInfo(token);
    }

    @PostMapping("checkUserName")
    public Result checkUserName(String username){
        return userService.checkUserName(username);
    }

    @PostMapping("regist")
    public Result register(@RequestBody User user){
        return userService.register(user);
    }
}
