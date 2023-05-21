package com.wsl.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wsl.pojo.User;
import com.wsl.utils.JsonUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//@Controller
@RestController//表示这个类中的所有方法都不走视图解析器
public class UserController {
    @RequestMapping(value = "/j1")
    //@ResponseBody//它就不会走视图解析器，会直接返回一个字符串或者在类上面加restController，表示这个类中的所有方法都不走视图解析器
    public String json1() throws JsonProcessingException {
        //Jackson，ObjectMapper
        ObjectMapper mapper=new ObjectMapper();
        //创建一个对象
        User user=new User(1,"王世林",20);
        String value = mapper.writeValueAsString(user);
        return value;
    }

    @RequestMapping(value = "/j2")
    public String json2() throws JsonProcessingException {
        //Jackson，ObjectMapper
        ObjectMapper mapper=new ObjectMapper();
        //创建一个对象
        List<User> list=new ArrayList<>();
        User user=new User(1,"王世林",20);
        User user1=new User(1,"王世林",20);
        User user2=new User(1,"王世林",20);
        list.add(user);
        list.add(user1);
        list.add(user2);
        String value = mapper.writeValueAsString(list);
        return value;
    }

    @RequestMapping(value = "/j3")
    public String json3() throws JsonProcessingException {

        Date date=new Date();

        return JsonUtils.getJson(date);
    }

    @RequestMapping(value = "/j4")
    public void json4() {
        List<User> list=new ArrayList<>();
        User user=new User(1,"王世林",20);
        User user1=new User(1,"王世林",20);
        User user2=new User(1,"王世林",20);
        list.add(user);
        list.add(user1);
        list.add(user2);
        System.out.println("*******Java对象 转 JSON字符串*******");
        String str1 = JSON.toJSONString(list);
        System.out.println("JSON.toJSONString(list)==>"+str1);
        String str2 = JSON.toJSONString(user1);
        System.out.println("JSON.toJSONString(user1)==>"+str2);

        System.out.println("\n****** JSON字符串 转 Java对象*******");
        User jp_user1=JSON.parseObject(str2,User.class);
        System.out.println("JSON.parseObject(str2,User.class)==>"+jp_user1);

        System.out.println("\n****** Java对象 转 JSON对象 ******");
        JSONObject jsonObject1 = (JSONObject) JSON.toJSON(user2);
        System.out.println("(JSONObject) JSON.toJSON(user2)==>"+jsonObject1.getString("name"));

        System.out.println("\n****** JSON对象 转 Java对象 ******");
        User to_java_user = JSON.toJavaObject(jsonObject1, User.class);
        System.out.println("JSON.toJavaObject(jsonObject1, User.class)==>"+to_java_user);

    }
}
