package com.example.springboot.models.carpool.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 更新拼车信息DTO
 */
@Data
public class CarPoolUpdateDTO {
    /**
     * 主键ID
     */
    @NotNull(message = "ID不能为空")
    private Long id;

    /**
     * 出发地点ID
     */
    private Long departureLocationId;

    /**
     * 目的地ID
     */
    private Long destinationLocationId;

    /**
     * 类型
     */
    private Integer type;

    /**
     * 出发日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date departureDate;

    /**
     * 出发开始时间
     */
    @JsonFormat(pattern = "HH:mm:ss", timezone = "GMT+8")
    private Date departureStartTime;

    /**
     * 出发结束时间
     */
    @JsonFormat(pattern = "HH:mm:ss", timezone = "GMT+8")
    private Date departureEndTime;
}
