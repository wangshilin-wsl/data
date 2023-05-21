package com.rms.controller;

import com.rms.entity.Rm;
import com.rms.service.RmServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin///允许跨域
@RequestMapping("/rm/")
public class RmController {
    @Autowired
    private RmServiceImpl empService;
    //获取所有员工的数据
    @GetMapping("findAll")
    List<Rm> findAll(){
        return empService.findAll();
    }
    //保存员工信息
    @PostMapping("save")
    public Map<String,Object> save(Rm emp) throws IOException {
        Map<String,Object> map=new HashMap<>();
        try {
            //保存员工信息
            empService.save(emp);
            map.put("state",true);
            map.put("msg","员工信息保存成功！");
        }catch (Exception e){
            e.printStackTrace();
            map.put("state",false);
            map.put("msg","员工信息保存失败！");
        }

        return map;
    }
    //删除一个员工
    @GetMapping("delete")
    public Map<String,Object> delete(String id){
        System.out.println(id);
        Map<String,Object> map=new HashMap<>();
        try {
            //删除员工图像
            Rm emp = empService.findOne(id);

            //删除员工信息
            empService.delete(id);
            map.put("state",true);
            map.put("msg","删除员工信息成功！");
        }catch (Exception e){
            e.printStackTrace();
            map.put("state",false);
            map.put("msg","删除员工信息失败！");
        }
        return map;
    }
    //根据id查询员工
    @GetMapping("findOne")
    public Rm findOne(String id){
        return empService.findOne(id);
    }
    //修改的方法
    @PostMapping("update")
    public Map<String,Object> update(Rm emp, MultipartFile photo) throws IOException {
        Map<String,Object> map=new HashMap<>();

        System.out.println(emp);
        try {
            //保存员工信息
            empService.update(emp);
            map.put("state",true);
            map.put("msg","员工信息修改成功！");
        }catch (Exception e){
            e.printStackTrace();
            map.put("state",false);
            map.put("msg","员工信息修改失败！");
        }

        return map;
    }
}
