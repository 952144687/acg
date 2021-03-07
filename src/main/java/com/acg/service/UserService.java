package com.acg.service;

import com.acg.entity.User;

public interface UserService {
    public boolean addUser(User user);
    public  User queryUserByMail(User user);
    public User queryUserById(int u_id);
}
