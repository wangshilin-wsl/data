package com.rms.service;

import com.rms.entity.User;

public interface UserService {
    void register(User user);
    User login(User user);
}
