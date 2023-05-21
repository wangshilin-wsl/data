package com.wsl.controller;

import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.wsl.domain.User;
import com.wsl.hystrix.MyHystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;

/**
 * @author WSL
 * @version 1.0.0
 * @ClassName WebController.java
 * @Description TODO
 * @createTime 2023年02月15日 23:02:00
 */
@RestController
public class WebController {
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/web/hello")
    public String hello(){
        //逻辑判断（省略）
        //调用springcloud提供的类
        //return restTemplate.getForEntity("http://localhost:8001/service/hello", String.class).getBody();

        //ribbon调用
        return restTemplate.getForEntity("http://springcloud-service-provider/service/hello", String.class).getBody();
    }
    @RequestMapping("/web/user")
    public User user(){
        //逻辑判断（省略）
        //调用springcloud提供的类
        //return restTemplate.getForEntity("http://localhost:8001/service/hello", String.class).getBody();

        //ribbon调用
        return restTemplate.getForEntity("http://springcloud-service-provider/service/user", User.class).getBody();
    }
    //携带参数
    @RequestMapping("/web/getUser")
    public User getUser(){
        //逻辑判断（省略）
        //调用springcloud提供的类
        //return restTemplate.getForEntity("http://localhost:8001/service/hello", String.class).getBody();

        String[] arr = {"100", "张三丰", "120"};
        //ribbon调用
        return restTemplate.getForEntity("http://springcloud-service-provider/service/getUser?id={0}&name={1}&phone={2}",
                User.class, arr).getBody();
    }

    //携带参数
    @RequestMapping("/web/getUserForMap")
    public User getUserForMap(){
        //逻辑判断（省略）
        //调用springcloud提供的类
        //return restTemplate.getForEntity("http://localhost:8001/service/hello", String.class).getBody();

        Map<String, Object> map = new HashMap<>();
        map.put("id", 100);
        map.put("name", "张三丰");
        map.put("phone", "120");
        //ribbon调用
        return restTemplate.getForEntity("http://springcloud-service-provider/service/getUser?id={id}&name={name}&phone={phone}",
                User.class, map).getBody();
    }
    //携带参数
    @RequestMapping("/web/getObjectForMap")
    public User getObjectForMap(){
        //逻辑判断（省略）
        //调用springcloud提供的类
        //return restTemplate.getForEntity("http://localhost:8001/service/hello", String.class).getBody();

        Map<String, Object> map = new HashMap<>();
        map.put("id", 100);
        map.put("name", "张三丰");
        map.put("phone", "120");
        //ribbon调用
        return restTemplate.getForObject("http://springcloud-service-provider/service/getUser?id={id}&name={name}&phone={phone}",
                User.class, map);
    }

    @RequestMapping("/web/addUser")
    public User addUser() {
        //进行业务处理(省略)
        MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
        map.add("id", "12");
        map.add("name", "小王");
        map.add("phone", "155");
        //要传的表单信息

        return restTemplate.postForEntity("http://springcloud-service-provider/service/addUser", map, User.class).getBody();
    }

    @RequestMapping("/web/addUserForJson")
    public User addUserForJson() {
        //进行业务处理(省略)

        //要传的表单信息
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("id", "12");
        requestBody.put("name", "小王");
        requestBody.put("phone", "155");
        HttpHeaders requestHeaders = new HttpHeaders();
        // 重点是配置请求头内容类型为："application/json"
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Map<String, String>> httpEntity = new HttpEntity<>(requestBody, requestHeaders);


        return restTemplate.postForEntity("http://springcloud-service-provider/service/addUserForJson", httpEntity, User.class).getBody();
    }


    //测试hystrix
    @RequestMapping("/web/hystrix")
    //设置回调方法，和超时时间
    @HystrixCommand(fallbackMethod = "error", ignoreExceptions = Exception.class, commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "15000")})
    public String hystrix(){
        //逻辑判断（省略）
        //调用springcloud提供的类
        //return restTemplate.getForEntity("http://localhost:8001/service/hello", String.class).getBody();


        //自己发生异常
        //int i = 1/0;
        //ribbon调用
        return restTemplate.getForEntity("http://springcloud-service-provider/service/hello", String.class).getBody();
    }

    //访问远程服务失败，该如何处理？这些处理逻辑可以写在该方法中
    public String error(Throwable throwable){
        System.out.println("异常: " + throwable.getMessage());
        return "error:cause by" + throwable.getMessage();
    }

    //测试hystrix
    @RequestMapping("/web/myHystrix")
    public String myHystrix() throws Exception {
        //自定义熔断方法
        MyHystrixCommand myHystrixCommand = new MyHystrixCommand(com.netflix.hystrix.HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("")), restTemplate);
        //返回结果,同步调用,会等待返回结果，拿到了返回结果，该方法才返回
        //String result = myHystrixCommand.execute();

        //返回结果,异步调用,
        Future<String> queue = myHystrixCommand.queue();
        //阻塞的方法，直到拿到结果
        return queue.get();
    }
}
