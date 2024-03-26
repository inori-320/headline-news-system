package com.lty.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lty.pojo.Headline;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lty.pojo.vo.PortalVo;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Map;
import java.util.Objects;

/**
* @author 71947
* @description 针对表【news_headline】的数据库操作Mapper
* @createDate 2024-03-25 19:09:17
* @Entity com.lty.pojo.Headline
*/
public interface HeadlineMapper extends BaseMapper<Headline> {
    @MapKey("hid")
    IPage<Map<String, Object>> selectPageMap(IPage<Headline> page, @Param("portalVo") PortalVo portalVo);

    @MapKey("hid")
    Map<String, Object> selectDetailMap(Integer hid);
}




