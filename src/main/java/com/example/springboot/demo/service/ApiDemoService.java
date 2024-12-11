package com.example.springboot.demo.service;

import com.example.springboot.demo.dto.DemoDto;
import org.springframework.stereotype.Service;

/**
 * 测试服务
 * @Author:
 * @Date:
 */

@Service
public class ApiDemoService {

    public String testPost(DemoDto dto) {
        return dto.getKey();
    }

    public String testGet() {
        return "Hello World";
    }
}
