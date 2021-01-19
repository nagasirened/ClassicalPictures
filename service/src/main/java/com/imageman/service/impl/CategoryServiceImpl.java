package com.imageman.service.impl;

import com.imageman.common.utils.JudgeUtils;
import com.imageman.others.redis.RedisAuxiliary;
import com.imageman.others.redis.prefix.BasicPrefix;
import com.imageman.pojo.Category;
import com.imageman.mapper.CategoryMapper;
import com.imageman.pojo.vo.CategoryVO;
import com.imageman.service.CategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>
 * 分类 分类 服务实现类
 * </p>
 *
 * @author KatoUyi
 * @since 2021-01-13
 */
@Service
@Transactional
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private RedisAuxiliary redisAuxiliary;

    /**
     * 创建一个新的分类
     * @param category
     */
    @Override
    public void insertCategory(Category category) {
        redisAuxiliary.delete(BasicPrefix.CATEGORY_STORE_KEY, "");
        if (StringUtils.isEmpty(category.getParentId())) {
            category.setParentId("0");
        }
        if (Objects.isNull(category.getSort())) {
            category.setSort(100);
        }
        categoryMapper.insert(category);
        actualGetAllCategories();
    }

    /**
     * 获取所有分类
     * @return
     */
    public List<CategoryVO> getAllCategories() {
        List<CategoryVO> categoryVOList = (List<CategoryVO>)redisAuxiliary.get(BasicPrefix.CATEGORY_STORE_KEY, "");
        if (!CollectionUtils.isEmpty(categoryVOList)) {
            return categoryVOList;
        }
        return actualGetAllCategories();
    }

    private List<CategoryVO> actualGetAllCategories() {
        List<CategoryVO> allCategories = categoryMapper.getAllCategories();
        redisAuxiliary.setWithExpire(BasicPrefix.CATEGORY_STORE_KEY, "", allCategories);
        return allCategories;
    }

    /**
     * 修改
     * @param category
     */
    @Override
    public void updateCategory(Category category) {
        JudgeUtils.isNull(category, category.getId());
        redisAuxiliary.delete(BasicPrefix.CATEGORY_STORE_KEY, "");
        categoryMapper.updateById(category);

        actualGetAllCategories();
    }


}
