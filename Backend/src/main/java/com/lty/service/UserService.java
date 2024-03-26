package com.lty.service;

import com.lty.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lty.utils.Result;

/**
* @author 71947
* @description 针对表【news_user】的数据库操作Service
* @createDate 2024-03-25 19:09:17
*/
public interface UserService extends IService<User> {
    Result login(User user);
    Result getUserInfo(String token);
    Result checkUserName(String username);
    Result register(User user);
    Result checkLogin(String token);
}
