package com.example.demo.entity;

import com.example.demo.annotation.MinId;

import javax.validation.constraints.NotNull;

public class TestUser {
    @NotNull(message="Missing name")
    public String name;
    @NotNull(message="Missing id")
    @MinId(min=5)
    public Integer id;
}
