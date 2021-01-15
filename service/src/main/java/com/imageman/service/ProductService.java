package com.imageman.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.imageman.pojo.Product;
import com.baomidou.mybatisplus.extension.service.IService;
import com.imageman.pojo.bo.ProductElasticSearchParam;
import com.imageman.pojo.bo.ProductParam;
import com.imageman.pojo.vo.ProductElasticVO;

import java.io.IOException;

/**
 * <p>
 * 商品表 商品表 服务类
 * </p>
 *
 * @author KatoUyi
 * @since 2021-01-13
 */
public interface ProductService extends IService<Product> {

    /**
     * 新增商品信息
     * @param productParam
     */
    void insertProduct(ProductParam productParam) throws IOException;

    /**
     * 修改商品信息
     * @param productParam
     */
    void updateProduct(ProductParam productParam) throws Exception;

    /**
     * 根据主键逻辑删除商品
     * @param id
     */
    void deleteProductById(String id) throws IOException;

    /**
     * 条件查询，ElasticSearch
     * @param productElasticSearchParam
     * @return
     */
    Page<ProductElasticVO> searchByParam(ProductElasticSearchParam productElasticSearchParam) throws IOException;
}
