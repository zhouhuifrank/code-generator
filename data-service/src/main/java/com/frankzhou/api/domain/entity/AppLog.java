package com.frankzhou.api.domain.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description app_log表的实体类
 * @date 2024-03-31
 */
@TableName(value ="app_log")
@Data
public class AppLog implements Serializable {
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
     * api接口名称
     */
    @TableField(value = "api_id")
    private Long apiId;

    /**
     * api名称
     */
    @TableField(value = "api_name")
    private String apiName;

    /**
     * api调用地址
     */
    @TableField(value = "api_url")
    private String apiUrl;

    /**
     * api版本号
     */
    @TableField(value = "api_version")
    private String apiVersion;

    /**
     * 请求ip地址
     */
    @TableField(value = "request_ip")
    private String requestIp;

    /**
     * 请求参数
     */
    @TableField(value = "request_param")
    private Object requestParam;

    /**
     * 响应参数
     */
    @TableField(value = "response_param")
    private Object responseParam;

    /**
     * 调用时间
     */
    @TableField(value = "invoke_time")
    private Integer invokeTime;

    /**
     * 执行SQL
     */
    @TableField(value = "execute_sql")
    private String executeSql;

    /**
     * 执行结果(1执行成功/2执行失败/3执行超时)
     */
    @TableField(value = "execute_result")
    private Integer executeResult;

    /**
     * 执行日志
     */
    @TableField(value = "execute_log")
    private String executeLog;

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