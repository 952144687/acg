package com.acg.service.impl;



import com.acg.entity.User;
import com.acg.mapper.UserMapper;
import com.acg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired(required = false)
    private UserMapper userMapper;

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }


    @Override
    public boolean addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public User queryUserByMail(User user) {
        return userMapper.queryUserByMail(user);
    }

    @Override
    public User queryUserById(int u_id) {
        return userMapper.queryUserById(u_id);
    }
}
