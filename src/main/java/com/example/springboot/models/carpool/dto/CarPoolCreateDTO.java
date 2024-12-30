package com.example.springboot.models.carpool.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 创建拼车信息DTO
 */
@Data
public class CarPoolCreateDTO {
    /**
     * 发布用户ID
     */
    @NotNull(message = "用户ID不能为空")
    private Long userId;

    /**
     * 出发地点ID
     */
    @NotNull(message = "出发地点不能为空")
    private Long departureLocationId;

    /**
     * 目的地ID
     */
    @NotNull(message = "目的地不能为空")
    private Long destinationLocationId;

    /**
     * 类型
     */
    @NotNull(message = "类型不能为空")
    private Integer type;

    /**
     * 出发日期
     */
    @NotNull(message = "出发日期不能为空")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date departureDate;

    /**
     * 出发开始时间
     */
    @NotNull(message = "出发开始时间不能为空")
    @JsonFormat(pattern = "HH:mm:ss", timezone = "GMT+8")
    private Date departureStartTime;

    /**
     * 出发结束时间
     */
    @NotNull(message = "出发结束时间不能为空")
    @JsonFormat(pattern = "HH:mm:ss", timezone = "GMT+8")
    private Date departureEndTime;
}
