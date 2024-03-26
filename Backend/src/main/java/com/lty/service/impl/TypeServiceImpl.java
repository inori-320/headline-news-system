package com.lty.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lty.pojo.Type;
import com.lty.service.TypeService;
import com.lty.mapper.TypeMapper;
import org.springframework.stereotype.Service;

/**
* @author 71947
* @description 针对表【news_type】的数据库操作Service实现
* @createDate 2024-03-25 19:09:17
*/
@Service
public class TypeServiceImpl extends ServiceImpl<TypeMapper, Type>
    implements TypeService{

}




