package com.wsl.hystrix;

import com.netflix.hystrix.HystrixCommand;
import org.springframework.web.client.RestTemplate;

/**
 * @author WSL
 * @version 1.0.0
 * @ClassName MyHystrixCommand.java
 * @Description TODO
 * @createTime 2023年02月28日 22:30:00
 */
public class MyHystrixCommand extends HystrixCommand<String> {
    private RestTemplate restTemplate;

    public MyHystrixCommand(Setter setter, RestTemplate restTemplate) {
        super(setter);
        this.restTemplate = restTemplate;
    }

    @Override
    protected String run() throws Exception {
        //调用远程服务
        return restTemplate.getForEntity("http://springcloud-service-provider/service/hello", String.class).getBody();
    }

    @Override
    protected String getFallback() {
        //实现服务熔断、降级逻辑
        Throwable exception = getExecutionException();
        System.out.println(exception.getMessage());
        return "自定义error";
    }
}
