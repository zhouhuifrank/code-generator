package com.frankzhou.api.domain.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description app_api表的实体类
 * @date 2024-03-31
 */
@TableName(value ="app_api")
@Data
public class AppApi implements Serializable {
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
     * api接口id
     */
    @TableField(value = "api_id")
    private Long apiId;

    /**
     * api版本
     */
    @TableField(value = "api_version")
    private String apiVersion;

    /**
     * 申请状态(1待审批/2申请通过/3申请未通过)
     */
    @TableField(value = "apply_status")
    private Integer applyStatus;

    /**
     * 申请描述
     */
    @TableField(value = "apply_desc")
    private String applyDesc;

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