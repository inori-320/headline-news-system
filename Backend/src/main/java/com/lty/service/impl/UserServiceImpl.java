package com.lty.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lty.pojo.User;
import com.lty.service.UserService;
import com.lty.mapper.UserMapper;
import com.lty.utils.JwtHelper;
import com.lty.utils.MD5Util;
import com.lty.utils.Result;
import com.lty.utils.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
* @author 71947
* @description 针对表【news_user】的数据库操作Service实现
* @createDate 2024-03-25 19:09:17
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{
    @Autowired
    private JwtHelper jwt;
    @Autowired
    private UserMapper mapper;
    @Override
    public Result login(User user) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername, user.getUsername());
        User loginUser = mapper.selectOne(queryWrapper);
        if(loginUser != null){
            if(!StringUtils.isEmpty(user.getUserPwd())
                    && MD5Util.encrypt(user.getUserPwd()).equals(loginUser.getUserPwd())){
                String token = jwt.createToken((long) loginUser.getUid());
                Map<String, String> data = new HashMap<>();
                data.put("token", token);
                return Result.ok(data);
            } else {
                return Result.build(null, ResultCodeEnum.PASSWORD_ERROR);
            }
        }
        return Result.build(null, ResultCodeEnum.USERNAME_ERROR);
    }

    @Override
    public Result getUserInfo(String token) {
        boolean expiration = jwt.isExpiration(token);
        if(!expiration){
            int userId = jwt.getUserId(token).intValue();
            User user = mapper.selectById(userId);
            user.setUserPwd("");
            Map<String, User> data = new HashMap<>();
            data.put("loginUser", user);
            return Result.ok(data);
        }
        return Result.build(null, ResultCodeEnum.NOT_LOGIN);
    }

    @Override
    public Result checkUserName(String username){
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername, username);
        Long cnt = mapper.selectCount(queryWrapper);
        if(cnt == 0){
            return Result.ok(null);
        }
        return Result.build(null, ResultCodeEnum.USERNAME_USED);
    }

    @Override
    public Result register(User user) {
        user.setUserPwd(MD5Util.encrypt(user.getUserPwd()));
        Result result = checkUserName(user.getUsername());
        if(result.getCode() == 200){
            mapper.insert(user);
            return Result.ok(null);
        }
        return Result.build(null, ResultCodeEnum.USERNAME_USED);
    }
}




