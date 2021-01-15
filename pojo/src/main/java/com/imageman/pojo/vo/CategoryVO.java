package com.imageman.pojo.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * author: ZGF
 * 01-2021/1/13 : 16:39
 * context :
 */
@Data
@NoArgsConstructor
public class CategoryVO implements Serializable{

    private static final long serialVersionUID=1L;

    private String id;

    private String name;

    private Integer sort;

    private String parentId;

    private String slogan;

    private String logo;

    private LocalDateTime createdTime;

    private LocalDateTime updatedTime;

    private Integer flag;

    private List<CategoryVO> categoryVOList;
}
