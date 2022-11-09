package com.example.onlineproject.service.impl;

import com.example.onlineproject.common.result.ResultBody;
import com.example.onlineproject.dao.LoginMapper;
import com.example.onlineproject.entity.User;
import com.example.onlineproject.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public ResultBody register(User user) {
        int count = loginMapper.select(user);
        if (count>0){
            return ResultBody.alreadyRegister(user.getName()+",已经注册过","/login");
        }
        loginMapper.register(user);
        return ResultBody.login("注册成功,登录");
    }

    @Override
    public ResultBody check(User user) {
        int count = loginMapper.check(user);
        if (count > 0) {
            return ResultBody.success();
        }
        return ResultBody.login("去注册");
    }
}
