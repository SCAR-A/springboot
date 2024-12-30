package com.example.springboot.models.carpool.service;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springboot.models.carpool.dto.CarPoolCreateDTO;
import com.example.springboot.models.carpool.dto.CarPoolUpdateDTO;
import com.example.springboot.models.carpool.entity.CarPoolPostsRecord;
import com.example.springboot.models.common.api.ApiResult;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ApiCarPoolPostsService {

    @Resource
    private CarPoolPostsRecordService carPoolPostsRecordService;

    public CarPoolPostsRecord getCarPoolList(Long id) {
        return carPoolPostsRecordService.require(id);
    }

    /**
     * 创建拼车信息
     */
    public CarPoolPostsRecord createCarPool(CarPoolCreateDTO createDTO) {
        CarPoolPostsRecord record = new CarPoolPostsRecord();
        BeanUtils.copyProperties(createDTO, record);
        return carPoolPostsRecordService.create(record);
    }

    /**
     * 更新拼车信息
     */
    public CarPoolPostsRecord updateCarPool(CarPoolUpdateDTO updateDTO) {
        CarPoolPostsRecord record = new CarPoolPostsRecord();
        record.setId(IdWorker.getId());
        BeanUtils.copyProperties(updateDTO, record);
        return carPoolPostsRecordService.update(record);
    }

    /**
     * 删除拼车信息
     */
    public boolean deleteCarPool(Long id) {
        return carPoolPostsRecordService.delete(id);
    }

    /**
     * 分页获取拼车信息
     */
    public Page<CarPoolPostsRecord> getCarPoolPage(long page, long size) {
        return carPoolPostsRecordService.getPage(page, size);
    }

    /**
     * 获取用户的拼车信息列表
     */
    public List<CarPoolPostsRecord> getUserCarPools(Long userId) {
        return carPoolPostsRecordService.getByUserId(userId);
    }

    /**
     * 更新拼车状态
     */
    public CarPoolPostsRecord updateCarPoolStatus(Long id, Integer status) {
        return carPoolPostsRecordService.updateStatus(id, status);
    }
}
