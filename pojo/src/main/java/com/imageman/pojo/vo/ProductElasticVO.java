package com.imageman.pojo.vo;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * author: ZGF
 * context : 商品存储在ES中的基本信息
 */
@Data
public class ProductElasticVO implements Serializable {

    private String id;

    private String itemName;

    private String rootCatId;

    private String catId;

    private Integer sellCounts;

    private Integer status;

    private String content;

    private LocalDateTime createdTime;

    private LocalDateTime updatedTime;

    /* 预览图 */
    private String previewLittle;
}
