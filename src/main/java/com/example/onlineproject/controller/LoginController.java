package com.example.onlineproject.controller;

import com.example.onlineproject.common.annotional.Check;
import com.example.onlineproject.common.result.ResultBody;
import com.example.onlineproject.entity.User;
import com.example.onlineproject.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    /**
     * 模拟认证中心，真实环境中此接口应该是一个单独的服务，这里方便演示，用一个接口代替。
     *
     * 登录授权接口，登录成功后返回jwt
     */
    @PostMapping("/login")
    @ResponseBody
    public String login(HttpServletResponse response, HttpServletRequest request) {

        User user = new User();
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        user.setName(name);
        user.setPassword(password);
        ResultBody check = loginService.check(user);
        if (ResultBody.isSuccess(check.getCode())) {
            return "index";
        }
        return "login";

    }

    /**
     * 主业务服务的主接口，返回主页面。
     *
     * 自定义注解@Check，用于aop拦截对此方法的请求，校验jwt
     *
     */
    @GetMapping("/mainData")
    @Check(module="访问主界面")
    public Object mainData(){
        return  "主页面";
    }
}
