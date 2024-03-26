package com.lty.pojo.vo;

import lombok.Data;

/**
 * @author lty
 */
@Data
public class PortalVo {
    private String keyWords;
    private Integer type;
    private Integer pageNum = 1;
    private Integer pageSize = 1;
}
