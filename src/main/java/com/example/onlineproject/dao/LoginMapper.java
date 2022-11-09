package com.example.onlineproject.dao;

import com.example.onlineproject.entity.User;

public interface LoginMapper {


    void register(User user);

    int select(User user);

    int check(User user);
}
