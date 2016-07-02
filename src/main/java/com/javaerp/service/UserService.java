package com.javaerp.service;

import com.javaerp.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
