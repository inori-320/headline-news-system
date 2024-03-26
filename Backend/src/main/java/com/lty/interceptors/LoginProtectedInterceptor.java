package com.lty.interceptors;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lty.utils.JwtHelper;
import com.lty.utils.Result;
import com.lty.utils.ResultCodeEnum;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @author lty
 */
@Component
public class LoginProtectedInterceptor implements HandlerInterceptor {
    @Autowired
    private JwtHelper jwt;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        boolean expiration = jwt.isExpiration(token);
        if(expiration){
            Result result = Result.build(null, ResultCodeEnum.NOT_LOGIN);
            ObjectMapper om = new ObjectMapper();
            String json = om.writeValueAsString(result);
            response.getWriter().print(json);
            return false;
        }
        return true;
    }
}
