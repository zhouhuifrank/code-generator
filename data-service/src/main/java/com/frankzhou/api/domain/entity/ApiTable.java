package com.frankzhou.api.domain.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description api数据表信息
 * @date 2024-03-24
 */
@TableName(value ="api_table")
@Data
public class ApiTable implements Serializable {
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
     * 表id
     */
    @TableField(value = "table_id")
    private Long tableId;

    /**
     * 表英文名
     */
    @TableField(value = "table_name_en")
    private String tableNameEn;

    /**
     * 表中文名
     */
    @TableField(value = "table_name_cn")
    private String tableNameCn;

    /**
     * 备注信息
     */
    @TableField(value = "table_desc")
    private String tableDesc;

    /**
     * 更新频率
     */
    @TableField(value = "renewal_frequency")
    private Integer renewalFrequency;

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