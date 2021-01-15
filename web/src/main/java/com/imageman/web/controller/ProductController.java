package com.imageman.web.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.imageman.common.config.system.ResponseVO;
import com.imageman.common.utils.JudgeUtils;
import com.imageman.pojo.bo.ProductElasticSearchParam;
import com.imageman.pojo.bo.ProductParam;
import com.imageman.pojo.group.InsertGroup;
import com.imageman.pojo.group.UpdateGroup;
import com.imageman.pojo.vo.ProductElasticVO;
import com.imageman.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * <p>
 * 商品表 商品表 前端控制器
 * </p>
 *
 * @author KatoUyi
 * @since 2021-01-13
 */
@RestController
@Api(tags = "02 商品管理")
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    @ApiOperation("【C】创建商品")
    public ResponseVO insertProduct(@RequestBody @Validated(InsertGroup.class) ProductParam productParam) throws IOException {
        productService.insertProduct(productParam);
        return ResponseVO.succ();
    }

    @PutMapping
    @ApiOperation("【U】修改商品信息")
    public ResponseVO updateProduct(@RequestBody @Validated(UpdateGroup.class) ProductParam productParam) throws Exception {
        productService.updateProduct(productParam);
        return ResponseVO.succ();
    }

    @DeleteMapping
    @ApiOperation("【D】逻辑删除单个商品")
    public ResponseVO deleteOne(String id) throws IOException {
        JudgeUtils.isEmpty(id);
        productService.deleteProductById(id);
        return ResponseVO.succ();
    }

    @PostMapping("list")
    @ApiOperation("【R】查询商品")
    public ResponseVO<Page<ProductElasticVO>> getProductList(@RequestBody ProductElasticSearchParam productElasticSearchParam) throws IOException {
        Page<ProductElasticVO> result = productService.searchByParam(productElasticSearchParam);
        return ResponseVO.succ(result);
    }
}

