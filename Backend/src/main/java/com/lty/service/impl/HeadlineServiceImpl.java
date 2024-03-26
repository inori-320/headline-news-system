package com.lty.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lty.pojo.Headline;
import com.lty.service.HeadlineService;
import com.lty.mapper.HeadlineMapper;
import org.springframework.stereotype.Service;

/**
* @author 71947
* @description 针对表【news_headline】的数据库操作Service实现
* @createDate 2024-03-25 19:09:17
*/
@Service
public class HeadlineServiceImpl extends ServiceImpl<HeadlineMapper, Headline>
    implements HeadlineService{

}




