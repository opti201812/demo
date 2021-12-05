package com.example.demo.service;

import com.example.demo.entity.User;

/**
 * 功能描述
 *
 * @author KEVIN
 * @since 2021-12-05
 */
public interface UserService {
    Long addUser(User user);

    User findIdAndName(Long userId, String nickname);
}
