package com.wsl.service;

import com.alibaba.fastjson.JSON;
import com.wsl.pojo.Content;
import com.wsl.utils.HtmlParseUtil;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author WSL
 * @version 1.0.0
 * @ClassName ContentService.java
 * @Description TODO
 * @createTime 2022年08月20日 20:27:00
 */
@Service
public class ContentService {
    @Resource
    private RestHighLevelClient restHighLevelClient;

    //1解析数据放入es索引中
    public boolean parseContent(String keyword) throws Exception{
        List<Content> list = HtmlParseUtil.parseJD(keyword);
        //把查询到的数据放入es中
        BulkRequest request = new BulkRequest();
        request.timeout("2m");
        for (int i = 0; i < list.size(); i++) {
            request.add(
                    new IndexRequest("jd_goods")
                    .source(JSON.toJSONString(list.get(i)), XContentType.JSON));
        }
        BulkResponse bulk = restHighLevelClient.bulk(request, RequestOptions.DEFAULT);
        return !bulk.hasFailures();
    }
    //2、获取这些数据的搜索功能
    public List<Map<String, Object>> searchPage(String keyword, int pageNo, int pageSize) throws Exception{
        if(pageNo <= 1){
            pageNo = 1;
        }
        SearchRequest request = new SearchRequest("jd_goods");
        SearchSourceBuilder builder = new SearchSourceBuilder();
        //精确匹配
        final MatchQueryBuilder query = QueryBuilders.matchQuery("title", keyword);
        builder.query(query);
        builder.timeout(new TimeValue(60, TimeUnit.SECONDS));
        //分页
        builder.from(pageNo);
        builder.size(pageSize);

        //执行搜索
        request.source(builder);
        SearchResponse res = restHighLevelClient.search(request, RequestOptions.DEFAULT);

        List<Map<String, Object>> list = new ArrayList<>();
        for (SearchHit hit : res.getHits()) {
           list.add(hit.getSourceAsMap());
        }
        return list;
    }

    //3、获取这些数据的搜索功能，增加高亮
    public List<Map<String, Object>> searchPageHL(String keyword, int pageNo, int pageSize) throws Exception{
        if(pageNo <= 1){
            pageNo = 1;
        }
        SearchRequest request = new SearchRequest("jd_goods");
        SearchSourceBuilder builder = new SearchSourceBuilder();
        //精确匹配
        final MatchQueryBuilder query = QueryBuilders.matchQuery("title", keyword);
        builder.query(query);
        builder.timeout(new TimeValue(60, TimeUnit.SECONDS));
        //分页
        builder.from(pageNo);
        builder.size(pageSize);

        //高亮
        final HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.field("title");
        highlightBuilder.requireFieldMatch(false);//多个高亮显示
        highlightBuilder.preTags("<span style='color:red'>");
        highlightBuilder.postTags("</span>");
        builder.highlighter(highlightBuilder);

        //执行搜索
        request.source(builder);
        SearchResponse res = restHighLevelClient.search(request, RequestOptions.DEFAULT);

        List<Map<String, Object>> list = new ArrayList<>();
        for (SearchHit hit : res.getHits()) {
            //解析高亮的字段
            final Map<String, HighlightField> fields = hit.getHighlightFields();
            final HighlightField title = fields.get("title");
            //原来的结果
            final Map<String, Object> sourceAsMap = hit.getSourceAsMap();
            //解析高亮字段，就原来的字段换成我们高亮的字段即可
            if (title != null){
                final Text[] texts = title.fragments();
                String n_title = "";
                for (Text text : texts) {
                    n_title += text;
                }
                sourceAsMap.put("title", n_title);
            }

            list.add(sourceAsMap);
        }
        return list;
    }
}
