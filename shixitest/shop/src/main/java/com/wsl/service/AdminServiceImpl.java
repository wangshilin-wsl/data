package com.wsl.service;

import com.wsl.dao.AdminMapper;
import com.wsl.pojo.Admin;
import com.wsl.pojo.AdminExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService{
    @Autowired
    AdminMapper mapper;

    @Override
    public Admin login(Admin admin) {
        Admin result=null;
        AdminExample example=new AdminExample();
        AdminExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(admin.getUsername());
        List<Admin> list = mapper.selectByExample(example);
        if(list!=null&&list.size()!=0){
            if(admin.getPassword().equals(list.get(0).getPassword())){
                result= list.get(0);
            }
        }
        return result;
    }

    @Override
    public int register(Admin admin) {
        return 0;
    }
}
