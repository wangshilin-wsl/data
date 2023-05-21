package com.wsl.service;

import com.wsl.dao.UserinfoMapper;
import com.wsl.pojo.Userinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserinfoServiceImpl implements UserinfoService {
    @Autowired
    private UserinfoMapper mapper;
    @Override
    public Userinfo login(Userinfo user) {
        Userinfo result=null;
        try {
            Userinfo realuser = mapper.selectByUsername(user.getUsername());
            if(realuser!=null){
                if(realuser.getPassword().equals(user.getPassword())){
                    result=realuser;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

   @Transactional
    @Override
    public int register(Userinfo user) {
        int i=0;
            Userinfo realuser = mapper.selectByUsername(user.getUsername());
            if(realuser==null){
                i= mapper.insertUser(user);
            }else {
                i=-1;
            }
       return i;
    }
}
