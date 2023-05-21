package com.wsl.controller;

import com.wsl.entity.Emp;
import com.wsl.service.EmpServiceImpl;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@CrossOrigin///允许跨域
@RequestMapping("/emp/")
public class EmpController {
    @Autowired
    private EmpServiceImpl empService;

    @Value("${photo.dir}")
    private String realPath;
    //获取所有员工的数据
    @GetMapping("findAll")
    List<Emp> findAll(){
        return empService.findAll();
    }
    //保存员工信息
    @PostMapping("save")
    public Map<String,Object> save(Emp emp, MultipartFile photo) throws IOException {
        Map<String,Object> map=new HashMap<>();
        System.out.println(photo.getOriginalFilename());
        System.out.println(photo);
        System.out.println(emp);

        try {
            //图形的保存
            String newFileName= UUID.randomUUID().toString()+"."+ FilenameUtils.getExtension(photo.getOriginalFilename());
            photo.transferTo(new File(realPath,newFileName));
            //设置图像地址
            emp.setPath(newFileName);
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
            Emp emp = empService.findOne(id);
            File file = new File(realPath, emp.getPath());
            if(file.exists()) file.delete();//删除图像
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
    public Emp findOne(String id){
        return empService.findOne(id);
    }
    //修改的方法
    @PostMapping("update")
    public Map<String,Object> update(Emp emp, MultipartFile photo) throws IOException {
        Map<String,Object> map=new HashMap<>();

        System.out.println(emp);
        try {
            if(photo!=null&&photo.getSize()!=0){
                System.out.println(photo.getOriginalFilename());
                //图形的保存
                String newFileName= UUID.randomUUID().toString()+"."+ FilenameUtils.getExtension(photo.getOriginalFilename());
                photo.transferTo(new File(realPath,newFileName));
                //设置图像地址
                emp.setPath(newFileName);
            }
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
