package com.example.springboot.models.carpool.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.springboot.models.common.serializer.LongJsonDeserializer;
import com.example.springboot.models.common.serializer.LongJsonSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * </p>
 *
 * @author lq
 * @since 2024-7-18 14:38:22
 */
@Getter
@Setter
@TableName("carpool_posts")
public class CarPoolPostsRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    @JsonSerialize(using = LongJsonSerializer.class)
    @JsonDeserialize(using = LongJsonDeserializer.class)
    private Long id;

    /**
     * 发布用户ID
     */
    @TableField("user_id")
    @JsonSerialize(using = LongJsonSerializer.class)
    @JsonDeserialize(using = LongJsonDeserializer.class)
    private Long userId;

    /**
     * 出发地点ID
     */
    @TableField("departure_location_id")
    @JsonSerialize(using = LongJsonSerializer.class)
    @JsonDeserialize(using = LongJsonDeserializer.class)
    private Long departureLocationId;

    /**
     * 目的地ID
     */
    @TableField("destination_location_id")
    @JsonSerialize(using = LongJsonSerializer.class)
    @JsonDeserialize(using = LongJsonDeserializer.class)
    private Long destinationLocationId;

    /**
     * type
     */
    @TableField("type")
    private Integer type;


    /**
     * departure_date
     */
    @TableField("departure_date")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date departureDate;

    /**
     * departure_start_time
     */
    @TableField("departure_start_time")
    @JsonFormat(pattern = "HH:mm:ss", timezone = "GMT+8")
    private Date departureStartTime;


    /**
     * departure_end_time
     */
    @TableField("departure_end_time")
    @JsonFormat(pattern = "HH:mm:ss", timezone = "GMT+8")
    private Date departureEndTime;


    /**
     * status
     */
    @TableField("status")
    private Integer status;


    /**
     * seats
     */
    @TableField("seats")
    private Integer seats;


    /**
     * price
     */
    @TableField("price")
    private Integer price;


    @TableField("notes")
    private String notes;


    /**
     * 创建时间
     */
    @TableField("created_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createdAt;

    /**
     * 更新时间
     */
    @TableField("updated_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updatedAt;
}
