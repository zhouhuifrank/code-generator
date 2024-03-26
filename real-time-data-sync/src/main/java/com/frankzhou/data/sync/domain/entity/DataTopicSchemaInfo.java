package com.frankzhou.data.sync.domain.entity;

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
 * @description topic_schema_info mapper
 * @date 2024-03-09
 */
@Data
@TableName(value ="data_topic_schema_info")
public class DataTopicSchemaInfo implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 自增id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * topic编号
     */
    @TableField(value = "topic_id")
    private Long topicId;

    /**
     * 字段名称
     */
    @TableField(value = "column_name")
    private String columnName;

    /**
     * 字段类型
     */
    @TableField(value = "column_type")
    private String columnType;

    /**
     * 创建人
     */
    @TableField(value = "create_user")
    private String createUser;

    /**
     * 更新人
     */
    @TableField(value = "update_user")
    private String updateUser;

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