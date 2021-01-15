package com.imageman.others.es;

import com.imageman.common.config.system.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Objects;

/**
 * author: ZGF
 * 12-2020/12/2 : 16:53
 * context :
 */

@Component
public class ElasticSearchClientContainer {

    @Autowired
    private Map<String, DefaultHignLevelDocumentHandler> containers;

    public DefaultHignLevelDocumentHandler general(String indexName){
        DefaultHignLevelDocumentHandler handler = containers.get(indexName + "Handler");
        if (Objects.isNull(handler)) {
            throw new CustomException("没有对应的eshandler");
        }
        return handler;
    }
}
