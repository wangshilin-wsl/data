package com.wsl.springcloud.contoller;

import com.wsl.springcloud.pojo.Dept;
import com.wsl.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author WSL
 * @version 1.0.0
 * @ClassName DeptConsumerController.java
 * @Description TODO
 * @createTime 2022年04月07日 19:42:00
 */
@RestController
public class DeptConsumerController {

    @Autowired
    private DeptClientService service = null;

    @GetMapping("/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return this.service.queryById(id);
    }
    @PostMapping("/dept/add")
    public boolean addDept(@RequestBody Dept dept){
        return this.service.addDept(dept);
    }
    @GetMapping("/dept/list")
    public List<Dept> queryAll(){
        return this.service.queryAll();
    }
}
