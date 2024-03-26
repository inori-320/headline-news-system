package com.lty.service;

import com.lty.pojo.Headline;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lty.pojo.vo.PortalVo;
import com.lty.utils.Result;

/**
* @author 71947
* @description 针对表【news_headline】的数据库操作Service
* @createDate 2024-03-25 19:09:17
*/
public interface HeadlineService extends IService<Headline> {
    Result findNewsPage(PortalVo portalVo);
    Result showHeadlineDetail(Integer hid);
    Result publish(Headline headline, String token);
    Result update(Headline headline);
}
