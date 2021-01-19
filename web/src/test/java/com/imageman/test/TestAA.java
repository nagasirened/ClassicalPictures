package com.imageman.test;

import com.alibaba.fastjson.JSON;
import com.imageman.mapper.ProductMapper;
import com.imageman.others.es.DefaultHignLevelDocumentHandler;
import com.imageman.pojo.Product;
import com.imageman.pojo.vo.ProductElasticVO;
import com.imageman.web.ImageManApplication;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;

/**
 * author: ZGF
 * 01-2021/1/14 : 16:55
 * context :
 */

@SpringBootTest(classes = ImageManApplication.class)
@RunWith(SpringRunner.class)
public class TestAA {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private DefaultHignLevelDocumentHandler productClient;

    // @Test
    public void addES() throws IOException {
        List<Product> products = productMapper.selectList(null);

        BulkRequest bulkRequest = new BulkRequest("product");
        products.forEach(item -> {
            ProductElasticVO elasticVO = new ProductElasticVO();
            BeanUtils.copyProperties(item, elasticVO);
            elasticVO.setPreviewLittle("1-----1");
            IndexRequest indexRequest = new IndexRequest("product");
            indexRequest.id(item.getId());
            indexRequest.source(JSON.toJSONStringWithDateFormat(elasticVO, "yyyy-MM-dd HH:mm:ss"), XContentType.JSON);
            bulkRequest.add(indexRequest);
        });
        productClient.bulk(bulkRequest);
    }
}
