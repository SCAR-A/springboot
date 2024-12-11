package com.example.springboot.demo.controller;


import com.example.springboot.demo.dto.DemoDto;
import com.example.springboot.demo.service.ApiDemoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 测试控制器
 * @author:
 * @date:
 * @description:
 */

@RestController
@RequestMapping("/api/demo")
public class ApiDemoController {
    @Resource
    private ApiDemoService apiDemoService;

    @PostMapping(value = "/test-post")
    public String testPost(DemoDto dto) {
        return apiDemoService.testPost(dto);
    }

    @GetMapping(value = "/test-get")
    public String testGet() {
        return apiDemoService.testGet();
    }
}
