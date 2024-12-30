package com.example.springboot.models.carpool.service;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springboot.models.carpool.entity.CarPoolPostsRecord;
import com.example.springboot.models.carpool.entity.mapper.CarPoolPostsRecordMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Date;

/**
 * <p>
 * 拼车信息服务实现类
 * </p>
 *
 * @author lq
 * @since 2024-7-18 15:23:23
 */
@Service
@Slf4j
public class CarPoolPostsRecordService extends ServiceImpl<CarPoolPostsRecordMapper, CarPoolPostsRecord> {

    public static final String ASC = "asc";

    public CarPoolPostsRecord require(Long id) {
        return getById(id);
    }

    /**
     * 创建拼车信息
     *
     * @param record 拼车信息记录
     * @return 创建的记录
     */
    public CarPoolPostsRecord create(CarPoolPostsRecord record) {
        // 设置初始状态
        record.setStatus(1); // 1: 活跃状态
        save(record);
        return record;
    }

    /**
     * 更新拼车信息
     *
     * @param record 拼车信息记录
     * @return 更新后的记录
     */
    public CarPoolPostsRecord update(CarPoolPostsRecord record) {
        if (record.getId() == null) {
            throw new IllegalArgumentException("ID cannot be null for update operation");
        }
        
        // 检查记录是否存在
        CarPoolPostsRecord existing = getById(record.getId());
        if (existing == null) {
            throw new IllegalArgumentException("Carpool post not found with id: " + record.getId());
        }

        // 更新记录
        updateById(record);
        return getById(record.getId());
    }

    /**
     * 删除拼车信息
     *
     * @param id 记录ID
     * @return 是否删除成功
     */
    public boolean delete(Long id) {
        CarPoolPostsRecord existing = getById(id);
        if (existing == null) {
            return false;
        }
        return removeById(id);
    }

    /**
     * 分页查询拼车信息
     *
     * @param page 页码
     * @param size 每页大小
     * @return 分页结果
     */
    public Page<CarPoolPostsRecord> getPage(long page, long size) {
        Page<CarPoolPostsRecord> pageParam = new Page<>(page, size);
        return page(pageParam, Wrappers.<CarPoolPostsRecord>lambdaQuery()
                .orderByDesc(CarPoolPostsRecord::getDepartureDate));
    }

    /**
     * 根据用户ID获取拼车信息列表
     *
     * @param userId 用户ID
     * @return 拼车信息列表
     */
    public List<CarPoolPostsRecord> getByUserId(Long userId) {
        return list(Wrappers.<CarPoolPostsRecord>lambdaQuery()
                .eq(CarPoolPostsRecord::getUserId, userId)
                .orderByDesc(CarPoolPostsRecord::getDepartureDate));
    }

    /**
     * 更新拼车状态
     *
     * @param id 记录ID
     * @param status 新状态
     * @return 更新后的记录
     */
    public CarPoolPostsRecord updateStatus(Long id, Integer status) {
        CarPoolPostsRecord record = getById(id);
        if (record == null) {
            throw new IllegalArgumentException("Carpool post not found with id: " + id);
        }
        record.setStatus(status);
        updateById(record);
        return record;
    }
}
