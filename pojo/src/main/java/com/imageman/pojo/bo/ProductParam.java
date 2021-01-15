package com.imageman.pojo.bo;

import com.imageman.pojo.Product;
import com.imageman.pojo.ProductImg;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.Valid;

/**
 * author: ZGF
 * context : 保存或修改文件
 */
@Data
@ApiModel
public class ProductParam  {

    private @Valid Product product;

    private @Valid ProductImg productImg;
}
