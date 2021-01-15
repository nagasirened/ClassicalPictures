package com.imageman.others.es;

import com.imageman.pojo.Product;
import com.imageman.pojo.vo.ProductElasticVO;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * author: ZGF
 * 11-2020/11/26 : 15:34
 * context :
 */

@Configuration
public class ElasticsearchConfig {

    @Bean
    public RestHighLevelClient restHighLevelClient(){
        RestHighLevelClient restHighLevelClient = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("localhost", 9200, "http")
                        // 如果是集群，可以构建多个
                        /*,new HttpHost("localhost", 9201, "http")*/
                )
        );

        return restHighLevelClient;
    }

    @Bean(name = "productClient")
    @ConditionalOnMissingBean(name = "productClient")
    public DefaultHignLevelDocumentHandler defaultHignLevelDocumentHandler(){
        DefaultHignLevelDocumentHandler<ProductElasticVO, String> handler = new DefaultHignLevelDocumentHandler<>("product");
        return handler;
    }

}
