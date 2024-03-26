package com.lty.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lty.pojo.Headline;
import com.lty.pojo.vo.PortalVo;
import com.lty.service.HeadlineService;
import com.lty.mapper.HeadlineMapper;
import com.lty.utils.JwtHelper;
import com.lty.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
* @author 71947
* @description 针对表【news_headline】的数据库操作Service实现
* @createDate 2024-03-25 19:09:17
*/
@Service
public class HeadlineServiceImpl extends ServiceImpl<HeadlineMapper, Headline>
    implements HeadlineService{
    @Autowired
    private HeadlineMapper mapper;
    @Autowired
    private JwtHelper jwt;

    @Override
    public Result findNewsPage(PortalVo portalVo) {
        IPage<Headline> page = new Page<>(portalVo.getPageNum(),portalVo.getPageSize());
        mapper.selectPageMap(page, portalVo);
        Map<String,Object> data = new HashMap<>();
        data.put("pageData", page.getRecords());
        data.put("pageNum", page.getCurrent());
        data.put("pageSize", page.getSize());
        data.put("totalPage", page.getPages());
        data.put("totalSize", page.getTotal());
        Map<String,Object> realData = new HashMap<>();
        realData.put("pageInfo", data);
        return Result.ok(realData);
    }

    @Override
    public Result showHeadlineDetail(Integer hid) {
        Map headLineDetail = (Map) mapper.selectDetailMap(hid).get(hid);
        Headline headline = new Headline();
        headline.setHid(hid);
        headline.setPageViews((Integer) headLineDetail.get("pageViews") + 1); //阅读量+1
        headline.setVersion((Integer) headLineDetail.get("version")); //设置版本
        mapper.updateById(headline);

        Map<String,Object> pageInfoMap=new HashMap<>();
        pageInfoMap.put("headline",headLineDetail);
        return Result.ok(pageInfoMap);
    }

    @Override
    public Result publish(Headline headline, String token) {
        int userId = jwt.getUserId(token).intValue();
        headline.setPublisher(userId);
        headline.setPageViews(0);
        headline.setUpdateTime(new Date());
        headline.setCreateTime(new Date());
        mapper.insert(headline);
        return Result.ok(null);
    }

    @Override
    public Result update(Headline headline) {
        int version = mapper.selectById(headline.getHid()).getVersion();
        headline.setVersion(version);
        headline.setUpdateTime(new Date());
        mapper.updateById(headline);
        return Result.ok(null);
    }
}




