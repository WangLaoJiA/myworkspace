package com.example.onlineproject.service;

import com.example.onlineproject.common.result.ResultBody;
import com.example.onlineproject.entity.User;

public interface LoginService {

    ResultBody register(User user);

    ResultBody check(User user);
}
