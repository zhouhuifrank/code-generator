package com.frankzhou.api.domain.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description api_param_config表的实体类
 * @date 2024-03-31
 */
@TableName(value ="api_param_config")
@Data
public class ApiParamConfig implements Serializable {
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
     * 参数类型(REQUEST/RESPONSE/ORDER)
     */
    @TableField(value = "param_type")
    private String paramType;

    /**
     * 字段id
     */
    @TableField(value = "column_id")
    private Long columnId;

    /**
     * 字段名称
     */
    @TableField(value = "column_name")
    private String columnName;

    /**
     * 字段别名
     */
    @TableField(value = "column_name_alis")
    private String columnNameAlis;

    /**
     * 字段数据类型
     */
    @TableField(value = "column_data_type")
    private String columnDataType;

    /**
     * 字段操作符
     */
    @TableField(value = "column_operator")
    private String columnOperator;

    /**
     * 字段参数样例
     */
    @TableField(value = "column_example")
    private String columnExample;

    /**
     * 字段注释
     */
    @TableField(value = "column_comment")
    private String columnComment;

    /**
     * 是否必填(1必填/0不必填)
     */
    @TableField(value = "required_is")
    private Integer requiredIs;

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