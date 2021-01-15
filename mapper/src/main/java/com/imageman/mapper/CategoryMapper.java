package com.imageman.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.imageman.pojo.Category;
import com.imageman.pojo.vo.CategoryVO;

import java.util.List;


/**
 * <p>
 * 分类 分类 Mapper 接口
 * </p>
 *
 * @author KatoUyi
 * @since 2021-01-13
 */
public interface CategoryMapper extends BaseMapper<Category> {

    List<CategoryVO> getAllCategories();

    List<CategoryVO> getCategoriesByParentId(String parentId);
}
