package com.wsl.controller;

import com.alibaba.druid.util.StringUtils;
import com.wsl.entity.User;
import com.wsl.server.UserServerImpl;
import com.wsl.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin//允许跨域
@RequestMapping("/user/")
public class UserController {
    @Autowired
    private UserServerImpl userServer;
    //查询所有
    @GetMapping("findAll")
    public List<User> findAll(){
        return userServer.findAll();
    }
    //保存用户
    @PostMapping("saveOrUpdate")
    public Result saveOrUpdate(@RequestBody User user){
        Result result=new Result();
        try {
            if(StringUtils.isEmpty(user.getId())){
                userServer.save(user);
                result.setMsg("用户信息保存成功...");
            }else{
                userServer.update(user);
                result.setMsg("用户信息修改成功...");
            }
        }catch (Exception e){
            result.setStatue(false);
            result.setMsg("系统错误：保存或更新用户信息失败，请稍后在试...");
        }
        return result;
    }
    //根据id删除用户
    @GetMapping("delete")
    public Result delete(@RequestParam String  id){
        System.out.println(id);
        Result result=new Result();
        try {
            userServer.delete(id);
            result.setMsg("用户信息删除成功...");
        }catch (Exception e){
           // e.printStackTrace();
            result.setStatue(false);
            result.setMsg("系统错误：删除用户信息失败，请稍后在试...");
        }
        return result;
    }

    //分页查询的方法
    @GetMapping("findByPage")
    public Map<String,Object> findByPage(Integer pageNow, Integer pageSize){
        Map<String,Object> map=new HashMap<>();
        List<User> users = userServer.findByPage(pageNow, pageSize);
        Long totals = userServer.findTotals();
        map.put("users",users);
        map.put("total",totals);
        return map;
    }
}
