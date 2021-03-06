package com.imageman.others.es;

import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.Setter;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.io.IOException;
import java.lang.reflect.Field;

/**
 * author: ZGF
 * context : 默认
 */

public class DefaultHignLevelDocumentHandler<T, ID> implements HignLevelDocumentHandler<T, ID> {

    @Autowired
    @Qualifier("restHighLevelClient")
    private RestHighLevelClient client;

    @Getter
    @Setter
    private String indexName;

    public DefaultHignLevelDocumentHandler(String indexName){
        this.indexName = indexName;
    }

    @Override
    public void save(T t) throws Exception {
        if (judgeId(t)) {
            Field id = t.getClass().getDeclaredField("id");
            save(t, id.toString());
            return;
        }
        save(t, null);
    }

    public void save(T t, String id) throws IOException {
        jsonSave(t, id, TimeValue.timeValueSeconds(1));
    }

    public void jsonSave(T t, String id, TimeValue timeValue) throws IOException {
        IndexRequest indexRequest = new IndexRequest(indexName);
        indexRequest.id(id);
        indexRequest.timeout(timeValue);
        indexRequest.source(JSON.toJSONString(t), XContentType.JSON);
        client.index(indexRequest, RequestOptions.DEFAULT);
    }

    @Override
    public String detail(ID id) throws IOException {
        GetRequest request = new GetRequest(indexName, id.toString());
        GetResponse getResponse = client.get(request, RequestOptions.DEFAULT);
        return getResponse.getSourceAsString();
    }

    @Override
    public void update(T t) throws Exception {
        if (judgeId(t)) {
            Field id = t.getClass().getDeclaredField("id");
            save(t, id.toString());
        } else {
            update(t, null);
        }
    }

    public void update(T t, String id) throws Exception {
        update(t, id, TimeValue.timeValueSeconds(1));
    }

    public void update(T t, String id, TimeValue timeValue) throws Exception {
        UpdateRequest updateRequest = new UpdateRequest(indexName, id);
        updateRequest.timeout(timeValue);
        updateRequest.doc(JSON.toJSONString(t), XContentType.JSON);
        client.update(updateRequest, RequestOptions.DEFAULT);
    }

    @Override
    public void delete(ID id) throws IOException {
        delete(id, TimeValue.timeValueSeconds(1));
    }

    public void delete(ID id, String timeout) throws IOException {
        DeleteRequest deleteRequest = new DeleteRequest(indexName);
        deleteRequest.timeout(timeout);
        deleteRequest.id(id.toString());
        client.delete(deleteRequest, RequestOptions.DEFAULT);
    }

    public void delete(ID id, TimeValue timeValue) throws IOException {
        DeleteRequest deleteRequest = new DeleteRequest(indexName);
        deleteRequest.timeout(timeValue);
        deleteRequest.id(id.toString());
        client.delete(deleteRequest, RequestOptions.DEFAULT);
    }

    private boolean judgeId(T t){
        //获取这个类的所有属性
        Field[] fields = t.getClass().getDeclaredFields();
        boolean flag = false;
        //循环遍历所有的fields
        for (int i = 0; i < fields.length; i++) {
            if (fields[i].getName().equals("id")) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    @Override
    public void bulk(BulkRequest bulkRequest) throws IOException {
        client.bulk(bulkRequest, RequestOptions.DEFAULT);
    }

    @Override
    public SearchResponse search(SearchSourceBuilder searchSourceBuilder) throws IOException {
        SearchRequest searchRequest = new SearchRequest(indexName);
        searchRequest.source(searchSourceBuilder);
        return client.search(searchRequest, RequestOptions.DEFAULT);
    }
}
