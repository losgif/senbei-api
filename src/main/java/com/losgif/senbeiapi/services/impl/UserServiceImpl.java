package com.losgif.senbeiapi.services.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.losgif.senbeiapi.entities.User;
import com.losgif.senbeiapi.exceptions.UserNotFoundException;
import com.losgif.senbeiapi.mappers.UserMapper;
import com.losgif.senbeiapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User findOne(Long id) throws UserNotFoundException {
        return userMapper.selectById(id);
    }

    @Override
    public User findByEmail(String email) throws UserNotFoundException {
        return null;
    }

    @Override
    public User create(User user) {
        return null;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public User delete(Long id) {
        return null;
    }

    @Override
    public User login(String email, String password) throws UserNotFoundException {
        User user = userMapper.selectByEmailAndPassword(email, password);

        if (user == null) {
            throw new UserNotFoundException();
        }

        return user;
    }

    @Override
    public User logout(String email) throws UserNotFoundException {
        return null;
    }

    @Override
    public User changePassword(String email, String password) throws UserNotFoundException {
        return null;
    }

    @Override
    public User changeEmail(String email, String newEmail) throws UserNotFoundException {
        return null;
    }

    @Override
    public User changeName(String email, String name) throws UserNotFoundException {
        return null;
    }
}
