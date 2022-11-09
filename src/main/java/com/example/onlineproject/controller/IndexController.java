package com.example.onlineproject.controller;

import com.example.onlineproject.common.annotional.Check;
import com.example.onlineproject.common.result.ResultBody;
import com.example.onlineproject.entity.User;
import com.example.onlineproject.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {


    @Autowired
    private LoginService loginService;

    @Autowired
    private RedisTemplate redisTemplate;


    @RequestMapping(value = {"", "/", "/index"}, method = RequestMethod.GET)
    @Check(module="访问主界面")
    public String index() {
       return "users/index";
    }

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String loginIndex() {
        return "users/login";
    }


    @RequestMapping(value = {"/register"}, method = RequestMethod.POST)
    @ResponseBody
    public ResultBody register(Model model,HttpServletRequest request) {
        User user = new User();
        user.setName(request.getParameter("name"));
        user.setPassword(request.getParameter("password"));
        return loginService.register(user);
    }


}
