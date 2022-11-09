package com.example.onlineproject.entity;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class User {
    @NotNull(message = "用户名不能为空")
    private String name;
    @NotNull(message = "密码不能为空")
    private String password;
}
