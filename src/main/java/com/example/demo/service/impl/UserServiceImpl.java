package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.entity.UserRepository;
import com.example.demo.service.CreditService;
import com.example.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 功能描述
 *
 * @author KEVIN
 * @since 2021-12-05
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userDao;

    @Autowired
    CreditService creditService;

    public Long addUser(User user) {
        userDao.save(user);
        Long id = user.getId();
        user.setName("1" + user.getName());
        userDao.save(user);
        return id;
    }

    @Override
    public User findIdAndName(Long userId, String nickname) {
        return userDao.findByIdAndName(userId, nickname);
    }

    @Override
    public int getUserCredit(Long userId) {
        return creditService.getUserCredit(userId);
    }
}
