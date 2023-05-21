package com.wsl.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author WSL
 * @version 1.0.0
 * @ClassName ElasticSearchConfig.java
 * @Description es操作对象
 * @createTime 2022年08月18日 22:25:00
 */
@Configuration
public class ElasticSearchConfig {
    // 注册 rest高级客户端
    @Bean
    public RestHighLevelClient restHighLevelClient() {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("127.0.0.1", 9200, "http")
                )
        );
        return client;
    }
}
