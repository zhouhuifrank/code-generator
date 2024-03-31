package com.frankzhou.api.domain.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description api_execute_sql表的实体类
 * @date 2024-03-31
 */
@TableName(value ="api_execute_sql")
@Data
public class ApiExecuteSql implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 自增id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * api接口id
     */
    @TableField(value = "api_id")
    private Long apiId;

    /**
     * api版本号
     */
    @TableField(value = "api_version")
    private String apiVersion;

    /**
     * 执行SQL
     */
    @TableField(value = "execute_sql")
    private String executeSql;

    /**
     * 创建人
     */
    @TableField(value = "create_user")
    private String createUser;

    /**
     * 修改人
     */
    @TableField(value = "update_user")
    private String updateUser;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @TableField(value = "update_time")
    private Date updateTime;

    /**
     * 状态
     */
    @TableLogic
    private String status;
}