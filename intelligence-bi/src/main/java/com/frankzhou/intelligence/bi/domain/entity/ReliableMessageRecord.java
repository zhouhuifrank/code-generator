package com.frankzhou.intelligence.bi.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 可靠消息记录实体类
 * @date 2024-03-01
 */
@TableName(value ="reliable_message_record")
@Data
public class ReliableMessageRecord implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 自增id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 消息类型
     */
    @TableField(value = "message_type")
    private String messageType;

    /**
     * 方法消息体
     */
    @TableField(value = "message_json")
    private String messageJson;

    /**
     * 消息状态
     */
    @TableField(value = "message_status")
    private Integer messageStatus;

    /**
     * 下次重试时间
     */
    @TableField(value = "next_retry_time")
    private Date nextRetryTime;

    /**
     * 重试次数
     */
    @TableField(value = "retry_count")
    private Integer retryCount;

    /**
     * 最大重试次数
     */
    @TableField(value = "max_retry_count")
    private Integer maxRetryCount;

    /**
     * 失败原因
     */
    @TableField(value = "fail_reason")
    private String failReason;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    private Date updateTime;

    /**
     * 数据状态
     */
    @TableField(value = "status")
    private String status;
}