package com.imageman.service;

import com.imageman.pojo.Category;
import com.baomidou.mybatisplus.extension.service.IService;
import com.imageman.pojo.vo.CategoryVO;

import javax.validation.Valid;
import java.util.List;

/**
 * <p>
 * 分类 分类 服务类
 * </p>
 *
 * @author KatoUyi
 * @since 2021-01-13
 */
public interface CategoryService extends IService<Category> {

    /**
     * 创建一个新的分类
     * @param category
     */
    void insertCategory(Category category);

    /**
     * 获取全部分类
     * @return
     */
    List<CategoryVO> getAllCategories();

    /**
     * 修改
     * @param category
     */
    void updateCategory(Category category);
}
