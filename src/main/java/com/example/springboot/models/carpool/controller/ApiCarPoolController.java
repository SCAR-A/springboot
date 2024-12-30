package com.example.springboot.models.carpool.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springboot.models.carpool.dto.CarPoolCreateDTO;
import com.example.springboot.models.carpool.dto.CarPoolUpdateDTO;
import com.example.springboot.models.carpool.entity.CarPoolPostsRecord;
import com.example.springboot.models.carpool.service.ApiCarPoolPostsService;
import com.example.springboot.models.common.api.ApiResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import static com.example.springboot.models.common.api.ApiResult.success;

/**
 * 拼车服务控制器
 * @author lq
 * @date 2024-7-18
 * @description 提供拼车相关的REST API接口
 */
@RestController
@RequestMapping("/api/car-pool")
public class ApiCarPoolController {
    @Resource
    private ApiCarPoolPostsService apiCarPoolPostsService;

    /**
     * 获取单个拼车信息
     */
    @GetMapping(value = "/get-list/{id}")
    public ApiResult getCarPool(@PathVariable Long id) {
        return success(apiCarPoolPostsService.getCarPoolList(id));
    }

    /**
     * 创建拼车信息
     */
    @PostMapping("/create")
    public ApiResult createCarPool(@RequestBody CarPoolCreateDTO createDTO) {
        return success(apiCarPoolPostsService.createCarPool(createDTO));
    }

    /**
     * 更新拼车信息
     */
    @PutMapping("/update")
    public ApiResult updateCarPool(@RequestBody CarPoolUpdateDTO updateDTO) {
        return success(apiCarPoolPostsService.updateCarPool(updateDTO));
    }

    /**
     * 删除拼车信息
     */
    @DeleteMapping("/delete/{id}")
    public ApiResult deleteCarPool(@PathVariable Long id) {
        return success(apiCarPoolPostsService.deleteCarPool(id));
    }

    /**
     * 分页获取拼车信息
     */
    @GetMapping("/page")
    public ApiResult getCarPoolPage(
            @RequestParam(defaultValue = "1") long page,
            @RequestParam(defaultValue = "10") long size) {
        return success(apiCarPoolPostsService.getCarPoolPage(page, size));
    }

    /**
     * 获取用户的拼车信息列表
     */
    @GetMapping("/user/{userId}")
    public ApiResult getUserCarPools(@PathVariable Long userId) {
        return success(apiCarPoolPostsService.getUserCarPools(userId));
    }

    /**
     * 更新拼车状态
     */
    @PutMapping("/{id}/status/{status}")
    public ApiResult updateCarPoolStatus(
            @PathVariable Long id,
            @PathVariable Integer status) {
        return success(apiCarPoolPostsService.updateCarPoolStatus(id, status));
    }
}
