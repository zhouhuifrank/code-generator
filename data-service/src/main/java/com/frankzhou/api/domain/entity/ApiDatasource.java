package com.frankzhou.api.domain.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description api数据源信息
 * @date 2024-03-24
 */
@TableName(value ="api_datasource")
@Data
public class ApiDatasource implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 自增id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

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
     * 数据库类型
     */
    @TableField(value = "db_type")
    private String dbType;

    /**
     * 连接ip
     */
    @TableField(value = "connect_ip")
    private String connectIp;

    /**
     * 连接url
     */
    @TableField(value = "connect_url")
    private String connectUrl;

    /**
     * 连接用户
     */
    @TableField(value = "connect_user")
    private String connectUser;

    /**
     * 连接密码
     */
    @TableField(value = "connect_password")
    private String connectPassword;

    /**
     * 数据库描述
     */
    @TableField(value = "db_desc")
    private String dbDesc;

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