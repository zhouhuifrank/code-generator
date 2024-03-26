package com.frankzhou.api.domain.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description api数据表字段信息
 * @date 2024-03-24
 */
@TableName(value ="api_column")
@Data
public class ApiColumn implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 自增id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 表id
     */
    @TableField(value = "table_id")
    private Long tableId;

    /**
     * 字段id
     */
    @TableField(value = "column_id")
    private Long columnId;

    /**
     * 字段英文面
     */
    @TableField(value = "column_name_en")
    private String columnNameEn;

    /**
     * 字段中文名
     */
    @TableField(value = "column_name_cn")
    private String columnNameCn;

    /**
     * 字段注释
     */
    @TableField(value = "column_desc")
    private String columnDesc;

    /**
     * 数据类型
     */
    @TableField(value = "data_type")
    private String dataType;

    /**
     * 数据长度
     */
    @TableField(value = "data_length")
    private Integer dataLength;

    /**
     * 数据精度
     */
    @TableField(value = "data_precision")
    private Integer dataPrecision;

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