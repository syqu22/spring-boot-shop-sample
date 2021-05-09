package com.syqu.shop.service;

import com.syqu.shop.domain.User;

public interface UserService {
    void save(User user);
    void login(String username, String password);
    User findByUsername(String username);
    User findByEmail(String email);
    User findById(long id);
}
