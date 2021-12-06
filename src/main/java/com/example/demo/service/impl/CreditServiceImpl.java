package com.example.demo.service.impl;

import com.example.demo.service.CreditService;

import org.springframework.stereotype.Service;

import java.rmi.UnexpectedException;

/**
 * 功能描述
 *
 * @author KEVIN
 * @since 2021-12-06
 */
@Service
class CreditServiceImpl implements CreditService {
    @Override
    public int getUserCredit(Long userId) {
        throw new RuntimeException("not implemented.");
    }
}
