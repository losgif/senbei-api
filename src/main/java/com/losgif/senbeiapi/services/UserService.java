package com.losgif.senbeiapi.services;

import com.baomidou.mybatisplus.extension.service.IService;
import com.losgif.senbeiapi.entities.User;
import com.losgif.senbeiapi.exceptions.UserNotFoundException;

public interface UserService extends IService<User> {
    User findOne(Long id) throws UserNotFoundException;

    User findByEmail(String email) throws UserNotFoundException;

    User create(User user);

    User update(User user);

    User delete(Long id);

    User login(String email, String password) throws UserNotFoundException;

    User logout(String email) throws UserNotFoundException;

    User changePassword(String email, String password) throws UserNotFoundException;

    User changeEmail(String email, String newEmail) throws UserNotFoundException;

    User changeName(String email, String name) throws UserNotFoundException;
}
