package com.wsl.service;

import com.wsl.pojo.Userinfo;

public interface UserinfoService {
    Userinfo login(Userinfo user);
    int register(Userinfo user);
}
