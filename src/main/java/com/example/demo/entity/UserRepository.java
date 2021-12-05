package com.example.demo.entity;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 功能描述
 *
 * @author KEVIN
 * @since 2021-12-05
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByIdAndName(Long id, String name);

}
