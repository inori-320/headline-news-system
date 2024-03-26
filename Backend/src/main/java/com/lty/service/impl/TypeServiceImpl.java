package com.lty.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lty.pojo.Type;
import com.lty.pojo.vo.PortalVo;
import com.lty.service.TypeService;
import com.lty.mapper.TypeMapper;
import com.lty.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @author 71947
* @description 针对表【news_type】的数据库操作Service实现
* @createDate 2024-03-25 19:09:17
*/
@Service
public class TypeServiceImpl extends ServiceImpl<TypeMapper, Type>
    implements TypeService{
    @Autowired
    private TypeMapper mapper;

    @Override
    public Result findAllTypes() {
        List<Type> all = mapper.selectList(null);
        return Result.ok(all);
    }

}




