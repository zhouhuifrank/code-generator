package com.frankzhou.api.domain.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description app_info表的实体类
 * @date 2024-03-31
 */
@TableName(value ="app_info")
@Data
public class AppInfo implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 自增id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 应用id
     */
    @TableField(value = "app_id")
    private Long appId;

    /**
     * 应用名称
     */
    @TableField(value = "app_name")
    private String appName;

    /**
     * 应用描述
     */
    @TableField(value = "app_desc")
    private String appDesc;

    /**
     * 应用唯一标识
     */
    @TableField(value = "app_key")
    private String appKey;

    /**
     * 应用密钥
     */
    @TableField(value = "app_secret")
    private String appSecret;

    /**
     * 应用ip地址
     */
    @TableField(value = "app_ip")
    private String appIp;

    /**
     * 应用负责人
     */
    @TableField(value = "app_liable_user")
    private String appLiableUser;

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