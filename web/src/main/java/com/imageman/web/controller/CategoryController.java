package com.imageman.web.controller;


import com.imageman.common.config.system.ResponseVO;
import com.imageman.common.utils.JudgeUtils;
import com.imageman.pojo.Category;
import com.imageman.pojo.vo.CategoryVO;
import com.imageman.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * <p>
 * 分类 分类 前端控制器
 * </p>
 *
 * @author KatoUyi
 * @since 2021-01-13
 */
@RestController
@Api(tags = "01 分类")
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    @ApiOperation("【C】新增")
    public ResponseVO insertCategory(@RequestBody @Valid Category category){
        categoryService.insertCategory(category);
        return ResponseVO.succ();
    }

    @PutMapping
    @ApiOperation("【U】修改单个分类信息")
    public ResponseVO updateCategory(@RequestBody @Valid Category category){
        categoryService.updateCategory(category);
        return ResponseVO.succ();
    }

    @DeleteMapping
    @ApiOperation("【D】删除单个")
    public ResponseVO deleteCategoryById(String id) {
        categoryService.removeById(id);
        return ResponseVO.succ();
    }

    @GetMapping("all")
    @ApiOperation("【R】获取树形分类信息")
    public ResponseVO<List<CategoryVO>> getCategoriesTree(){
        List<CategoryVO> allCategories = categoryService.getAllCategories();
        return ResponseVO.succ(allCategories);
    }

    @GetMapping
    @ApiOperation("【R】获取单个分类信息")
    public ResponseVO<Category> getCategoryById(String id){
        JudgeUtils.isNull(id);
        Category category = categoryService.getById(id);
        return ResponseVO.succ(category);
    }

    @DeleteMapping("array")
    @ApiOperation("【D】批量删除")
    public ResponseVO deteleByIds(List<String> ids){
        categoryService.removeByIds(ids);
        return ResponseVO.succ();
    }
}

