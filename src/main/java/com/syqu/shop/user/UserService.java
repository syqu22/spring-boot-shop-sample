package com.syqu.shop.user;

public interface UserService {
    void save(User user);
    User findByUsername(String username);
    User findByEmail(String email);
    User findById(long id);
}
