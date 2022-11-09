package com.example.onlineproject.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping(value = "/test")
public class TestController {

    @Value("${server.port}")
    private String port;


    @RequestMapping(value = "/get/{id}")
    public String getById(@PathVariable("id") int id) {
        return port + "服务" + id + "";
    }
}