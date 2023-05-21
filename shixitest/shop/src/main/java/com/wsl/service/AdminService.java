package com.wsl.service;

import com.wsl.pojo.Admin;

public interface AdminService {
    Admin login(Admin admin);
    int register(Admin admin);
}
