package com.lty.pojo;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serial;
import java.io.Serializable;
import lombok.Data;

/**
 * @TableName news_type
 */
@Data
public class Type implements Serializable {
    @TableId
    private Integer tid;

    private String tname;
    @Version
    private Integer version;

    private Integer isDeleted;

    @Serial
    private static final long serialVersionUID = 1L;
}