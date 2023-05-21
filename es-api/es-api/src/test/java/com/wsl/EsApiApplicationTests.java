package com.wsl;

import com.alibaba.fastjson.JSON;
import com.wsl.pojo.User;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.FetchSourceContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class EsApiApplicationTests {
    @Autowired
    @Qualifier("restHighLevelClient")
    RestHighLevelClient client;

    //测试创建索引
    @Test
    void test1() throws IOException {
        //1、创建索引请求
        CreateIndexRequest index = new CreateIndexRequest("kuang_index");
        //2、执行请求
        CreateIndexResponse response = client.indices().create(index, RequestOptions.DEFAULT);
        System.out.println(response);
    }

    //测试获取索引，判断索引是否存在
    @Test
    void test2() throws IOException {
        //1、判断索引是否存在
        GetIndexRequest index = new GetIndexRequest("kuang_index");
        //2、执行请求
        boolean exists = client.indices().exists(index, RequestOptions.DEFAULT);
        System.out.println(exists);
    }
    //测试删除索引
    @Test
    void test3() throws IOException {
        //1、测试删除索引
        DeleteIndexRequest index = new DeleteIndexRequest("kuang_index");
        //2、执行请求
        AcknowledgedResponse delete = client.indices().delete(index, RequestOptions.DEFAULT);
        System.out.println(delete.isAcknowledged());
    }


    //测试添加文档
    @Test
    void test4() throws IOException {
        //创建对象
        User user = new User("狂神说", 3);
        //1、创建索引请求
        IndexRequest request = new IndexRequest("kuang_index");

        //规则 put /kuang_index/_doc/1
        request.id("1");
        request.timeout(TimeValue.timeValueSeconds(1));
        request.timeout("1s");

        //将我们的数据放入请求 json
        request.source(JSON.toJSONString(user), XContentType.JSON);

        //客户端发送请求,获取响应状态
        IndexResponse response = client.index(request, RequestOptions.DEFAULT);
        System.out.println(response.toString());
        System.out.println(response.status());
    }

    //测试文档是否存在
    @Test
    void test5() throws IOException {
        //1、创建索引请求
        GetRequest request = new GetRequest("kuang_index", "1");

        //不获取返回的_source的上下文了
        request.fetchSourceContext(new FetchSourceContext(false));
        request.storedFields("_none_");

        final boolean exists = client.exists(request, RequestOptions.DEFAULT);
        System.out.println(exists);
    }
    //测试获取文档详细信息
    @Test
    void test6() throws IOException {
        //1、创建索引请求
        GetRequest request = new GetRequest("kuang_index", "1");
        GetResponse response = client.get(request, RequestOptions.DEFAULT);
        //打印文档内容
        System.out.println(response.getSourceAsString());
        System.out.println(response);
    }
    //测试更新文档信息
    @Test
    void test7() throws IOException {
        //1、创建索引请求
        UpdateRequest request = new UpdateRequest("kuang_index", "1");
        //封装对象
        request.timeout("1s");
        final User user = new User("狂神说Java", 18);
        request.doc(JSON.toJSONString(user), XContentType.JSON);

        UpdateResponse update = client.update(request, RequestOptions.DEFAULT);
        //打印文档内容
        System.out.println(update.status());
    }

    //删除文档
    @Test
    void test8() throws IOException {
        //1、创建索引请求
        DeleteRequest request = new DeleteRequest("kuang_index", "1");
        //封装对象
        request.timeout("1s");

        DeleteResponse delete = client.delete(request, RequestOptions.DEFAULT);
        //打印文档内容
        System.out.println(delete.status());
    }

    //批量插入数据
    @Test
    void test9() throws IOException {
        //1、创建索引请求
        BulkRequest request = new BulkRequest();
        //封装对象
        request.timeout("10s");

        List<User> users = new ArrayList<>();
        users.add(new User("kuangshen1", 1));
        users.add(new User("kuangshen2", 2));
        users.add(new User("kuangshen3", 3));
        users.add(new User("kuangshen4", 4));
        for (int i = 0; i < users.size(); i++) {
            //批量删除和批量更新，就在这里修改对应的请求就可以了
            request.add(new IndexRequest("kuang_index")
                    .id(""  + i + 1)
                    .source(JSON.toJSONString(users.get(i)), XContentType.JSON));
        }
        final BulkResponse bulk = client.bulk(request, RequestOptions.DEFAULT);
        //打印文档内容
        System.out.println(bulk.hasFailures());
    }

    //查询文档
    // SearchRequest 搜索请求
    // SearchSourceBuilder 条件构造
    // HighlightBuilder 高亮
    // TermQueryBuilder 精确查询
    // MatchAllQueryBuilder
    // xxxQueryBuilder ..
    @Test
    void test10() throws IOException {
        //1、创建索引请求
        SearchRequest request = new SearchRequest("kuang_index");
        //构建搜索条件
        SearchSourceBuilder builder = new SearchSourceBuilder();

        //查询条件，我们可以使用QueryBuilders工具来实现
        //QueryBuilders.termQuery() 精确
        //QueryBuilders.matchAllQuery()  匹配所有
        final TermQueryBuilder query = QueryBuilders.termQuery("name", "kuangshen1");


        builder.query(query);
        //分页参数
        //builder.from()
        //builder.to()
        builder.timeout(new TimeValue(60, TimeUnit.SECONDS));


        request.source(builder);
        SearchResponse search = client.search(request, RequestOptions.DEFAULT);
        //打印文档内容

        System.out.println(JSON.toJSONString(search.getHits()));

        for (SearchHit hit : search.getHits()) {
            System.out.println(hit.getSourceAsMap());
        }
    }
}
