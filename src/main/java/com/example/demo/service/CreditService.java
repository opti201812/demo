package com.example.demo.service;

import org.springframework.stereotype.Service;

/**
 * 功能描述
 *
 * @author KEVIN
 * @since 2021-12-06
 */
@Service
public interface CreditService {
    int getUserCredit(Long userId);
}
