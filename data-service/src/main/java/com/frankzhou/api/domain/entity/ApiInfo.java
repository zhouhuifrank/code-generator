package com.frankzhou.api.domain.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description api_info表的实体类
 * @date 2024-03-31
 */
@TableName(value ="api_info")
@Data
public class ApiInfo implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 自增id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 分组id
     */
    @TableField(value = "group_id")
    private Long groupId;

    /**
     * api接口id
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
     * 请求方法
     */
    @TableField(value = "request_method")
    private String requestMethod;

    /**
     * 请求超时时间
     */
    @TableField(value = "request_timeout")
    private Integer requestTimeout;

    /**
     * 响应类型
     */
    @TableField(value = "response_type")
    private String responseType;

    /**
     * 更新频率
     */
    @TableField(value = "renewal_frequency")
    private String renewalFrequency;

    /**
     * 生成类型
     */
    @TableField(value = "generate_type")
    private String generateType;

    /**
     * 鉴权方式
     */
    @TableField(value = "authenticate_type")
    private String authenticateType;

    /**
     * 数据源id
     */
    @TableField(value = "datasource_id")
    private Long datasourceId;

    /**
     * 数据源名称
     */
    @TableField(value = "datasource_name")
    private String datasourceName;

    /**
     * 逻辑表id
     */
    @TableField(value = "table_id")
    private Long tableId;

    /**
     * 逻辑表名称
     */
    @TableField(value = "table_name")
    private String tableName;

    /**
     * 是否当前版本
     */
    @TableField(value = "current_version_is")
    private Integer currentVersionIs;

    /**
     * api版本号
     */
    @TableField(value = "api_version")
    private String apiVersion;

    /**
     * api状态
     */
    @TableField(value = "api_status")
    private String apiStatus;

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