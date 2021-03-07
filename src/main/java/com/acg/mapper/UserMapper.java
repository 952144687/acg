package com.acg.mapper;

import com.acg.entity.User;

public interface UserMapper {
    public boolean addUser(User user);

    public  User queryUserByMail(User user);

    public User queryUserById(int u_id);
}
