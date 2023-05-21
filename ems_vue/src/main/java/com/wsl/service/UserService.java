package com.wsl.service;

import com.wsl.entity.User;

public interface UserService {
    void register(User user);
    User login(User user);
}
